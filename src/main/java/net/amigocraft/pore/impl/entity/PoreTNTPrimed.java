/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
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
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.spongepowered.api.entity.explosive.PrimedTNT;

public class PoreTNTPrimed extends PoreEntity implements TNTPrimed {

    private static TypeConverter<PrimedTNT, PoreTNTPrimed> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<PrimedTNT, PoreTNTPrimed> getTNTPrimedConverter() {
        if (converter == null) {
            converter = new TypeConverter<PrimedTNT, PoreTNTPrimed>() {
                @Override
                protected PoreTNTPrimed convert(PrimedTNT handle) {
                    return new PoreTNTPrimed(handle);
                }
            };
        }
        return converter;
    }

    protected PoreTNTPrimed(PrimedTNT handle) {
        super(handle);
    }

    @Override
    public PrimedTNT getHandle() {
        return (PrimedTNT) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreTNTPrimed of(PrimedTNT handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.PRIMED_TNT;
    }

    @Override
    public void setFuseTicks(int fuseTicks) {
        getHandle().setFuseDuration(fuseTicks);
    }

    @Override
    public int getFuseTicks() {
        return getHandle().getFuseDuration();
    }

    @Override
    public Entity getSource() {
        return getHandle().getDetonator().isPresent() ? PoreEntity.of(getHandle().getDetonator().get()) : null;
    }

    @Override
    public void setYield(float yield) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public float getYield() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isIncendiary() {
        throw new NotImplementedException(); //TODO
    }
}
