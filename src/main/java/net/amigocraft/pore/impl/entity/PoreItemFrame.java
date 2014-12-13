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

import net.amigocraft.pore.util.converter.ItemStackConverter;
import net.amigocraft.pore.util.converter.RotationConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.hanging.ItemFrame;

public class PoreItemFrame extends PoreHanging implements org.bukkit.entity.ItemFrame {

    private static TypeConverter<ItemFrame, PoreItemFrame> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<ItemFrame, PoreItemFrame> getItemFrameConverter() {
        if (converter == null) {
            converter = new TypeConverter<ItemFrame, PoreItemFrame>() {
                @Override
                protected PoreItemFrame convert(ItemFrame handle) {
                    return new PoreItemFrame(handle);
                }
            };
        }
        return converter;
    }

    protected PoreItemFrame(ItemFrame handle) {
        super(handle);
    }

    @Override
    public ItemFrame getHandle() {
        return (ItemFrame) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreItemFrame of(ItemFrame handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.ITEM_FRAME;
    }

    @Override
    public ItemStack getItem() {
        return getHandle().getItem().isPresent() ? ItemStackConverter.of(getHandle().getItem().get()) : null;
    }

    @Override
    public void setItem(ItemStack item) {
        getHandle().setItem(ItemStackConverter.of(item));
    }

    @Override
    public Rotation getRotation() {
        return RotationConverter.of(getHandle().getItemRotation());
    }

    @Override
    public void setRotation(Rotation rotation) throws IllegalArgumentException {
        getHandle().setRotation(RotationConverter.of(rotation));
    }
}
