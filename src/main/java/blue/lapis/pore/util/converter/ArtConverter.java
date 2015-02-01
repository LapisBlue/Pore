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

import com.google.common.base.Converter;
import org.bukkit.Art;
import org.spongepowered.api.entity.hanging.art.Arts;

public final class ArtConverter {

    public static Converter<Art, org.spongepowered.api.entity.hanging.art.Art> CONVERTER =
            TypeConverter.<Art, org.spongepowered.api.entity.hanging.art.Art>builder()
                    .add(Art.ALBAN, Arts.ALBAN)
                    .add(Art.AZTEC, Arts.AZTEC)
                    .add(Art.AZTEC2, Arts.AZTEC_2)
                    .add(Art.BOMB, Arts.BOMB)
                    .add(Art.BURNINGSKULL, Arts.BURNING_SKULL)
                    .add(Art.COURBET, Arts.COURBET)
                    .add(Art.CREEBET, Arts.CREEBET)
                    .add(Art.DONKEYKONG, Arts.DONKEY_KONG)
                    .add(Art.FIGHTERS, Arts.FIGHTERS)
                    .add(Art.GRAHAM, Arts.GRAHAM)
                    .add(Art.KEBAB, Arts.KEBAB)
                    .add(Art.MATCH, Arts.MATCH)
                    .add(Art.PIGSCENE, Arts.PIGSCENE)
                    .add(Art.PLANT, Arts.PLANT)
                    .add(Art.POINTER, Arts.POINTER)
                    .add(Art.POOL, Arts.POOL)
                    .add(Art.SEA, Arts.SEA)
                    .add(Art.SKELETON, Arts.SKELETON)
                    .add(Art.SKULL_AND_ROSES, Arts.SKULL_AND_ROSES)
                    .add(Art.STAGE, Arts.STAGE)
                    .add(Art.SUNSET, Arts.SUNSET)
                    .add(Art.VOID, Arts.VOID)
                    .add(Art.WANDERER, Arts.WANDERER)
                    .add(Art.WASTELAND, Arts.WASTELAND)
                    .add(Art.WITHER, Arts.WITHER)
                    .build();

    public static org.spongepowered.api.entity.hanging.art.Art of(Art art) {
        return CONVERTER.convert(art);
    }

    public static Art of(org.spongepowered.api.entity.hanging.art.Art art) {
        return CONVERTER.reverse().convert(art);
    }

}
