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
package blue.lapis.pore.converter.type.entity;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.entity.Rabbit;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RabbitTypes;

public final class RabbitConverter {

    private RabbitConverter() {
    }

    public static final Converter<Rabbit.Type, RabbitType> CONVERTER =
            TypeConverter.builder(Rabbit.Type.class, RabbitType.class)
                    .add(Rabbit.Type.BROWN, RabbitTypes.BROWN)
                    .add(Rabbit.Type.WHITE, RabbitTypes.WHITE)
                    .add(Rabbit.Type.BLACK, RabbitTypes.BLACK)
                    .add(Rabbit.Type.BLACK_AND_WHITE, RabbitTypes.BLACK_AND_WHITE)
                    .add(Rabbit.Type.GOLD, RabbitTypes.GOLD)
                    .add(Rabbit.Type.SALT_AND_PEPPER, RabbitTypes.SALT_AND_PEPPER)
                    .add(Rabbit.Type.THE_KILLER_BUNNY, RabbitTypes.KILLER)
                    .build();

    public static RabbitType of(Rabbit.Type type) {
        return CONVERTER.convert(type);
    }

    public static Rabbit.Type of(RabbitType type) {
        return CONVERTER.reverse().convert(type);
    }

}
