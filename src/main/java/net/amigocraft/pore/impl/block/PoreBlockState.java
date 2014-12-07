/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
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
package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PoreBlockState extends PoreWrapper<org.spongepowered.api.block.BlockState> implements BlockState {

    //TODO: possibly store the parent BlockLoc in the wrapper object

    private static TypeConverter<org.spongepowered.api.block.BlockState, PoreBlockState> converter;

    static TypeConverter<org.spongepowered.api.block.BlockState, PoreBlockState> getBlockStateConverter() {
        if (converter == null) {
            converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreBlockState>() {
                @Override
                protected PoreBlockState convert(org.spongepowered.api.block.BlockState handle) {
                    return new PoreBlockState(handle);
                }
            };
        }

        return converter;
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreBlockState of(org.spongepowered.api.block.BlockState handle) {
        return converter.apply(handle);
    }

    protected PoreBlockState(org.spongepowered.api.block.BlockState handle) {
        super(handle);
    }

    @Override
    public Block getBlock() {
        throw new NotImplementedException();
    }

    @Override
    public MaterialData getData() {
        throw new NotImplementedException();
    }

    @Override
    public Material getType() {
        return MaterialConverter.toBukkitMaterial(getHandle().getType());
    }

    @Override
    public int getTypeId() {
        return MaterialConverter.toBukkitMaterial(getHandle().getType()).getId();
    }

    @Override
    public byte getLightLevel() {
        throw new NotImplementedException();
    }

    @Override
    public World getWorld() {
        throw new NotImplementedException();
    }

    @Override
    public int getX() {
        throw new NotImplementedException();
    }

    @Override
    public int getY() {
        throw new NotImplementedException();
    }

    @Override
    public int getZ() {
        throw new NotImplementedException();
    }

    @Override
    public Location getLocation() {
        throw new NotImplementedException();
    }

    @Override
    public Location getLocation(Location loc) {
        throw new NotImplementedException();
    }

    @Override
    public Chunk getChunk() {
        throw new NotImplementedException();
    }

    @Override
    public void setData(MaterialData data) {
        throw new NotImplementedException();
    }

    @Override
    public void setType(Material type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean setTypeId(int type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update() {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        throw new NotImplementedException();
    }

    @Override
    public byte getRawData() {
        return getHandle().getDataValue();
    }

    @Override
    public void setRawData(byte data) {
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
}
