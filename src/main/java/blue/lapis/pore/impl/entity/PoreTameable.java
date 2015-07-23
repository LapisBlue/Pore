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

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.spongepowered.api.data.manipulator.entity.TameableData;
import org.spongepowered.api.entity.living.animal.Animal;

public class PoreTameable extends PoreAnimals implements org.bukkit.entity.Tameable, Creature {

    public static PoreTameable of(Animal handle) {
        return WrapperConverter.of(PoreTameable.class, handle);
    }

    protected PoreTameable(Animal handle) {
        super(handle);
    }

    @Override
    public boolean isTamed() {
        return has(TameableData.class);
    }

    @Override
    public void setTamed(boolean tame) {
        if (tame != isTamed()) {
            if (tame) {
                set(getOrCreate(TameableData.class));
            } else {
                remove(TameableData.class);
            }
        }
    }

    @Override
    public AnimalTamer getOwner() {
        return getOptional(TameableData.class).isPresent()
                ? PoreAnimalTamer.of(get(TameableData.class).getOwner())
                : null;
    }

    @Override
    public void setOwner(AnimalTamer tamer) {
        get(TameableData.class).setOwner(((PoreAnimalTamer) tamer).getHandle());
    }
}
