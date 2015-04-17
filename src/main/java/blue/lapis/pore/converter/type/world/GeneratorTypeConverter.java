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
package blue.lapis.pore.converter.type.world;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.WorldType;
import org.spongepowered.api.world.GeneratorType;
import org.spongepowered.api.world.GeneratorTypes;

public class GeneratorTypeConverter {

    private static final Converter<WorldType, GeneratorType> CONVERTER =
            TypeConverter.<WorldType, GeneratorType>builder()
                    .add(WorldType.NORMAL, GeneratorTypes.DEFAULT)
                    .add(WorldType.NORMAL, GeneratorTypes.DEFAULT)
                    .add(WorldType.FLAT, GeneratorTypes.FLAT)
                    /*.add(WorldType.LARGE_BIOMES, GeneratorTypes.LARGE_BIOME)
                    .add(WorldType.AMPLIFIED, GeneratorTypes.AMPLIFIED) TODO */
                    .add(WorldType.CUSTOMIZED, GeneratorTypes.DEBUG) //TODO: no idea whether this is right
            .build();

    public static GeneratorType of(WorldType worldType) {

        return CONVERTER.convert(worldType);
    }

    public static WorldType of(GeneratorType dimension) {
        return CONVERTER.reverse().convert(dimension);
    }
}
