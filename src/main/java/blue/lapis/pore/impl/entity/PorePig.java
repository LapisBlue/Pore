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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.SADDLE_DATA;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.living.animal.Pig;

public class PorePig extends PoreAnimals implements org.bukkit.entity.Pig {

    public static PorePig of(Pig handle) {
        return WrapperConverter.of(PorePig.class, handle);
    }

    protected PorePig(Pig handle) {
        super(handle);
    }

    @Override
    public Pig getHandle() {
        return (Pig) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.PIG;
    }

    @Override
    public boolean hasSaddle() {
        return hasData(SADDLE_DATA);
    }

    @Override
    public void setSaddle(boolean saddled) {
        if (saddled != hasSaddle()) {
            if (saddled) {
                getHandle().offer(getHandle().getOrCreate(SADDLE_DATA).get().saddle()
                        .set(ItemStackConverter.of(new ItemStack(Material.SADDLE, 1)))); // you'd think this was Lisp
            } else {
                getHandle().remove(SADDLE_DATA);
            }
        }
    }
}
