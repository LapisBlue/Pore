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
package blue.lapis.pore.impl.block;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreWrapper;

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
import org.spongepowered.api.block.data.TileEntity;

import java.util.List;

public class PoreBlockState extends PoreWrapper<TileEntity> implements BlockState {

    // TODO: Actually block states exist even without tile entities
    public static PoreBlockState of(TileEntity handle) {
        return WrapperConverter.of(PoreBlockState.class, handle);
    }

    protected PoreBlockState(TileEntity handle) {
        super(handle);
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getBlock());
    }

    @Override
    public MaterialData getData() {
        throw new NotImplementedException();
    }

    @Override
    public Material getType() {
        return getBlock().getType();
    }

    @Override
    public int getTypeId() {
        return getBlock().getTypeId();
    }

    @Override
    public byte getLightLevel() {
        return getBlock().getLightLevel();
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getWorld());
    }

    @Override
    public int getX() {
        return getBlock().getX();
    }

    @Override
    public int getY() {
        return getBlock().getY();
    }

    @Override
    public int getZ() {
        return getBlock().getZ();
    }

    @Override
    public Location getLocation() {
        return getBlock().getLocation();
    }

    @Override
    public Location getLocation(Location loc) {
        return getBlock().getLocation(loc);
    }

    @Override
    public Chunk getChunk() {
        return getBlock().getChunk();
    }

    @Override
    public void setData(MaterialData data) {
        throw new NotImplementedException();
    }

    @Override
    public void setType(Material type) {
        getBlock().setType(type);
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
        return getBlock().getData();
    }

    @Override
    public void setRawData(byte data) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlaced() {
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
