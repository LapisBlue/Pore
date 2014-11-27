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
import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.util.event.Subscribe;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

/**
 * @author Maxim Roncacé, Lapis Blue
 */
@Plugin(id = "pore", name = "Pore")
public class Pore {
	private static Pore instance;
	private static Logger logger;
	private static PoreServer server;

	@Subscribe
	public void onInitialization(PreInitializationEvent event) {
		instance = this;
		logger = event.getPluginLog();

		getLogger().info("Loading Pore server, please wait...");
		server = new PoreServer(event.getGame());
		// TODO: Enable plugins
	}

	@Subscribe
	public void onShutdown(ServerStoppingEvent event){
		logger.info("Disabling Bukkit plugins, please wait...");
		server.disablePlugins();
		logger.info("Finished disabling Bukkit plugins!");

		instance = null;
		server = null;
		logger = null;
	}

	public static Pore getInstance() {
		return instance;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static PoreServer getServer() {
		return server;
	}

	public static Game getGame() {
		return server.getHandle();
	}

	public static PluginContainer getPlugin(org.bukkit.plugin.Plugin plugin) {
		throw new NotImplementedException(); // TODO
	}

	@Subscribe
    public void onCommand(CommandEvent event) {
//        for (org.bukkit.plugin.Plugin plugin : server.getPluginManager().getPlugins()) {
//            // Call plugin.onCommand() with appropriate params.
//        }
    }
}
