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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.block.tile.MobSpawner;

public class PoreCreatureSpawner extends PoreBlockState implements CreatureSpawner {

    public static PoreCreatureSpawner of(MobSpawner handle) {
        return WrapperConverter.of(PoreCreatureSpawner.class, handle);
    }

    protected PoreCreatureSpawner(MobSpawner handle) {
        super(handle);
    }

    @Override
    public MobSpawner getHandle() {
        return (MobSpawner) super.getHandle();
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
