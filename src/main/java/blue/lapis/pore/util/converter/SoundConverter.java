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
package blue.lapis.pore.util.converter;

import blue.lapis.pore.Pore;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.Sound;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.SoundTypes;

public class SoundConverter {

    private static final ImmutableBiMap<Sound, SoundType> map;

    static {
        ImmutableBiMap.Builder<Sound, SoundType> builder = ImmutableBiMap.builder();
        for (Sound sound : Sound.values()) {
            builder.put(sound, Pore.getGame().getRegistry().getSound(sound.name()).get());
        }
        map = builder.build();
    }

    public static SoundType of(org.bukkit.Sound sound) {
        return map.get(sound);
    }

    public static org.bukkit.Sound of(SoundType sound) {
        return map.inverse().get(sound);
    }
}
