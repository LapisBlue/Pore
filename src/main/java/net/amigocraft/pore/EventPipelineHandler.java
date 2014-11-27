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

import net.amigocraft.pore.implementation.PoreChunk;
import net.amigocraft.pore.implementation.PoreWorld;
import net.amigocraft.pore.implementation.entity.PorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spongepowered.api.util.event.Subscribe;
import org.spongepowered.api.event.player.PlayerChatEvent;
import org.spongepowered.api.event.world.ChunkLoadEvent;
import org.spongepowered.api.event.world.ChunkUnloadEvent;
import org.spongepowered.api.event.world.WorldLoadEvent;
import org.spongepowered.api.event.world.WorldUnloadEvent;

import java.util.HashSet;

public class EventPipelineHandler {

	@Subscribe
	public void onChunkLoad(ChunkLoadEvent event) { //TODO: instanceof WorldEvent according to Bukkit, but not Sponge
		//TODO: fix second argument when Sponge makes it possible
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkLoadEvent(PoreChunk.of(event.getChunk()), false));
	}

	@Subscribe
	public void onChunkUnload(ChunkUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkUnloadEvent(PoreChunk.of(event.getChunk())));
	}

	@Subscribe
	public void onWorldEvent(WorldLoadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldLoadEvent(PoreWorld.of(event.getWorld())));
	}

	@Subscribe
	public void onWorldUnload(WorldUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldUnloadEvent(PoreWorld.of(event.getWorld())));
	}

	@Subscribe
	public void onPlayerChat(PlayerChatEvent event) {
		Bukkit.getPluginManager().callEvent(
				new org.bukkit.event.player.AsyncPlayerChatEvent(
						false, PorePlayer.of(event.getPlayer()), event.getMessage(), new HashSet<Player>())); //TODO
	}

}
