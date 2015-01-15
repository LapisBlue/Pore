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

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.Art;
import org.spongepowered.api.entity.hanging.art.Arts;

public class ArtConverter {

    private static ImmutableBiMap<org.bukkit.Art, org.spongepowered.api.entity.hanging.art.Art> map =
            ImmutableBiMap.<org.bukkit.Art, org.spongepowered.api.entity.hanging.art.Art>builder()
                    .put(Art.ALBAN, Arts.ALBAN)
                    .put(Art.AZTEC, Arts.AZTEC)
                    .put(Art.AZTEC2, Arts.AZTEC_2)
                    .put(Art.BOMB, Arts.BOMB)
                    .put(Art.BURNINGSKULL, Arts.BURNING_SKULL)
                    .put(Art.COURBET, Arts.COURBET)
                    .put(Art.CREEBET, Arts.CREEBET)
                    .put(Art.DONKEYKONG, Arts.DONKEY_KONG)
                    .put(Art.FIGHTERS, Arts.FIGHTERS)
                    .put(Art.GRAHAM, Arts.GRAHAM)
                    .put(Art.KEBAB, Arts.KEBAB)
                    .put(Art.MATCH, Arts.MATCH)
                    .put(Art.PIGSCENE, Arts.PIGSCENE)
                    .put(Art.PLANT, Arts.PLANT)
                    .put(Art.POINTER, Arts.POINTER)
                    .put(Art.POOL, Arts.POOL)
                    .put(Art.SEA, Arts.SEA)
                    .put(Art.SKELETON, Arts.SKELETON)
                    .put(Art.SKULL_AND_ROSES, Arts.SKULL_AND_ROSES)
                    .put(Art.STAGE, Arts.STAGE)
                    .put(Art.SUNSET, Arts.SUNSET)
                    .put(Art.VOID, Arts.VOID)
                    .put(Art.WANDERER, Arts.WANDERER)
                    .put(Art.WASTELAND, Arts.WASTELAND)
                    .put(Art.WITHER, Arts.WITHER)
                    .build();

    public static org.spongepowered.api.entity.hanging.art.Art of(org.bukkit.Art art) {
        return map.get(art);
    }

    public static org.bukkit.Art of(org.spongepowered.api.entity.hanging.art.Art art) {
        return map.inverse().get(art);
    }

}
