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
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.spongepowered.api.entity.projectile.ThrownPotion;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements org.bukkit.entity.ThrownPotion {

    private static TypeConverter<ThrownPotion, PoreThrownPotion> converter;

    static TypeConverter<ThrownPotion, PoreThrownPotion> getThrownPotionConverter() {
        if (converter == null) {
            converter = new TypeConverter<ThrownPotion, PoreThrownPotion>() {
                @Override
                protected PoreThrownPotion convert(ThrownPotion handle) {
                    return new PoreThrownPotion(handle);
                }
            };
        }
        return converter;
    }

    protected PoreThrownPotion(ThrownPotion handle) {
        super(handle);
    }

    @Override
    public ThrownPotion getHandle() {
        return (ThrownPotion) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreThrownPotion of(ThrownPotion handle) {
        return converter.apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.SPLASH_POTION;
    }

    @Override
    public Collection<PotionEffect> getEffects() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public ItemStack getItem() {
        return ItemStackConverter.of(getHandle().getItem());
    }

    @Override
    public void setItem(ItemStack item) {
        getHandle().setItem(ItemStackConverter.of(item));
    }
}
