/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
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
package net.amigocraft.pore.util.converter.entity;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Skeleton;
import org.spongepowered.api.entity.living.meta.SkeletonType;
import org.spongepowered.api.entity.living.meta.SkeletonTypes;

public class SkeletonConverter {

    private static ImmutableBiMap<Skeleton.SkeletonType, SkeletonType> map =
            ImmutableBiMap.<Skeleton.SkeletonType, SkeletonType>builder()
                    .put(Skeleton.SkeletonType.NORMAL, SkeletonTypes.NORMAL)
                    .put(Skeleton.SkeletonType.WITHER, SkeletonTypes.WITHER)
                    .build();

    public static SkeletonType of(Skeleton.SkeletonType type) {
        return map.get(type);
    }

    public static Skeleton.SkeletonType of(SkeletonType type) {
        return map.inverse().get(type);
    }

    // ░░░░░░░░░░░░▄▐
    // ░░░░░░▄▄▄░░▄██▄
    // ░░░░░▐▀█▀▌░░░░▀█▄
    // ░░░░░▐█▄█▌░░░░░░▀█▄
    // ░░░░░░▀▄▀░░░▄▄▄▄▄▀▀
    // ░░░░▄▄▄██▀▀▀▀
    // ░░░█▀▄▄▄█░▀▀
    // ░░░▌░▄▄▄▐▌▀▀▀
    // ▄░▐░░░▄▄░█░▀▀
    // ▀█▌░░░▄░▀█▀░▀
    // ░░░░░░░▄▄▐▌▄▄
    // ░░░░░░░▀███▀█░▄
    // ░░░░░░▐▌▀▄▀▄▀▐▄
    // ░░░░░░▐▀░░░░░░▐▌
    // ░░░░░░█░░░░░░░░█
    // ░░░░░▐▌░░░░░░░░░█
    // ░░░░░█░░░░░░░░░░▐▌

}
