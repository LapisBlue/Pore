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
package net.amigocraft.pore.impl.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.spongepowered.api.entity.living.monster.*;

public class PoreMonster extends PoreCreature implements org.bukkit.entity.Monster {

    private static TypeConverter<Monster, PoreMonster> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Monster, PoreMonster> getMonsterConverter() {
        if (converter == null) {
            converter = new TypeConverter<Monster, PoreMonster>(
                    (ImmutableMap) ImmutableMap.builder()
                            .put(Blaze.class, PoreBlaze.getBlazeConverter())
                            .put(Creeper.class, PoreCreeper.getCreeperConverter())
                            .put(Enderman.class, PoreEnderman.getEndermanConverter())
                            .put(Giant.class, PoreGiant.getGiantConverter())
                            .put(Silverfish.class, PoreSilverfish.getSilverfishConverter())
                            .put(Skeleton.class, PoreSkeleton.getSkeletonConverter())
                            .put(Spider.class, PoreSpider.getSpiderConverter())
                            .put(Witch.class, PoreWitch.getWitchConverter())
                            .put(Wither.class, PoreWither.getWitherConverter())
                            .put(Zombie.class, PoreZombie.getZombieConverter())
                            .build()
            ) {
                @Override
                protected PoreMonster convert(Monster handle) {
                    return new PoreMonster(handle);
                }
            };
        }
        return converter;
    }

    protected PoreMonster(Monster handle) {
        super(handle);
    }

    @Override
    public Monster getHandle() {
        return (Monster) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreMonster of(Monster handle) {
        return converter.apply(handle);
    }

}
