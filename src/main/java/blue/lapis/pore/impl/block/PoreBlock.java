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

import blue.lapis.pore.converter.ItemStackConverter;
import blue.lapis.pore.converter.type.DirectionConverter;
import blue.lapis.pore.converter.type.MaterialConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.List;

public class PoreBlock extends PoreWrapper<Location> implements Block {

    public static PoreBlock of(Location handle) {
        return WrapperConverter.of(PoreBlock.class, handle);
    }

    private PoreBlock(Location handle) {
        super(handle);
    }

    @Override
    public byte getData() {
        return getHandle().getState().getDataValue();
    }

    @Override
    public void setData(byte data) {
        getHandle().replaceWith(getHandle().getState().getType().getStateFromDataValue(data));
    }

    @Override
    public void setData(byte data, boolean applyPhysics) {
        throw new NotImplementedException(); //TODO: probably going to need some custom data mapping for
        // BlockStates
    }

    @Override
    public Block getRelative(int modX, int modY, int modZ) {
        return getWorld().getBlockAt(getX() + modX, getY() + modY, getZ() + modZ);
    }

    @Override
    public Block getRelative(BlockFace face) {
        return getRelative(face, 1);
    }

    @Override
    public Block getRelative(BlockFace face, int distance) {
        return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
    }

    @Override
    public Material getType() {
        return MaterialConverter.of(getHandle().getType());
    }

    @Override
    public void setType(Material type) {
        getHandle().replaceWith(MaterialConverter.asBlock(type));
    }

    @Override
    public void setType(Material type, boolean applyPhysics) {
        // TODO: applyPhysics
        this.setType(type);
    }

    @Override
    public int getTypeId() {
        return getType().getId();
    }

    @Override
    public byte getLightLevel() {
        return getHandle().getLuminance();
    }

    @Override
    public byte getLightFromSky() {
        return getHandle().getLuminanceFromSky();
    }

    @Override
    public byte getLightFromBlocks() {
        return getHandle().getLuminanceFromGround();
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getExtent());
    }

    @Override
    public int getX() {
        return (int)getHandle().getX();
    }

    @Override
    public int getY() {
        return (int)getHandle().getY();
    }

    @Override
    public int getZ() {
        return (int)getHandle().getZ();
    }

    @Override
    public org.bukkit.Location getLocation() {
        return LocationConverter.of(getHandle());
    }

    @Override
    public org.bukkit.Location getLocation(org.bukkit.Location loc) {
        return LocationConverter.apply(loc, getHandle());
    }

    @Override
    public Chunk getChunk() {
        throw new NotImplementedException();
    }

    @Override
    public boolean setTypeId(int type) {
        return this.setTypeId(type, true);
    }

    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        //TODO: applyPhysics
        BlockType blockType = MaterialConverter.asBlock(Material.getMaterial(type));
        getHandle().replaceWith(blockType);
        return getHandle().getType().equals(blockType);
    }

    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        this.setData(data, applyPhysics);
        return this.setTypeId(type, applyPhysics);
    }

    @Override
    public BlockFace getFace(Block block) {
        throw new NotImplementedException();
    }

    @Override
    public BlockState getState() {
        throw new NotImplementedException();
    }

    @Override
    public Biome getBiome() {
        throw new NotImplementedException();
    }

    @Override
    public void setBiome(Biome bio) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBlockPowered() {
        return getHandle().isPowered();
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return getHandle().isIndirectlyPowered();
    }

    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        return getHandle().isFacePowered(DirectionConverter.of(face));
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        return getHandle().isFaceIndirectlyPowered(DirectionConverter.of(face));
    }

    @Override
    public int getBlockPower(BlockFace face) {
        throw new NotImplementedException();
    }

    @Override
    public int getBlockPower() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isEmpty() {
        return getHandle().getType() == BlockTypes.AIR;
    }

    @Override
    public boolean isLiquid() {
        return getHandle().getType().isLiquid();
    }

    @Override
    public double getTemperature() {
        throw new NotImplementedException();
    }

    @Override
    public double getHumidity() {
        throw new NotImplementedException();
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException();
    }

    @Override
    public boolean breakNaturally() {
        return getHandle().dig();
    }

    @Override
    public boolean breakNaturally(ItemStack tool) {
        return getHandle().digWith(ItemStackConverter.of(tool));
    }

    @Override
    public Collection<ItemStack> getDrops() {
        throw new NotImplementedException();
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack tool) {
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
