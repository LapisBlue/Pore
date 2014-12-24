/*
 * Pore
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.amigocraft.pore.impl;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.amigocraft.pore.impl.block.PoreBlock;
import net.amigocraft.pore.impl.entity.PoreEntity;
import net.amigocraft.pore.impl.entity.PoreLivingEntity;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.util.PoreCollections;
import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.EffectConverter;
import net.amigocraft.pore.util.converter.EnvironmentConverter;
import net.amigocraft.pore.util.converter.SoundConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.vector.VectorConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldBorder;
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
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.weather.Weathers;

import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
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
     *
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
        for (int y = getMaxHeight(); y >= 0; y++) {
            if (getHandle().getBlock(x, y, z).getType() != BlockTypes.AIR)
                return y;
        }
        return 0;
    }

    @Override
    public int getHighestBlockYAt(Location location) {
        if (location.getWorld() == this) {
            return getHighestBlockYAt(location.getBlockX(), location.getBlockY());
        }
        throw new IllegalArgumentException(); //TODO: should an exception be thrown?
    }

    @Override
    public Block getHighestBlockAt(int x, int z) {
        return getBlockAt(x, getHighestBlockYAt(x, z), z);
    }

    @Override
    public Block getHighestBlockAt(Location location) {
        return getBlockAt(location.getBlockX(), getHighestBlockYAt(location), location.getBlockZ());
    }

    @Override
    public Chunk getChunkAt(int x, int z) {
        Optional<org.spongepowered.api.world.Chunk> chunk = getHandle().getChunk(new Vector3i(x, 0, z));
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
        return chunk.isLoaded();
    }

    @Override
    public Chunk[] getLoadedChunks() {
        List<Chunk> chunks = new ArrayList<Chunk>();
        for (org.spongepowered.api.world.Chunk chunk : getHandle().getLoadedChunks()) {
            chunks.add(PoreChunk.of(chunk));
        }

        return chunks.toArray(new Chunk[chunks.size()]);
    }

    @Override
    public void loadChunk(Chunk chunk) {
        loadChunk(chunk.getX(), chunk.getZ());
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return getHandle().getChunk(new Vector3i(x, 0, z)).isPresent();
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
        return getHandle().loadChunk(new Vector3i(x, 0, z), generate).isPresent();
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
        // This is basically copying every time, unfortunately there is no real better way because we can't
        // filter
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
        //TODO: possibly optimize this (there is no real way other than Sponge implementing something to help
        // with that)
        // see getLivingEntities() for explanation
        List<Player> players = Lists.newArrayList();
        for (org.spongepowered.api.entity.Entity e : getHandle().getEntities()) {
            if (e instanceof org.spongepowered.api.entity.player.Player) {
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
        return getHandle().getWeather().equals(Weathers.RAIN);
    }

    @Override
    public void setStorm(boolean hasStorm) {
        getHandle().forecast(hasStorm ? Weathers.RAIN : Weathers.CLEAR);
    }

    @Override
    public int getWeatherDuration() {
        return (int) getHandle().getRemainingDuration();
    }

    @Override
    public void setWeatherDuration(int duration) {
        getHandle().forecast(getHandle().getWeather(), duration);
    }

    @Override
    public boolean isThundering() {
        return getHandle().getWeather().equals(Weathers.THUNDER_STORM);
    }

    @Override
    public void setThundering(boolean thundering) {
        getHandle().forecast(Weathers.THUNDER_STORM);
    }

    // TODO: Verify behaviour of this

    @Override
    public int getThunderDuration() {
        return isThundering() ? (int) getHandle().getRemainingDuration() : 0;
    }

    @Override
    public void setThunderDuration(int duration) {
        getHandle().forecast(Weathers.THUNDER_STORM, duration);
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
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire,
                                   boolean breakBlocks) {
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
        return EnvironmentConverter.of(getHandle().getEnvironment());
    }

    @Override
    public long getSeed() {
        return getHandle().getWorldSeed();
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
    public FallingBlock spawnFallingBlock(Location location, Material material, byte data)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void playEffect(Location location, Effect effect, int data) {
        this.playEffect(location, effect, data, 64);
    }

    @Override
    public void playEffect(Location location, Effect effect, int data, int radius) {
        if (effect.getType() == Effect.Type.SOUND) {
            getHandle().playSound(EffectConverter.toSound(effect, data), VectorConverter.create3d(location), radius);
        } else {
            getHandle().spawnParticles(
                    EffectConverter.toParticle(effect),
                    16, //TODO: determine default count
                    VectorConverter.create3d(location),
                    new Vector3d(0, 0, 0), //TODO: determine default offset
                    1, //TODO: determine default speed
                    radius
            );
        }
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data) {
        this.playEffect(location, effect, data, 64);
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data, int radius) {
        if ((data != null && data.getClass().equals(effect.getData())) ||
                (data == null && effect.getData() == null)) {
            this.playEffect(location, effect, data == null ? 0 : EffectConverter.getDataValue(effect, data), radius);
        } else
            throw new IllegalArgumentException("Invalid data type for effect!");
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome,
                                               boolean includeBiomeTempRain) {
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
        return new File(Bukkit.getWorldContainer(),
                getHandle().getName()); //TODO: not sure this will always work
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
        getHandle().playSound(SoundConverter.of(sound), VectorConverter.create3d(location), (double) volume,
                (double) pitch);
    }

    @Override
    public String[] getGameRules() {
        Set<String> rules = getHandle().getGameRules().keySet();
        return rules.toArray(new String[rules.size()]);
    }

    @Override
    public String getGameRuleValue(String rule) {
        return getHandle().getGameRule(rule).orNull();
    }

    @Override
    public boolean setGameRuleValue(String rule, String value) {
        if (rule == null) return false;
        getHandle().setGameRule(rule, value);
        return true;
    }

    @Override
    public boolean isGameRule(String rule) {
        return getHandle().getGameRule(rule).isPresent();
    }

    @Override
    public WorldBorder getWorldBorder() {
        return PoreWorldBorder.of(getHandle().getWorldBorder());
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
