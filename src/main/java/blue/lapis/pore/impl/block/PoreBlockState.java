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

import blue.lapis.pore.converter.data.block.BlockDataConverter;
import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.tileentity.TileEntity;

import java.util.Collection;
import java.util.List;

public class PoreBlockState extends PoreWrapper<BlockSnapshot> implements org.bukkit.block.BlockState {

    private final TileEntity tileEntity;

    public static PoreBlockState of(BlockSnapshot handle) {
        return WrapperConverter.of(PoreBlockState.class, handle);
    }

    protected PoreBlockState(BlockSnapshot handle) {
        super(handle);
        this.tileEntity = null;
    }

    protected PoreBlockState(TileEntity handle) {
        super(handle.getLocation().createSnapshot());
        this.tileEntity = handle;
    }

    TileEntity getTileEntity() {
        return tileEntity;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getLocation().get());
    }

    @Override
    public MaterialData getData() {
        return new MaterialData(getBlock().getData());
    }

    @Override
    public Material getType() {
        return MaterialConverter.of(getHandle().getExtendedState().getType());
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getTypeId() {
        return getType().getId();
    }

    @Override
    public byte getLightLevel() {
        //noinspection ConstantConditions
        return isPlaced() ? getBlock().getLightLevel() : null;
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getLocation().get().getExtent());
    }

    @Override
    public int getX() {
        //noinspection ConstantConditions
        return isPlaced() ? getBlock().getX() : null;
    }

    @Override
    public int getY() {
        //noinspection ConstantConditions
        return isPlaced() ? getBlock().getY() : null;
    }

    @Override
    public int getZ() {
        //noinspection ConstantConditions
        return isPlaced() ? getBlock().getZ() : null;
    }

    @Override
    public Location getLocation() {
        return LocationConverter.of(getHandle().getLocation().get());
    }

    @Override
    public Location getLocation(Location loc) {
        return LocationConverter.apply(loc, getHandle().getLocation().get());
    }

    @Override
    public Chunk getChunk() {
        return isPlaced() ? getBlock().getChunk() : null;
    }

    @Override
    public void setData(MaterialData data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setType(Material type) {
        //TODO: this isn't right
        if (isPlaced()) {
            getBlock().setType(type);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean setTypeId(int type) {
        Material mat = Material.getMaterial(type);
        setType(mat);
        return getType() == mat;
    }

    @Override
    public boolean update() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean update(boolean force) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        throw new NotImplementedException("TODO");
    }

    @Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public byte getRawData() {
        return BlockDataConverter.INSTANCE.getDataValue((Collection) getHandle().getManipulators(),
                getHandle().getExtendedState().getType());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setRawData(byte data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPlaced() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException("TODO");
    }
}
