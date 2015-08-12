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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.EXPERIENCE_HOLDER_DATA;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.ExperienceOrb;

public class PoreExperienceOrb extends PoreEntity implements org.bukkit.entity.ExperienceOrb {

    public static PoreExperienceOrb of(ExperienceOrb handle) {
        return WrapperConverter.of(PoreExperienceOrb.class, handle);
    }

    protected PoreExperienceOrb(ExperienceOrb handle) {
        super(handle);
    }

    @Override
    public ExperienceOrb getHandle() {
        return (ExperienceOrb) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.EXPERIENCE_ORB;
    }

    @Override
    public int getExperience() {
        return hasData(EXPERIENCE_HOLDER_DATA)
                ? getHandle().get(EXPERIENCE_HOLDER_DATA).get().totalExperience().get()
                : 0;
    }

    @Override
    public void setExperience(int value) {
        throw new NotImplementedException("TODO");
    }
}
