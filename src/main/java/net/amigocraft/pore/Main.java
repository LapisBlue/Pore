package net.amigocraft.pore;

import net.amigocraft.pore.implementation.PoreServer;
import org.bukkit.Server;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
public class Main {

	private static Server server;
	private static PluginLoader loader;

	private static List<JavaPlugin> plugins = new ArrayList<JavaPlugin>();

	public static void initialize(){
		//TODO: initialize as plugin

		server = new PoreServer();
		loader = new JavaPluginLoader(server);

		File serverDir = null; //TODO: use actual server directory
		File bukkitDir = new File(serverDir, "bukkit-plugins");
		for (File f : bukkitDir.listFiles()){
			if (!f.isDirectory() && f.getName().endsWith(".jar")){
				try {
					JarFile pluginJar = new JarFile(f); // get JAR
					ZipEntry pluginDesc = pluginJar.getEntry("plugin.yml"); // get plugin description
					if (pluginDesc == null){ // not a plugin
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
					plugin.onEnable(); // synthesize the standard onEnable call
					plugins.add(plugin);
				}
				catch (InvalidDescriptionException ex){
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load plugin description for " + f.getName() + "!");
				}
				catch (MalformedURLException ex){
					ex.printStackTrace();
					System.err.println("[Pore] An exception occurred while loading " + f.getName());
				}
				catch (ClassNotFoundException ex){
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load main class for " + f.getName() + "!");
				}
				catch (IOException ex){
					ex.printStackTrace();
					System.err.println("[Pore] Failed to load " + f.getName() + "!");
				}
			}
		}
	}

	private static InputStream getInputStream(File zip, String entry) throws IOException {
		ZipInputStream zin = new ZipInputStream(new FileInputStream(zip));
		for (ZipEntry e; (e = zin.getNextEntry()) != null;) {
			if (e.getName().equals(entry)) {
				return zin;
			}
		}
		throw new EOFException("Cannot find " + entry);
	}

	//TODO: disable plugins

}
