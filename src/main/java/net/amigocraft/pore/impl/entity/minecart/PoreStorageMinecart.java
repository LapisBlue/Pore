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
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.entity.vehicle.minecart.MinecartChest;

public class PoreStorageMinecart extends PoreMinecart implements StorageMinecart {

    private static TypeConverter<MinecartChest, PoreStorageMinecart> converter;

    @SuppressWarnings("unchecked")
    public static TypeConverter<MinecartChest, PoreStorageMinecart> getStorageMinecartConverter() {
        if (converter == null) {
            converter = new TypeConverter<MinecartChest, PoreStorageMinecart>() {
                @Override
                protected PoreStorageMinecart convert(MinecartChest handle) {
                    return new PoreStorageMinecart(handle);
                }
            };
        }
        return converter;
    }

    protected PoreStorageMinecart(MinecartChest handle) {
        super(handle);
    }

    @Override
    public MinecartChest getHandle() {
        return (MinecartChest) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreStorageMinecart of(MinecartChest handle) {
        return converter.apply(handle);
    }

    //TODO: bridge

    @Override
    public EntityType getType() {
        return EntityType.MINECART_CHEST;
    }

    @Override
    public Inventory getInventory() {
        throw new NotImplementedException();
    }

}
