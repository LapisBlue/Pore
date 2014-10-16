/**
 * This file is a part of Pore, licensed under the MIT License.
 *
 * Copyright (c) Maxim Roncacé
 * Copyright (c) Lapis Blue
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.amigocraft.pore;

import net.amigocraft.pore.implementation.PoreServer;

import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

/**
 * @author Maxim Roncacé, Lapis Blue
 */
@Plugin(id = "pore", name = "Pore")
public class Main {

	private static PoreServer server;

	public static Logger logger;

	@SpongeEventHandler
	public void onInitialization(PreInitializationEvent event) {
		server = PoreServer.of(event.getGame());
		Bukkit.setServer(server); // set the Bukkit API to use our server instance

		logger = event.getPluginLog();

		logger.info("Loading Bukkit plugins, please wait...");

		// Load plugins
		server.loadPlugins();
		server.enablePlugins();

		logger.info("Finished loading Bukkit plugins!");
		logger.info("Enabling loaded plugins...");
	}

	@SpongeEventHandler
	public void onShutdown(ServerStoppingEvent event){
		logger.info("Disabling Bukkit plugins, please wait...");
		server.disablePlugins();
		logger.info("Finished disabling Bukkit plugins!");
		//TODO: clear static references
		server = null;
	}

    @SpongeEventHandler
    public void onCommand(CommandEvent event) {
//        for (org.bukkit.plugin.Plugin plugin : server.getPluginManager().getPlugins()) {
//            // Call plugin.onCommand() with appropriate params.
//        }
    }
}
