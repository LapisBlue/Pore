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

import blue.lapis.pore.util.converter.PoreConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Creeper;

public class PoreCreeper extends PoreMonster implements org.bukkit.entity.Creeper {

    public static PoreCreeper of(Creeper handle) {
        return PoreConverter.of(PoreCreeper.class, handle);
    }

    protected PoreCreeper(Creeper handle) {
        super(handle);
    }

    @Override
    public Creeper getHandle() {
        return (Creeper) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.CREEPER;
    }

    @Override
    public boolean isPowered() {
        return getHandle().isPowered();
    }

    @Override
    public void setPowered(boolean value) {
        getHandle().setPowered(value);
    }
}
