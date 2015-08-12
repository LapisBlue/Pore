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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.BREEDABLE_DATA;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.api.entity.living.Ageable;

public class PoreAgeable extends PoreCreature implements org.bukkit.entity.Ageable {

    public static PoreAgeable of(Ageable handle) {
        return WrapperConverter.of(PoreAgeable.class, handle);
    }

    protected PoreAgeable(Ageable handle) {
        super(handle);
    }

    @Override
    public Ageable getHandle() {
        return (Ageable) super.getHandle();
    }

    @Override
    public int getAge() {
        return getHandle().getAgeData().age().get();
    }

    @Override
    public void setAge(int age) {
        getHandle().offer(getHandle().getAgeData().age().set(age));
    }

    @Override
    public boolean getAgeLock() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setAgeLock(boolean lock) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setBaby() {
        getHandle().getAgeData().baby().set(true);
    }

    @Override
    public boolean isAdult() {
        return getHandle().getAgeData().adult().get();
    }

    @Override
    public void setAdult() {
        getHandle().getAgeData().adult().set(true);
    }

    @Override
    public boolean canBreed() {
        return hasData(BREEDABLE_DATA) && getHandle().get(BREEDABLE_DATA).get().breedable().get();
    }

    @Override
    public void setBreed(boolean breed) {
        if (breed != canBreed()) {
            if (breed) {
                getHandle().offer(getHandle().getOrCreate(BREEDABLE_DATA).get().breedable().set(true));
            } else {
                getHandle().remove(BREEDABLE_DATA);
            }
        }
    }

}
