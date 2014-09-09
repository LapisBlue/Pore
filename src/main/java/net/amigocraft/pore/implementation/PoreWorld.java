package net.amigocraft.pore.implementation;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import net.amigocraft.pore.implementation.block.PoreBlock;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class PoreWorld implements World {
	private org.spongepowered.api.world.World handle;
    
	public PoreWorld(org.spongepowered.api.world.World spongeWorld) {
		this.handle = spongeWorld;
	}

	@Override
	public Block getBlockAt(int x, int y, int z){
		return new PoreBlock(handle.getBlock(x, y, z));
	}

	@Override
	public Block getBlockAt(Location location){
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z){
		return 0; //TODO: bridge
	}

	@Override
	public int getBlockTypeIdAt(Location location){
		return 0; //TODO: bridge
	}

	@Override
	public int getHighestBlockYAt(int x, int z){
		return 0; //TODO: bridge
	}

	@Override
	public int getHighestBlockYAt(Location location){
		return 0; //TODO: bridge
	}

	@Override
	public Block getHighestBlockAt(int x, int z){
		return null; //TODO: bridge
	}

	@Override
	public Block getHighestBlockAt(Location location){
		return null; //TODO: bridge
	}

	@Override
	public Chunk getChunkAt(int x, int z){
		return new PoreChunk(handle.getChunk(x, z));
	}

	@Override
	public Chunk getChunkAt(Location location){
		return getChunkAt(location.getBlockX(), location.getBlockZ());
	}

	@Override
	public Chunk getChunkAt(Block block){
		return getChunkAt(block.getLocation().getBlockX(), block.getLocation().getBlockZ());
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk){
		return false; //TODO: bridge
	}

	@Override
	public Chunk[] getLoadedChunks(){
		return new Chunk[0]; //TODO: bridge
	}

	@Override
	public void loadChunk(Chunk chunk){
		//TODO: bridge
	}

	@Override
	public boolean isChunkLoaded(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public boolean isChunkInUse(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public void loadChunk(int x, int z){
		//TODO: bridge
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunk(Chunk chunk){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunk(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunkRequest(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe){
		return false; //TODO: bridge
	}

	@Override
	public boolean regenerateChunk(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public boolean refreshChunk(int x, int z){
		return false; //TODO: bridge
	}

	@Override
	public Item dropItem(Location location, ItemStack item){
		return null; //TODO: bridge
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item){
		return null; //TODO: bridge
	}

	@Override
	public Arrow spawnArrow(Location location, Vector direction, float speed, float spread){
		return null; //TODO: bridge
	}

	@Override
	public boolean generateTree(Location location, TreeType type){
		return false; //TODO: bridge
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate){
		return false; //TODO: bridge
	}

	@Override
	public Entity spawnEntity(Location loc, EntityType type){
		return null; //TODO: bridge
	}

	@Override
	public LivingEntity spawnCreature(Location loc, EntityType type){
		return null; //TODO: bridge
	}

	@Override
	public LivingEntity spawnCreature(Location loc, CreatureType type){
		return null; //TODO: bridge
	}

	@Override
	public LightningStrike strikeLightning(Location loc){
		return null; //TODO: bridge
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc){
		return null; //TODO: bridge
	}

	@Override
	public List<Entity> getEntities(){
		return null; //TODO: bridge
	}

	@Override
	public List<LivingEntity> getLivingEntities(){
		return null; //TODO: bridge
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes){
		return null; //TODO: bridge
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls){
		return null; //TODO: bridge
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes){
		return null; //TODO: bridge
	}

	@Override
	public List<Player> getPlayers(){
		return null; //TODO: bridge
	}

	@Override
	public String getName(){
		return handle.getName();
	}

	@Override
	public UUID getUID(){
		return handle.getUniqueID();
	}

	@Override
	public Location getSpawnLocation(){
		return null; //TODO: bridge
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z){
		return false; //TODO: bridge
	}

	@Override
	public long getTime(){
		return 0; //TODO: bridge
	}

	@Override
	public void setTime(long time){
		//TODO: bridge
	}

	@Override
	public long getFullTime(){
		return 0; //TODO: bridge
	}

	@Override
	public void setFullTime(long time){
		//TODO: bridge
	}

	@Override
	public boolean hasStorm(){
		return false; //TODO: bridge
	}

	@Override
	public void setStorm(boolean hasStorm){
		//TODO: bridge
	}

	@Override
	public int getWeatherDuration(){
		return 0; //TODO: bridge
	}

	@Override
	public void setWeatherDuration(int duration){
		//TODO: bridge
	}

	@Override
	public boolean isThundering(){
		return false; //TODO: bridge
	}

	@Override
	public void setThundering(boolean thundering){
		//TODO: bridge
	}

	@Override
	public int getThunderDuration(){
		return 0; //TODO: bridge
	}

	@Override
	public void setThunderDuration(int duration){
		//TODO: bridge
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power){
		return false; //TODO: bridge
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire){
		return false; //TODO: bridge
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks){
		return false; //TODO: bridge
	}

	@Override
	public boolean createExplosion(Location loc, float power){
		return false; //TODO: bridge
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire){
		return false; //TODO: bridge
	}

	@Override
	public Environment getEnvironment(){
		return null; //TODO: bridge
	}

	@Override
	public long getSeed(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean getPVP(){
		return false; //TODO: bridge
	}

	@Override
	public void setPVP(boolean pvp){
		//TODO: bridge
	}

	@Override
	public ChunkGenerator getGenerator(){
		return null; //TODO: bridge
	}

	@Override
	public void save(){
		//TODO: bridge
	}

	@Override
	public List<BlockPopulator> getPopulators(){
		return null; //TODO: bridge
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException{
		return null; //TODO: bridge
	}

	@Override
	public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException{
		return null; //TODO: bridge
	}

	@Override
	public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException{
		return null; //TODO: bridge
	}

	@Override
	public void playEffect(Location location, Effect effect, int data){
		//TODO: bridge
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius){
		//TODO: bridge
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data){
		//TODO: bridge
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius){
		//TODO: bridge
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain){
		return null; //TODO: bridge
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals){
		//TODO: bridge
	}

	@Override
	public boolean getAllowAnimals(){
		return false; //TODO: bridge
	}

	@Override
	public boolean getAllowMonsters(){
		return false; //TODO: bridge
	}

	@Override
	public Biome getBiome(int x, int z){
		return null; //TODO: bridge
	}

	@Override
	public void setBiome(int x, int z, Biome bio){
		//TODO: bridge
	}

	@Override
	public double getTemperature(int x, int z){
		return 0; //TODO: bridge
	}

	@Override
	public double getHumidity(int x, int z){
		return 0; //TODO: bridge
	}

	@Override
	public int getMaxHeight(){
		return 0; //TODO: bridge
	}

	@Override
	public int getSeaLevel(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean getKeepSpawnInMemory(){
		return false; //TODO: bridge
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded){
		//TODO: bridge
	}

	@Override
	public boolean isAutoSave(){
		return false; //TODO: bridge
	}

	@Override
	public void setAutoSave(boolean value){
		//TODO: bridge
	}

	@Override
	public void setDifficulty(Difficulty difficulty){
		//TODO: bridge
	}

	@Override
	public Difficulty getDifficulty(){
		return null; //TODO: bridge
	}

	@Override
	public File getWorldFolder(){
		return null; //TODO: bridge
	}

	@Override
	public WorldType getWorldType(){
		return null; //TODO: bridge
	}

	@Override
	public boolean canGenerateStructures(){
		return false; //TODO: bridge
	}

	@Override
	public long getTicksPerAnimalSpawns(){
		return 0; //TODO: bridge
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns){
		//TODO: bridge
	}

	@Override
	public long getTicksPerMonsterSpawns(){
		return 0; //TODO: bridge
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns){
		//TODO: bridge
	}

	@Override
	public int getMonsterSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public void setMonsterSpawnLimit(int limit){
		//TODO: bridge
	}

	@Override
	public int getAnimalSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public void setAnimalSpawnLimit(int limit){
		//TODO: bridge
	}

	@Override
	public int getWaterAnimalSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public void setWaterAnimalSpawnLimit(int limit){
		//TODO: bridge
	}

	@Override
	public int getAmbientSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public void setAmbientSpawnLimit(int limit){
		//TODO: bridge
	}

	@Override
	public void playSound(Location location, Sound sound, float volume, float pitch){
		//TODO: bridge
	}

	@Override
	public String[] getGameRules(){
		return new String[0]; //TODO: bridge
	}

	@Override
	public String getGameRuleValue(String rule){
		return null; //TODO: bridge
	}

	@Override
	public boolean setGameRuleValue(String rule, String value){
		return false; //TODO: bridge
	}

	@Override
	public boolean isGameRule(String rule){
		return false; //TODO: bridge
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue){
		//TODO: bridge
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey){
		return null; //TODO: bridge
	}

	@Override
	public boolean hasMetadata(String metadataKey){
		return false; //TODO: bridge
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin){
		//TODO: bridge
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message){
		//TODO: bridge
	}

	@Override
	public Set<String> getListeningPluginChannels(){
		return null; //TODO: bridge
	}
}
