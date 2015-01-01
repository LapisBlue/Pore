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
package net.amigocraft.pore.impl.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.RideableMinecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;

public class PoreRideableMinecart extends PoreMinecart implements RideableMinecart {

    private static TypeConverter<MinecartRideable, PoreRideableMinecart> converter;

    @SuppressWarnings("unchecked")
    public static TypeConverter<MinecartRideable, PoreRideableMinecart> getRideableMinecartConverter() {
        if (converter == null) {
            converter = new TypeConverter<MinecartRideable, PoreRideableMinecart>() {
                @Override
                protected PoreRideableMinecart convert(MinecartRideable handle) {
                    return new PoreRideableMinecart(handle);
                }
            };
        }
        return converter;
    }

    protected PoreRideableMinecart(MinecartRideable handle) {
        super(handle);
    }

    @Override
    public MinecartRideable getHandle() {
        return (MinecartRideable) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreRideableMinecart of(MinecartRideable handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART;
    }

}
