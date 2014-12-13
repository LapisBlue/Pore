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
import org.spongepowered.api.entity.ExperienceOrb;

public class PoreExperienceOrb extends PoreEntity implements org.bukkit.entity.ExperienceOrb {

    private static TypeConverter<ExperienceOrb, PoreExperienceOrb> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<ExperienceOrb, PoreExperienceOrb> getExperienceOrbConverter() {
        if (converter == null) {
            converter = new TypeConverter<ExperienceOrb, PoreExperienceOrb>() {
                @Override
                protected PoreExperienceOrb convert(ExperienceOrb handle) {
                    return new PoreExperienceOrb(handle);
                }
            };
        }
        return converter;
    }

    protected PoreExperienceOrb(ExperienceOrb handle) {
        super(handle);
    }

    @Override
    public ExperienceOrb getHandle() {
        return (ExperienceOrb) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreExperienceOrb of(ExperienceOrb handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.EXPERIENCE_ORB;
    }

    @Override
    public int getExperience() {
        return getHandle().getExperience();
    }

    @Override
    public void setExperience(int value) {
        getHandle().setExperience(value);
    }
}
