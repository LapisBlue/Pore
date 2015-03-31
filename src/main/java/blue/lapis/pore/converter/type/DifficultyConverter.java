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
package blue.lapis.pore.converter.type;

import com.google.common.base.Converter;
import org.bukkit.block.Biome;
import org.spongepowered.api.world.difficulty.Difficulties;
import org.spongepowered.api.world.difficulty.Difficulty;

public class DifficultyConverter {

    public static final Converter<org.bukkit.Difficulty, Difficulty> CONVERTER =
            TypeConverter.<org.bukkit.Difficulty, Difficulty>builder()
                    .add(org.bukkit.Difficulty.PEACEFUL, Difficulties.PEACEFUL)
                    .add(org.bukkit.Difficulty.EASY, Difficulties.EASY)
                    .add(org.bukkit.Difficulty.NORMAL, Difficulties.NORMAL)
                    .add(org.bukkit.Difficulty.HARD, Difficulties.HARD)
            .build();

    public static Difficulty of(org.bukkit.Difficulty biome) {
        return CONVERTER.convert(biome);
    }

    public static org.bukkit.Difficulty of(Difficulty biomeType) {
        return CONVERTER.reverse().convert(biomeType);
    }
}
