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

import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingSand;
import org.spongepowered.api.entity.FallingBlock;

public class PoreFallingSand extends PoreEntity implements FallingSand {

    private static TypeConverter<FallingBlock, PoreFallingSand> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<FallingBlock, PoreFallingSand> getFallingSandConverter() {
        if (converter == null) {
            converter = new TypeConverter<FallingBlock, PoreFallingSand>() {
                @Override
                protected PoreFallingSand convert(FallingBlock handle) {
                    return new PoreFallingSand(handle);
                }
            };
        }
        return converter;
    }

    protected PoreFallingSand(FallingBlock handle) {
        super(handle);
    }

    @Override
    public FallingBlock getHandle() {
        return (FallingBlock) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreFallingSand of(FallingBlock handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.FALLING_BLOCK;
    }

    @Override
    public Material getMaterial() {
        return MaterialConverter.toBukkitMaterial(getHandle().getBlockState().getType());
    }

    @Override
    public int getBlockId() {
        return MaterialConverter.toBukkitMaterial(getHandle().getBlockState().getType()).getId();
    }

    @Override
    public byte getBlockData() {
        return getHandle().getBlockState().getDataValue();
    }

    @Override
    public boolean getDropItem() {
        return getHandle().getCanDropAsItem();
    }

    @Override
    public void setDropItem(boolean drop) {
        getHandle().setCanDropAsItem(drop);
    }
}
