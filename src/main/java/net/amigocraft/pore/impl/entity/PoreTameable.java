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
package net.amigocraft.pore.impl.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.spongepowered.api.entity.living.Tameable;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Wolf;

public class PoreTameable extends PoreAnimals implements org.bukkit.entity.Tameable, Creature {

    //TODO: hierarchy does not match Sponge's
    // Bukkit: Tameable -> Animals -> Ageable -> Creature -> LivingEntity -> Entity
    // Sponge: Tameable -> Agent -> Living -> Entity

    private static TypeConverter<Tameable, PoreTameable> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Tameable, PoreTameable> getTameableConverter() {
        if (converter == null) {
            converter = new TypeConverter<Tameable, PoreTameable>(
                    (ImmutableMap) ImmutableMap.builder()
                            .put(Ocelot.class, PoreOcelot.getOcelotConverter())
                            .put(Wolf.class, PoreWolf.getWolfConverter())
                            .put(Horse.class, PoreHorse.getHorseConverter())
                            .build()
            ) {
                @Override
                protected PoreTameable convert(Tameable handle) {
                    return new PoreTameable(handle);
                }
            };
        }
        return converter;
    }

    protected PoreTameable(Tameable handle) {
        super((Animal) handle);
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreTameable of(Tameable handle) {
        if (handle instanceof Animal) {
            return converter.apply(handle);
        }
        throw new UnsupportedOperationException();
    }

    private Tameable getTameable() {
        return (Tameable) getHandle();
    }

    @Override
    public boolean isTamed() {
        return getTameable().isTamed();
    }

    @Override
    public void setTamed(boolean tame) {
        getTameable().setTamed(tame);
    }

    @Override
    public AnimalTamer getOwner() {
        return getTameable().getOwner().isPresent() ? PoreAnimalTamer.of(getTameable().getOwner().get()) : null;
    }

    @Override
    public void setOwner(AnimalTamer tamer) {
        getTameable().setOwner(((PoreAnimalTamer) tamer).getHandle());
    }
}
