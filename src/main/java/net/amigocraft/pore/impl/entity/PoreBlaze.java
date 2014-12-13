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

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

public class PoreBlaze extends PoreMonster implements Blaze {

    private static TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze> getBlazeConverter() {
        if (converter == null) {
            converter = new TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze>() {
                @Override
                protected PoreBlaze convert(org.spongepowered.api.entity.living.monster.Blaze handle) {
                    return new PoreBlaze(handle);
                }
            };
        }
        return converter;
    }

    protected PoreBlaze(org.spongepowered.api.entity.living.monster.Blaze handle) {
        super(handle);
    }

    @Override
    public org.spongepowered.api.entity.living.monster.Blaze getHandle() {
        return (org.spongepowered.api.entity.living.monster.Blaze) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreBlaze of(org.spongepowered.api.entity.living.monster.Blaze handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.BLAZE;
    }

}
