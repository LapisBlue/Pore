package net.amigocraft.pore.implementation;

import net.amigocraft.pore.implementation.block.PoreBlock;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PoreWorld implements World {
	private org.spongepowered.api.world.World handle;

	public PoreWorld(org.spongepowered.api.world.World spongeWorld) {
		this.handle = spongeWorld;
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return new PoreBlock(handle.getBlock(x, y, z));
	}

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return 0;
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return 0;
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		return 0;
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
		return new PoreChunk(handle.getChunk(x, z));
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
		return false;
	}

	@Override
	public Chunk[] getLoadedChunks() {
		return new Chunk[0];
	}

	@Override
	public void loadChunk(Chunk chunk) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		return false;
	}

	@Override
	public boolean isChunkInUse(int x, int z) {
		return false;
	}

	@Override
	public void loadChunk(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		return false;
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return false;
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		return false;
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		return false;
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		return false;
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		return false;
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
		return false;
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		return false;
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
		return false;
	}

	@Override
	public long getTime() {
		return 0;
	}

	@Override
	public void setTime(long time) {
		throw new NotImplementedException();
	}

	@Override
	public long getFullTime() {
		return 0;
	}

	@Override
	public void setFullTime(long time) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasStorm() {
		return false;
	}

	@Override
	public void setStorm(boolean hasStorm) {
		throw new NotImplementedException();
	}

	@Override
	public int getWeatherDuration() {
		return 0;
	}

	@Override
	public void setWeatherDuration(int duration) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isThundering() {
		return false;
	}

	@Override
	public void setThundering(boolean thundering) {
		throw new NotImplementedException();
	}

	@Override
	public int getThunderDuration() {
		return 0;
	}

	@Override
	public void setThunderDuration(int duration) {
		throw new NotImplementedException();
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return false;
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		return false;
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
		return false;
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		return false;
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		return false;
	}

	@Override
	public Environment getEnvironment() {
		throw new NotImplementedException();
	}

	@Override
	public long getSeed() {
		return 0;
	}

	@Override
	public boolean getPVP() {
		return false;
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
		return false;
	}

	@Override
	public boolean getAllowMonsters() {
		return false;
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
		return 0;
	}

	@Override
	public double getHumidity(int x, int z) {
		return 0;
	}

	@Override
	public int getMaxHeight() {
		return 0;
	}

	@Override
	public int getSeaLevel() {
		return 0;
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		return false;
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAutoSave() {
		return false;
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
		return false;
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		return 0;
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		throw new NotImplementedException();
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		return 0;
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		throw new NotImplementedException();
	}

	@Override
	public int getMonsterSpawnLimit() {
		return 0;
	}

	@Override
	public void setMonsterSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getAnimalSpawnLimit() {
		return 0;
	}

	@Override
	public void setAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return 0;
	}

	@Override
	public void setWaterAnimalSpawnLimit(int limit) {
		throw new NotImplementedException();
	}

	@Override
	public int getAmbientSpawnLimit() {
		return 0;
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
		return false;
	}

	@Override
	public boolean isGameRule(String rule) {
		return false;
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
		return false;
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
