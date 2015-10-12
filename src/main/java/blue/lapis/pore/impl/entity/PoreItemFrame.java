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

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.type.world.RotationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.item.inventory.Carrier;

import java.util.Optional;

public class PoreItemFrame extends PoreHanging implements org.bukkit.entity.ItemFrame {

    public static PoreItemFrame of(ItemFrame handle) {
        return WrapperConverter.of(PoreItemFrame.class, handle);
    }

    protected PoreItemFrame(ItemFrame handle) {
        super(handle);
    }

    @Override
    public ItemFrame getHandle() {
        return (ItemFrame) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ITEM_FRAME;
    }

    @Override
    public ItemStack getItem() {
        if (getHandle() instanceof Carrier) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack
                    = ((Carrier) getHandle()).getInventory().peek();
            if (stack.isPresent()) {
                return ItemStackConverter.of(stack.get());
            }
        }
        return null;
    }

    @Override
    public void setItem(ItemStack item) {
        if (getHandle() instanceof Carrier) {
            ((Carrier) getHandle()).getInventory().offer(ItemStackConverter.of(item));
        } else {
            throw new UnsupportedOperationException("Item frame is not an inventory carrier"); // should never happen
        }
    }

    @Override
    public Rotation getRotation() {
        return RotationConverter.of(getHandle().get(Keys.ROTATION).get());
    }

    @Override
    public void setRotation(Rotation rotation) throws IllegalArgumentException {
        checkNotNull(rotation, "Rotation must not be null");
        getHandle().offer(Keys.ROTATION, RotationConverter.of(rotation));
    }
}
