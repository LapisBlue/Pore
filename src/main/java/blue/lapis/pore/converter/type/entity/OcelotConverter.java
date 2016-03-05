/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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
import org.bukkit.entity.Ocelot;
import org.spongepowered.api.data.type.OcelotType;
import org.spongepowered.api.data.type.OcelotTypes;

public final class OcelotConverter {

    private OcelotConverter() {
    }

    private static final Converter<Ocelot.Type, OcelotType> CONVERTER =
            TypeConverter.builder(Ocelot.Type.class, OcelotType.class)
                    .add(Ocelot.Type.BLACK_CAT, OcelotTypes.BLACK_CAT)
                    .add(Ocelot.Type.RED_CAT, OcelotTypes.RED_CAT)
                    .add(Ocelot.Type.SIAMESE_CAT, OcelotTypes.SIAMESE_CAT)
                    .add(Ocelot.Type.WILD_OCELOT, OcelotTypes.WILD_OCELOT)
                    .build();

    public static OcelotType of(Ocelot.Type type) {
        return CONVERTER.convert(type);
    }

    public static Ocelot.Type of(OcelotType type) {
        return CONVERTER.reverse().convert(type);
    }

}
