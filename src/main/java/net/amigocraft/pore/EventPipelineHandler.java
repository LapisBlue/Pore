package net.amigocraft.pore;

import net.amigocraft.pore.implementation.PoreChunk;
import net.amigocraft.pore.implementation.PoreWorld;
import org.bukkit.Bukkit;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.world.*;

public class EventPipelineHandler {

	@SpongeEventHandler
	public void onChunkLoad(ChunkLoadEvent event) { //TODO: instanceof WorldEvent according to Bukkit, but not Sponge. wat do?
		//TODO: fix second argument when Sponge makes it possible
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkLoadEvent(new PoreChunk(event.chunk), false));
	}

	@SpongeEventHandler
	public void onChunkUnload(ChunkUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.ChunkUnloadEvent(new PoreChunk(event.chunk)));
	}

	@SpongeEventHandler
	public void onWorldEvent(WorldLoadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldLoadEvent(new PoreWorld(event.world)));
	}

	@SpongeEventHandler
	public void onWorldUnload(WorldUnloadEvent event) {
		Bukkit.getPluginManager().callEvent(new org.bukkit.event.world.WorldUnloadEvent(new PoreWorld(event.world)));
	}

}
