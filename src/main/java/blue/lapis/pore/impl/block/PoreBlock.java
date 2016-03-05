/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

import static org.spongepowered.api.data.property.block.MatterProperty.Matter.LIQUID;

import blue.lapis.pore.converter.data.block.BlockDataConverter;
import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.type.world.BiomeConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.NotImplementedException;
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
import org.spongepowered.api.data.property.block.GroundLuminanceProperty;
import org.spongepowered.api.data.property.block.IndirectlyPoweredProperty;
import org.spongepowered.api.data.property.block.LightEmissionProperty;
import org.spongepowered.api.data.property.block.MatterProperty;
import org.spongepowered.api.data.property.block.PoweredProperty;
import org.spongepowered.api.data.property.block.SkyLuminanceProperty;
import org.spongepowered.api.data.property.block.TemperatureProperty;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PoreBlock extends PoreWrapper<Location<org.spongepowered.api.world.World>> implements Block {

    public static PoreBlock of(Location<org.spongepowered.api.world.World> handle) {
        return WrapperConverter.of(PoreBlock.class, handle);
    }

    protected PoreBlock(Location<org.spongepowered.api.world.World> handle) {
        super(handle);
    }

    @SuppressWarnings("deprecation")
    @Override
    public byte getData() {
        // TODO: This is broken
        // return BlockDataConverter.INSTANCE.getDataValue(getHandle());
        return 0;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setData(byte data) {
        setData(data, true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setData(byte data, boolean applyPhysics) {
        BlockDataConverter.INSTANCE.setDataValue(getHandle(), data);
        //TODO: applyPhysics
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
        return MaterialConverter.of(getHandle().getBlockType());
    }

    @Override
    public void setType(Material type) {
        getHandle().setBlockType(MaterialConverter.asBlock(type));
    }

    @Override
    public void setType(Material type, boolean applyPhysics) {
        // TODO: applyPhysics
        this.setType(type);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getTypeId() {
        return getType().getId();
    }

    @Override
    public byte getLightLevel() {
        Optional<LightEmissionProperty> prop = getHandle().getProperty(LightEmissionProperty.class);
        if (prop.isPresent()) {
            //noinspection ConstantConditions
            return prop.get().getValue().byteValue();
        }
        return 0;
    }

    @Override
    public byte getLightFromSky() {
        Optional<SkyLuminanceProperty> prop = getHandle().getProperty(SkyLuminanceProperty.class);
        if (prop.isPresent()) {
            //noinspection ConstantConditions
            return prop.get().getValue().byteValue();
        }
        return 0;
    }

    @Override
    public byte getLightFromBlocks() {
        Optional<GroundLuminanceProperty> prop = getHandle().getProperty(GroundLuminanceProperty.class);
        if (prop.isPresent()) {
            //noinspection ConstantConditions
            return prop.get().getValue().byteValue();
        }
        return 0;
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getExtent());
    }

    @Override
    public int getX() {
        return (int) getHandle().getX();
    }

    @Override
    public int getY() {
        return (int) getHandle().getY();
    }

    @Override
    public int getZ() {
        return (int) getHandle().getZ();
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
        throw new NotImplementedException("TODO");
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean setTypeId(int type) {
        return this.setTypeId(type, true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean setTypeId(int type, boolean applyPhysics) {
        //TODO: applyPhysics
        BlockType blockType = MaterialConverter.asBlock(Material.getMaterial(type));
        getHandle().setBlockType(blockType);
        return getHandle().getBlockType().equals(blockType);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
        this.setData(data, applyPhysics);
        return this.setTypeId(type, applyPhysics);
    }

    @Override
    public BlockFace getFace(Block block) {
        int displacement = Math.abs(block.getX() - getX()) + Math.abs(block.getY() - getY())
                + Math.abs(block.getZ() - getZ());
        if (displacement > 1) {
            return null;
        } else if (displacement == 0) {
            return BlockFace.SELF;
        } else if (block.getX() > getX()) {
            return BlockFace.EAST;
        } else if (block.getX() < getX()) {
            return BlockFace.WEST;
        } else if (block.getY() > getY()) {
            return BlockFace.UP;
        } else if (block.getY() < getY()) {
            return BlockFace.DOWN;
        } else if (block.getZ() > getZ()) {
            return BlockFace.NORTH;
        } else if (block.getZ() < getZ()) {
            return BlockFace.SOUTH;
        } else {
            return null; // I don't think this is logically possible
        }
    }

    @Override
    public BlockState getState() {
        return PoreBlockState.of(getHandle().createSnapshot());
    }

    @Override
    public Biome getBiome() {
        return BiomeConverter.of(getHandle().getBiome());
    }

    @Override
    public void setBiome(Biome bio) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isBlockPowered() {
        Optional<PoweredProperty> prop = getHandle().getProperty(PoweredProperty.class);
        //noinspection ConstantConditions
        return prop.isPresent() && prop.get().getValue();
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        Optional<IndirectlyPoweredProperty> prop = getHandle().getProperty(IndirectlyPoweredProperty.class);
        //noinspection ConstantConditions
        return prop.isPresent() && prop.get().getValue();
    }

    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        throw new NotImplementedException("TODO");
        //return getHandle().isBlockFacePowered(DirectionConverter.of(face));
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        throw new NotImplementedException("TODO");
        //return getHandle().isBlockFaceIndirectlyPowered(DirectionConverter.of(face));
    }

    @Override
    public int getBlockPower(BlockFace face) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getBlockPower() {
        return getBlockPower(BlockFace.SELF);
    }

    @Override
    public boolean isEmpty() {
        return getHandle().getBlockType() == BlockTypes.AIR;
    }

    @Override
    public boolean isLiquid() {
        return getHandle().getBlockType().getProperty(MatterProperty.class).get().getValue() == LIQUID;
    }

    @Override
    public double getTemperature() {
        Optional<TemperatureProperty> prop = getHandle().getProperty(TemperatureProperty.class);
        //noinspection ConstantConditions
        return prop.isPresent() ? prop.get().getValue() : 0;
    }

    @Override
    public double getHumidity() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean breakNaturally() {
        throw new NotImplementedException("TODO");
        //return getHandle().digBlock();
    }

    @Override
    public boolean breakNaturally(ItemStack tool) {
        throw new NotImplementedException("TODO");
        //return getHandle().digBlockWith(ItemStackConverter.of(tool));
    }

    @Override
    public Collection<ItemStack> getDrops() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack tool) {
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
