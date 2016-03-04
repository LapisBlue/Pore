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

package blue.lapis.pore.impl.entity;

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.DYEABLE_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.SITTING_DATA;

import blue.lapis.pore.converter.type.material.DyeColorConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Wolf;

public class PoreWolf extends PoreTameable implements org.bukkit.entity.Wolf {

    public static PoreWolf of(Wolf handle) {
        return WrapperConverter.of(PoreWolf.class, handle);
    }

    protected PoreWolf(Wolf handle) {
        super(handle);
    }

    @Override
    public Wolf getHandle() {
        return (Wolf) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.WOLF;
    }

    @Override
    public boolean isAngry() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setAngry(boolean angry) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isSitting() {
        return hasData(SITTING_DATA) && getHandle().get(SITTING_DATA).get().sitting().get();
    }

    @Override
    public void setSitting(boolean sitting) {
        if (sitting != isSitting()) {
            if (sitting) {
                getHandle().get(SITTING_DATA).get().sitting().set(true);
            } else {
                getHandle().remove(SITTING_DATA);
            }
        }
    }

    @Override
    public DyeColor getCollarColor() {
        return DyeColorConverter.of(getHandle().get(DYEABLE_DATA).get().type().get());
    }

    @Override
    public void setCollarColor(DyeColor color) {
        getHandle().getOrCreate(DYEABLE_DATA).get().type().set(DyeColorConverter.of(color));
    }
}
