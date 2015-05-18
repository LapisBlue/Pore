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

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.type.world.RotationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.data.manipulator.RepresentedItemData;
import org.spongepowered.api.data.manipulator.RotationalData;
import org.spongepowered.api.entity.hanging.ItemFrame;

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
        return has(RepresentedItemData.class) ? ItemStackConverter.of(get(RepresentedItemData.class).getValue()) : null;
    }

    @Override
    public void setItem(ItemStack item) {
        RepresentedItemData representeditem = getOrCreate(RepresentedItemData.class);
        representeditem.setValue(ItemStackConverter.of(item));
        set(representeditem);
    }

    @Override
    public Rotation getRotation() {
        return RotationConverter.of(get(RotationalData.class).getValue());
    }

    @Override
    public void setRotation(Rotation rotation) throws IllegalArgumentException {
        RotationalData rotational = getOrCreate(RotationalData.class);
        rotational.setValue(RotationConverter.of(rotation));
        set(rotational);
    }
}
