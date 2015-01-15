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
package blue.lapis.pore.util.converter.entity;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Rabbit;
import org.spongepowered.api.entity.living.meta.RabbitType;
import org.spongepowered.api.entity.living.meta.RabbitTypes;

public class RabbitConverter {

    private static BiMap<RabbitType, Rabbit.Type> TYPES = ImmutableBiMap.<RabbitType, Rabbit.Type>builder()
            .put(RabbitTypes.BROWN, Rabbit.Type.BROWN)
            .put(RabbitTypes.WHITE, Rabbit.Type.WHITE)
            .put(RabbitTypes.BLACK, Rabbit.Type.BLACK)
            .put(RabbitTypes.BLACK_AND_WHITE, Rabbit.Type.BLACK_AND_WHITE)
            .put(RabbitTypes.GOLD, Rabbit.Type.GOLD)
            .put(RabbitTypes.SALT_AND_PEPPER, Rabbit.Type.SALT_AND_PEPPER)
            .put(RabbitTypes.KILLER, Rabbit.Type.THE_KILLER_BUNNY)
            .build();

    public static Rabbit.Type of(RabbitType type) {
        return TYPES.get(type);
    }

    public static RabbitType of(Rabbit.Type type) {
        return TYPES.inverse().get(type);
    }

}
