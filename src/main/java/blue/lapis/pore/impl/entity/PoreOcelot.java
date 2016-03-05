/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.SITTING_DATA;

import blue.lapis.pore.converter.type.entity.OcelotConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Ocelot;

public class PoreOcelot extends PoreTameable implements org.bukkit.entity.Ocelot {

    public static PoreOcelot of(Ocelot handle) {
        return WrapperConverter.of(PoreOcelot.class, handle);
    }

    protected PoreOcelot(Ocelot handle) {
        super(handle);
    }

    @Override
    public Ocelot getHandle() {
        return (Ocelot) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.OCELOT;
    }

    @Override
    public Type getCatType() {
        return OcelotConverter.of(getHandle().getOcelotData().type().get());
    }

    @Override
    public void setCatType(Type type) {
        getHandle().getOcelotData().type().set(OcelotConverter.of(type));
    }

    @Override
    public boolean isSitting() {
        return hasData(SITTING_DATA);
    }

    @Override
    public void setSitting(boolean sitting) {
        if (sitting != isSitting()) {
            if (sitting) {
                getHandle().offer(getHandle().getOrCreate(SITTING_DATA).get().sitting().set(true));
            } else {
                getHandle().remove(SITTING_DATA);
            }
        }
    }
}
