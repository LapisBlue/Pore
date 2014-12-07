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
import net.amigocraft.pore.util.converter.entity.OcelotConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Ocelot;

public class PoreOcelot extends PoreTameable implements org.bukkit.entity.Ocelot {

    private static TypeConverter<Ocelot, PoreOcelot> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Ocelot, PoreOcelot> getOcelotConverter() {
        if (converter == null) {
            converter = new TypeConverter<Ocelot, PoreOcelot>() {
                @Override
                protected PoreOcelot convert(Ocelot handle) {
                    return new PoreOcelot(handle);
                }
            };
        }
        return converter;
    }

    protected PoreOcelot(Ocelot handle) {
        super(handle);
    }

    @Override
    public Ocelot getHandle() {
        return (Ocelot) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreOcelot of(Ocelot handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.OCELOT;
    }

    @Override
    public Type getCatType() {
        return OcelotConverter.of(getHandle().getOcelotType());
    }

    @Override
    public void setCatType(Type type) {
        getHandle().setOcelotType(OcelotConverter.of(type));
    }

    @Override
    public boolean isSitting() {
        return getHandle().isSitting();
    }

    @Override
    public void setSitting(boolean sitting) {
        getHandle().setSitting(sitting);
    }
}