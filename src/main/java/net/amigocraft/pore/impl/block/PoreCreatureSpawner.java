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
package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.block.BlockState;

public class PoreCreatureSpawner extends PoreBlockState implements CreatureSpawner {

    private static TypeConverter<BlockState, PoreCreatureSpawner> converter;

    static TypeConverter<org.spongepowered.api.block.BlockState, PoreCreatureSpawner>
    getCreatureSpawnerConverter() {
        if (converter == null) {
            converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreCreatureSpawner>() {
                @Override
                protected PoreCreatureSpawner convert(org.spongepowered.api.block.BlockState handle) {
                    return new PoreCreatureSpawner(handle);
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
    public static PoreCreatureSpawner of(org.spongepowered.api.block.BlockState handle) {
        return converter.apply(handle);
    }

    protected PoreCreatureSpawner(org.spongepowered.api.block.BlockState handle) {
        super(handle);
    }

    @Override
    public CreatureType getCreatureType() {
        throw new NotImplementedException();
    }

    @Override
    public EntityType getSpawnedType() {
        throw new NotImplementedException();
    }

    @Override
    public void setSpawnedType(EntityType creatureType) {
        throw new NotImplementedException();
    }

    @Override
    public void setCreatureType(CreatureType creatureType) {
        throw new NotImplementedException();
    }

    @Override
    public String getCreatureTypeId() {
        throw new NotImplementedException();
    }

    @Override
    public void setCreatureTypeByName(String creatureType) {
        throw new NotImplementedException();
    }

    @Override
    public String getCreatureTypeName() {
        throw new NotImplementedException();
    }

    @Override
    public void setCreatureTypeId(String creatureType) {
        throw new NotImplementedException();
    }

    @Override
    public int getDelay() {
        throw new NotImplementedException();
    }

    @Override
    public void setDelay(int delay) {
        throw new NotImplementedException();
    }
}
