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

import net.amigocraft.pore.impl.block.PoreBlockState;
import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.spongepowered.api.item.ItemBlock;

public class PoreEnderman extends PoreMonster implements Enderman {

    private static TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman>
    getEndermanConverter() {
        if (converter == null) {
            converter =
                    new TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman>() {
                        @Override
                        protected PoreEnderman convert(
                                org.spongepowered.api.entity.living.monster.Enderman handle) {
                            return new PoreEnderman(handle);
                        }
                    };
        }
        return converter;
    }

    protected PoreEnderman(org.spongepowered.api.entity.living.monster.Enderman handle) {
        super(handle);
    }

    @Override
    public org.spongepowered.api.entity.living.monster.Enderman getHandle() {
        return (org.spongepowered.api.entity.living.monster.Enderman) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreEnderman of(org.spongepowered.api.entity.living.monster.Enderman handle) {
        return converter.apply(handle);
    }

    //TODO: bridge

    @Override
    public EntityType getType() {
        return EntityType.ENDERMAN;
    }

    @Override
    public MaterialData getCarriedMaterial() {
        return getHandle().getCarriedBlock().isPresent() ?
                PoreBlockState.of(getHandle().getCarriedBlock().get()).getData() :
                null;
    }

    @Override
    public void setCarriedMaterial(MaterialData material) {
        ItemBlock type = (ItemBlock) MaterialConverter.toItemType(material.getItemType());
        if (type != null) {
            //getHandle().setCarriedBlock(type); //TODO: not sure of how to create the block state
            throw new NotImplementedException();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
