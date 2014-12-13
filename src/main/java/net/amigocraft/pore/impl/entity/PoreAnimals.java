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
package net.amigocraft.pore.impl.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Animals;
import org.spongepowered.api.entity.living.Tameable;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Cow;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Sheep;

public class PoreAnimals extends PoreAgeable implements Animals {

    private static TypeConverter<Animal, PoreAnimals> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Animal, PoreAnimals> getAnimalConverter() {
        if (converter == null) {
            converter = new TypeConverter<Animal, PoreAnimals>(
                    (ImmutableMap) ImmutableMap.builder() // generified for simplicity and readability
                            .put(Chicken.class, PoreChicken.getChickenConverter())
                            .put(Cow.class, PoreCow.getCowConverter())
                            .put(Pig.class, PorePig.getPigConverter())
                            .put(Sheep.class, PoreSheep.getSheepConverter())
                            .put(Tameable.class, PoreTameable.getTameableConverter())
                            .build()
            ) {
                @Override
                protected PoreAnimals convert(Animal handle) {
                    return new PoreAnimals(handle);
                }
            };
        }
        return converter;
    }

    protected PoreAnimals(Animal handle) {
        super(handle);
    }

    @Override
    public Animal getHandle() {
        return (Animal) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreAnimals of(Animal handle) {
        return converter.apply(handle);
    }

}
