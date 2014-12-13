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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.spongepowered.api.entity.living.monster.ZombiePigman;

public class PorePigZombie extends PoreZombie implements PigZombie {

    private static TypeConverter<ZombiePigman, PorePigZombie> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<ZombiePigman, PorePigZombie> getPigZombieConverter() {
        if (converter == null) {
            converter = new TypeConverter<ZombiePigman, PorePigZombie>() {
                @Override
                protected PorePigZombie convert(ZombiePigman handle) {
                    return new PorePigZombie(handle);
                }
            };
        }
        return converter;
    }

    protected PorePigZombie(ZombiePigman handle) {
        super(handle);
    }

    @Override
    public ZombiePigman getHandle() {
        return (ZombiePigman) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PorePigZombie of(ZombiePigman handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.PIG_ZOMBIE;
    }

    @Override
    public int getAnger() {
        return getHandle().getAngerLevel();
    }

    @Override
    public void setAnger(int level) {
        getHandle().setAngerLevel(level);
    }

    @Override
    public void setAngry(boolean angry) {
        setAnger(angry ? 400 : 0);
    }

    @Override
    public boolean isAngry() {
        return getAnger() > 0;
    }
}
