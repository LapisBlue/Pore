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
package net.amigocraft.pore.impl.inventory.meta;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

// TODO: bridge

// TODO: bridge

public class PorePotionMeta extends PoreItemMeta implements PotionMeta {

    @Override
    public boolean hasCustomEffects() {
        throw new NotImplementedException();
    }

    @Override
    public List<PotionEffect> getCustomEffects() {
        throw new NotImplementedException();
    }

    @Override
    public boolean addCustomEffect(PotionEffect effect, boolean overwrite) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeCustomEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasCustomEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean setMainEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean clearCustomEffects() {
        throw new NotImplementedException();
    }

    @Override
    public PotionMeta clone() {
        throw new NotImplementedException();
    }

}