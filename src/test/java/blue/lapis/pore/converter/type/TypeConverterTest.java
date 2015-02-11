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

import blue.lapis.pore.PoreTests;

import org.junit.Test;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.hanging.art.Arts;
import org.spongepowered.api.entity.living.animal.DyeColors;
import org.spongepowered.api.entity.living.animal.HorseColors;
import org.spongepowered.api.entity.living.animal.HorseStyles;
import org.spongepowered.api.entity.living.animal.HorseVariants;
import org.spongepowered.api.entity.living.animal.OcelotTypes;
import org.spongepowered.api.entity.living.animal.RabbitTypes;
import org.spongepowered.api.entity.living.monster.SkeletonTypes;
import org.spongepowered.api.entity.player.gamemode.GameModes;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.potion.PotionEffectTypes;
import org.spongepowered.api.util.rotation.Rotations;
import org.spongepowered.api.world.DimensionTypes;
import org.spongepowered.api.world.biome.BiomeTypes;

public class TypeConverterTest {

    @Test
    public void testArt() throws Exception {
        PoreTests.setConstants(Arts.class);
        new ArtConverter();
    }

    @Test
    public void testBiome() throws Exception {
        PoreTests.setConstants(BiomeTypes.class);
        new BiomeConverter();
    }

    @Test
    public void testDirection() throws Exception {
        new DirectionConverter();
    }

    @Test
    public void testDyeColor() throws Exception {
        PoreTests.setConstants(DyeColors.class);
        new DyeColorConverter();
    }

    @Test
    public void testEnvironment() throws Exception {
        PoreTests.setConstants(DimensionTypes.class);
        new EnvironmentConverter();
    }

    @Test
    public void testEventPriority() throws Exception {
        new EventPriorityConverter();
    }

    @Test
    public void testGameMode() throws Exception {
        PoreTests.setConstants(GameModes.class);
        new GameModeConverter();
    }

    @Test
    public void testHorse() throws Exception {
        PoreTests.setConstants(HorseVariants.class, HorseColors.class, HorseStyles.class);
        new HorseConverter();
    }

    @Test
    public void testMaterial() throws Exception {
        PoreTests.setConstants(BlockTypes.class, ItemTypes.class);
        new MaterialConverter();
    }

    @Test
    public void testOcelot() throws Exception {
        PoreTests.setConstants(OcelotTypes.class);
        new OcelotConverter();
    }

    @Test
    public void testPotionEffectType() throws Exception {
        PoreTests.setConstants(PotionEffectTypes.class);
        new PotionEffectTypeConverter();
    }

    @Test
    public void testRabbit() throws Exception {
        PoreTests.setConstants(RabbitTypes.class);
        new RabbitConverter();
    }

    @Test
    public void testRotation() throws Exception {
        PoreTests.setConstants(Rotations.class);
        new RotationConverter();
    }

    @Test
    public void testSkeleton() throws Exception {
        PoreTests.setConstants(SkeletonTypes.class);
        new SkeletonConverter();
    }

    @Test
    public void testSound() throws Exception {
        PoreTests.setConstants(SoundTypes.class);
        new SoundConverter();
    }

}
