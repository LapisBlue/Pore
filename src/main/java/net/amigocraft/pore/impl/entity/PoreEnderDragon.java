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
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;

import java.util.HashSet;
import java.util.Set;

public class PoreEnderDragon extends PoreComplexLivingEntity implements EnderDragon {

    private static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon, PoreEnderDragon>
            converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon, PoreEnderDragon>
    getEnderDragonConverter() {
        if (converter == null) {
            converter =
                    new TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon,
                            PoreEnderDragon>() {
                        @Override
                        protected PoreEnderDragon convert(
                                org.spongepowered.api.entity.living.complex.EnderDragon handle) {
                            return new PoreEnderDragon(handle);
                        }
                    };
        }
        return converter;
    }

    protected PoreEnderDragon(org.spongepowered.api.entity.living.complex.EnderDragon handle) {
        super(handle);
    }

    @Override
    public org.spongepowered.api.entity.living.complex.EnderDragon getHandle() {
        return (org.spongepowered.api.entity.living.complex.EnderDragon) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreEnderDragon of(org.spongepowered.api.entity.living.complex.EnderDragon handle) {
        return converter.apply(handle);
    }

    @Override
    public Set<ComplexEntityPart> getParts() {
        Set<ComplexEntityPart> parts = new HashSet<ComplexEntityPart>();
        for (ComplexLivingPart part : getHandle().getParts()) {
            parts.add(PoreComplexEntityPart.of(part));
        }
        return parts;
    }
}
