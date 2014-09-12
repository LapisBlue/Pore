package net.amigocraft.pore;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import net.amigocraft.pore.implementation.PoreServer;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.SpongeInitializationEvent;
import org.spongepowered.api.event.state.SpongeServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

/**
 * @author Maxim Roncacé
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
@Plugin(id = "Pore", name = "Pore")
public class Main {

	private Server server;
	private PluginLoader loader;

	private List<org.bukkit.plugin.Plugin> plugins = new ArrayList<org.bukkit.plugin.Plugin>();

	@SpongeEventHandler
	public void onInitialization(SpongeInitializationEvent event) {

		server = new PoreServer(((Event)event).getGame());

		Bukkit.setServer(server); //Set the Bukkit API to use our server instance

		System.out.println("[Pore] Loading Bukkit plugins, please wait...");

		File serverDir = new File("."); //TODO: use actual server directory, currently set to working directory
		File bukkitDir = new File(serverDir, "bukkit-plugins");
		/*for (File f : bukkitDir.listFiles()) {
			if (!f.isDirectory() && f.getName().endsWith(".jar")) {
				try {
					plugins.add(loader.loadPlugin(f));
					JarFile pluginJar = new JarFile(f); // get JAR
					ZipEntry pluginDesc = pluginJar.getEntry("plugin.yml"); // get plugin description
					if (pluginDesc == null) { // not a plugin
						System.err.println("[Pore] Failed to load plugin.yml for " + f.getName() + "!");
						continue;
					}
					PluginDescriptionFile pdf = new PluginDescriptionFile(getInputStream(f, "plugin.yml"));
					String main = pdf.getMain();
					ClassLoader cLoader = URLClassLoader.newInstance(
							new URL[]{f.toURI().toURL()},
							Main.class.getClassLoader()
					); // get Pore's classloader
					Class<?> clazz = Class.forName(main, true, cLoader); // get the main class
					Class<? extends JavaPlugin> pluginClass = clazz.asSubclass(JavaPlugin.class);
					JavaPlugin plugin = pluginClass.cast(new JavaPlugin(loader, server, pdf, new File(bukkitDir, pdf.getName()), f));
					plugins.add(plugin);
				}
				catch (InvalidPluginException ex) {
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load plugin " + f.getName() + "!");
				}
				/*catch (InvalidDescriptionException ex) {
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load plugin description for " + f.getName() + "!");
				}
				catch (MalformedURLException ex) {
					ex.printStackTrace();
					System.err.println("[Pore] An exception occurred while loading " + f.getName());
				}
				catch (ClassNotFoundException ex) {
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load main class for " + f.getName() + "!");
				}
				catch (IOException ex) {
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load " + f.getName() + "!");
				}
			}
		}*/

		server.getPluginManager().loadPlugins(bukkitDir);

		System.out.println("[Pore] Finished loading Bukkit plugins!");
		System.out.println("Enabling loaded plugins...");

		for (org.bukkit.plugin.Plugin plugin : plugins) {
			loader.enablePlugin(plugin);
		}
	}

	@SpongeEventHandler
	public void onShutdown(SpongeServerStoppingEvent event){
		for (org.bukkit.plugin.Plugin plugin : plugins){
			loader.disablePlugin(plugin);
		}

		// clear static references
		plugins.clear();
		loader = null;
		server = null;
	}

	private static InputStream getInputStream(File zip, String entry) throws IOException {
		ZipInputStream zin = new ZipInputStream(new FileInputStream(zip));
		for (ZipEntry e; (e = zin.getNextEntry()) != null; ) {
			if (e.getName().equals(entry)) {
				return zin;
			}
		}
		throw new EOFException("Cannot find " + entry);
	}

}
