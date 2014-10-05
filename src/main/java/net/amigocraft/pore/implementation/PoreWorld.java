package net.amigocraft.pore.implementation;

import net.amigocraft.pore.implementation.block.PoreBlock;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.*;

import java.io.File;
import java.util.*;

public class PoreWorld implements World {

	private static WeakHashMap<org.spongepowered.api.world.World, PoreWorld> instances =
			new WeakHashMap<org.spongepowered.api.world.World, PoreWorld>();

	protected org.spongepowered.api.world.World handle;

	private PoreWorld(org.spongepowered.api.world.World handle) {
		this.handle = handle;
		instances.put(handle, this);
	}

	//TODO: This class is somewhat of an guinea pig. We might change how we do this in the future.
	/**
	 * Gets a new instance of the class from the given handle. If possible, an existing instance will be reused;
	 * otherwise, a new one will be created.
	 * @return the retrieved or created instance.
	 */
	public static PoreWorld getInstance(org.spongepowered.api.world.World handle){
		if (!instances.containsKey(handle)) {
			return new PoreWorld(handle);
		}
		else {
			return instances.get(handle);
		}
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		//return new PoreBlock(handle.getBlock(x, y, z));
		throw new NotImplementedException();
	}

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		throw new NotImplementedException();
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
		//return new PoreChunk(handle.getChunk(x, z));
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
		//handle.loadChunk(x, z, true);
		throw new NotImplementedException();
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		//return handle.loadChunk(x, z, generate) != null;
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		throw new NotImplementedException();
	}

	@Override
	public List<Player> getPlayers() {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		return handle.getName();
	}

	@Override
	public UUID getUID() {
		return handle.getUniqueID();
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
		throw new NotImplementedException();
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
		return new String[0];
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
