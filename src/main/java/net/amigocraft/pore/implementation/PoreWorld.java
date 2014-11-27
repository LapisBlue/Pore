package net.amigocraft.pore.implementation;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.amigocraft.pore.implementation.block.PoreBlock;
import net.amigocraft.pore.implementation.entity.PoreEntity;
import net.amigocraft.pore.implementation.entity.PoreLivingEntity;
import net.amigocraft.pore.implementation.entity.PorePlayer;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.PoreCollections;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vectors;
import org.spongepowered.api.world.extent.Extent;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PoreWorld extends PoreWrapper<org.spongepowered.api.world.World> implements World {
	private static TypeConverter<org.spongepowered.api.world.World, PoreWorld> converter;

	static TypeConverter<org.spongepowered.api.world.World, PoreWorld> getConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.world.World, PoreWorld>() {
				@Override
				protected PoreWorld convert(org.spongepowered.api.world.World handle) {
					return new PoreWorld(handle);
				}
			};
		}

		return converter;
	}

	protected PoreWorld(org.spongepowered.api.world.World handle) {
		super(handle);
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWorld of(org.spongepowered.api.world.World handle) {
		return getConverter().apply(handle);
	}

	public static PoreWorld of(Extent handle) {
		if (handle instanceof org.spongepowered.api.world.World) {
			return of((org.spongepowered.api.world.World) handle);
		}
		throw new UnsupportedOperationException(); // TODO
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return PoreBlock.of(getHandle().getBlock(x, y, z));
	}

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return getBlockAt(x, y, z).getTypeId();
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		throw new NotImplementedException();
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		throw new NotImplementedException();
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		Optional<org.spongepowered.api.world.Chunk> chunk = getHandle().getChunk(Vectors.create2i(x, z));
		return chunk.isPresent() ? PoreChunk.of(chunk.get()) : null;
	}

	@Override
	public Chunk getChunkAt(Location location) {
		return getChunkAt(location.getBlockX(), location.getBlockZ());
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		throw new NotImplementedException();
	}

	@Override
	public Chunk[] getLoadedChunks() {
		throw new NotImplementedException();
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isChunkInUse(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public void loadChunk(int x, int z) {
		loadChunk(x, z, true);
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		getHandle().loadChunk(Vectors.create2i(x, z), generate);
		return true; //TODO
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return chunk.unload();
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return unloadChunk(x, z, true);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return unloadChunk(x, z, save, false);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return getChunkAt(x, z).unload(save, safe);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		throw new NotImplementedException();
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public Item dropItem(Location location, ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
		throw new NotImplementedException();
	}

	@Override
	public boolean generateTree(Location location, TreeType type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		throw new NotImplementedException();
	}

	@Override
	public Entity spawnEntity(Location loc, EntityType type) {
		throw new NotImplementedException();
	}

	@Override
	public LivingEntity spawnCreature(Location loc, EntityType type) {
		throw new NotImplementedException();
	}

	@Override
	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		throw new NotImplementedException();
	}

	@Override
	public LightningStrike strikeLightning(Location loc) {
		throw new NotImplementedException();
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc) {
		throw new NotImplementedException();
	}

	@Override
	public List<Entity> getEntities() {
		// TODO: Should this be unmodifiable?
		return PoreCollections.<org.spongepowered.api.entity.Entity, Entity>transformToList(
				getHandle().getEntities(), PoreEntity.getConverter()
		);
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		// This is basically copying every time, unfortunately there is no real better way because we can't filter
		// Lists using Guava
		List<LivingEntity> living = Lists.newArrayList();
		for (org.spongepowered.api.entity.Entity e : getHandle().getEntities()) {
			if (e instanceof org.spongepowered.api.entity.living.Living) {
				living.add(PoreLivingEntity.of((org.spongepowered.api.entity.living.Living) e));
			}
		}
		return living;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		return (Collection<T>) Collections2.filter(getEntities(), Predicates.instanceOf(cls));
	}

	@Override
	@SuppressWarnings("unchecked")
	@Deprecated
	public <T extends Entity> Collection<T> getEntitiesByClass(final Class<T>... classes) {
		return (Collection<T>) getEntitiesByClasses(classes);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Entity> getEntitiesByClasses(final Class<?>... classes) {
		return Collections2.filter(getEntities(), new Predicate<Entity>() {
			@Override
			public boolean apply(@Nullable Entity entity) {
				for (Class<?> clazz : classes) {
					if (clazz.isInstance(entity))
						return true;
				}

				return false;
			}
		});
	}

	@Override
	public List<Player> getPlayers() {
		//TODO: possibly optimize this (there is no real way other than Sponge implementing something to help with that)
		// see getLivingEntities() for explanation
		List<Player> players = Lists.newArrayList();
		for (org.spongepowered.api.entity.Entity e : getHandle().getEntities()){
			if (e instanceof org.spongepowered.api.entity.player.Player){
				players.add(PorePlayer.of((org.spongepowered.api.entity.player.Player) e));
			}
		}
		return players;
	}

	@Override
	public String getName() {
		return getHandle().getName();
	}

	@Override
	public UUID getUID() {
		return getHandle().getUniqueID();
	}

	@Override
	public Location getSpawnLocation() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public long getTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setTime(long time) {
		throw new NotImplementedException();
	}

	@Override
	public long getFullTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setFullTime(long time) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasStorm() {
		throw new NotImplementedException();
	}

	@Override
	public void setStorm(boolean hasStorm) {
		throw new NotImplementedException();
	}

	@Override
	public int getWeatherDuration() {
		throw new NotImplementedException();
	}

	@Override
	public void setWeatherDuration(int duration) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isThundering() {
		throw new NotImplementedException();
	}

	@Override
	public void setThundering(boolean thundering) {
		throw new NotImplementedException();
	}

	@Override
	public int getThunderDuration() {
		throw new NotImplementedException();
	}

	@Override
	public void setThunderDuration(int duration) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		throw new NotImplementedException();
	}

	@Override
	public Environment getEnvironment() {
		throw new NotImplementedException();
	}

	@Override
	public long getSeed() {
		throw new NotImplementedException();
	}

	@Override
	public boolean getPVP() {
		throw new NotImplementedException();
	}

	@Override
	public void setPVP(boolean pvp) {
		throw new NotImplementedException();
	}

	@Override
	public ChunkGenerator getGenerator() {
		throw new NotImplementedException();
	}

	@Override
	public void save() {
		throw new NotImplementedException();
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		throw new NotImplementedException();
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		throw new NotImplementedException();
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		throw new NotImplementedException();
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		throw new NotImplementedException();
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		throw new NotImplementedException();
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getAllowAnimals() {
		throw new NotImplementedException();
	}

	@Override
	public boolean getAllowMonsters() {
		throw new NotImplementedException();
	}

	@Override
	public Biome getBiome(int x, int z) {
		//return handle.getBiome(Vectors.create3d(x, 0, z)); //TODO: needs to be wrapped (should we map biomes?)
		throw new NotImplementedException();
	}

	@Override
	public void setBiome(int x, int z, Biome bio) {
		throw new NotImplementedException();
	}

	@Override
	public double getTemperature(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public double getHumidity(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaxHeight() {
		throw new NotImplementedException();
	}

	@Override
	public int getSeaLevel() {
		throw new NotImplementedException();
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		throw new NotImplementedException();
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAutoSave() {
		throw new NotImplementedException();
	}

	@Override
	public void setAutoSave(boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		throw new NotImplementedException();
	}

	@Override
	public Difficulty getDifficulty() {
		throw new NotImplementedException();
	}

	@Override
	public File getWorldFolder() {
		return new File(Bukkit.getWorldContainer(), getHandle().getName()); //TODO: not sure this will always work
	}

	@Override
	public WorldType getWorldType() {
		throw new NotImplementedException();
	}

	@Override
	public boolean canGenerateStructures() {
		throw new NotImplementedException();
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		throw new NotImplementedException();
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		throw new NotImplementedException();
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		throw new NotImplementedException();
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		throw new NotImplementedException();
	}

	@Override
	public int getMonsterSpawnLimit() {
		throw new NotImplementedException();
	}

	@Override
	public void setMonsterSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getAnimalSpawnLimit() {
		throw new NotImplementedException();
	}

	@Override
	public void setAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		throw new NotImplementedException();
	}

	@Override
	public void setWaterAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getAmbientSpawnLimit() {
		throw new NotImplementedException();
	}

	@Override
	public void setAmbientSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public void playSound(Location location, Sound sound, float volume, float pitch) {
		throw new NotImplementedException();
	}

	@Override
	public String[] getGameRules() {
		throw new NotImplementedException();
	}

	@Override
	public String getGameRuleValue(String rule) {
		throw new NotImplementedException();
	}

	@Override
	public boolean setGameRuleValue(String rule, String value) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isGameRule(String rule) {
		throw new NotImplementedException();
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new NotImplementedException();
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new NotImplementedException();
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new NotImplementedException();
	}
}
