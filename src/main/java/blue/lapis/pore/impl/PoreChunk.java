/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
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
package blue.lapis.pore.impl;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PoreEntity;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.spongepowered.api.world.Chunk;

import java.util.Collection;

public class PoreChunk extends PoreWrapper<Chunk> implements org.bukkit.Chunk {

    public static PoreChunk of(Chunk handle) {
        return WrapperConverter.of(PoreChunk.class, handle);
    }

    protected PoreChunk(Chunk handle) {
        super(handle);
    }

    @Override
    public int getX() {
        return getHandle().getPosition().getX();
    }

    @Override
    public int getZ() {
        return getHandle().getPosition().getZ();
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getWorld());
    }

    @Override
    public Block getBlock(int x, int y, int z) {
        return PoreBlock.of(getHandle().getBlock(x, y, z));
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        throw new NotImplementedException();
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome,
                                          boolean includeBiomeTempRain) {
        throw new NotImplementedException();
    }

    @Override
    public Entity[] getEntities() {
        Collection<org.spongepowered.api.entity.Entity> entities = getHandle().getEntities();

        Entity[] result = new Entity[entities.size()];
        int i = 0;
        for (org.spongepowered.api.entity.Entity entity : entities) {
            result[i++] = PoreEntity.of(entity);
        }

        return result;
    }

    @Override
    public BlockState[] getTileEntities() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLoaded() {
        return getHandle().isLoaded();
    }

    @Override
    public boolean load(boolean generate) {
        return getHandle().loadChunk(generate);
    }

    @Override
    public boolean load() {
        return load(true);
    }

    @Override
    public boolean unload(boolean save, boolean safe) {
        return getHandle().unloadChunk(); //TODO: parameters
    }

    @Override
    public boolean unload(boolean save) {
        return unload(save, true);
    }

    @Override
    public boolean unload() {
        return unload(true);
    }
}
