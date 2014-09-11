package net.amigocraft.pore;

import net.amigocraft.pore.implementation.PoreChunk;
import net.amigocraft.pore.implementation.PoreWorld;
import net.amigocraft.pore.implementation.entity.PorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.*;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.entity.*;
import org.spongepowered.api.event.player.AsyncPlayerChatEvent;
import org.spongepowered.api.event.world.*;

import java.util.HashSet;
import java.util.Set;

public class EventPipelineHandler {

	@SpongeEventHandler
	public void onChunkLoad(ChunkLoadEvent event) { //TODO: instanceof WorldEvent according to Bukkit, but not Sponge
		//TODO: fix second argument when Sponge makes it possible
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkLoadEvent(new PoreChunk(event.getChunk()), false));
	}

	@SpongeEventHandler
	public void onChunkUnload(ChunkUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkUnloadEvent(new PoreChunk(event.getChunk())));
	}

	@SpongeEventHandler
	public void onWorldEvent(WorldLoadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldLoadEvent(new PoreWorld(event.getWorld())));
	}

	@SpongeEventHandler
	public void onWorldUnload(WorldUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldUnloadEvent(new PoreWorld(event.getWorld())));
	}

    @SpongeEventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event){
        Bukkit.getPluginManager().callEvent(
				new org.bukkit.event.player.AsyncPlayerChatEvent(
						false, new PorePlayer(event.getPlayer()), event.getMessage(), new HashSet<Player>())); //TODO
    }

}
