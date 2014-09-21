package net.amigocraft.pore;

import net.amigocraft.pore.implementation.PoreServer;

import org.bukkit.Bukkit;
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
	private PoreServer server;

	@SpongeEventHandler
	public void onInitialization(SpongeInitializationEvent event) {
		server = new PoreServer(((Event)event).getGame());
		Bukkit.setServer(server); //Set the Bukkit API to use our server instance

		System.out.println("[Pore] Loading Bukkit plugins, please wait...");

		// Load plugins
		server.loadPlugins();
		server.enablePlugins();

		System.out.println("[Pore] Finished loading Bukkit plugins!");
		System.out.println("Enabling loaded plugins...");
	}

	@SpongeEventHandler
	public void onShutdown(SpongeServerStoppingEvent event){
		// clear static references
		server = null;
	}
}
