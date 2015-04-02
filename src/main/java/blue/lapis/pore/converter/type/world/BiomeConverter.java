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
import org.bukkit.block.Biome;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;

public final class BiomeConverter {

    public static final Converter<Biome, BiomeType> CONVERTER = TypeConverter.<Biome, BiomeType>builder()
            .add(Biome.BEACH, BiomeTypes.BEACH)
            .add(Biome.BIRCH_FOREST, BiomeTypes.BIRCH_FOREST)
            .add(Biome.BIRCH_FOREST_HILLS, BiomeTypes.BIRCH_FOREST_HILLS)
            .add(Biome.BIRCH_FOREST_HILLS_MOUNTAINS, BiomeTypes.BIRCH_FOREST_HILLS_MOUNTAINS)
            .add(Biome.BIRCH_FOREST_MOUNTAINS, BiomeTypes.BIRCH_FOREST_MOUNTAINS)
            .add(Biome.COLD_BEACH, BiomeTypes.COLD_BEACH)
            .add(Biome.COLD_TAIGA, BiomeTypes.COLD_TAIGA)
            .add(Biome.COLD_TAIGA_HILLS, BiomeTypes.COLD_TAIGA_HILLS)
            .add(Biome.COLD_TAIGA_MOUNTAINS, BiomeTypes.COLD_TAIGA_MOUNTAINS)
            .add(Biome.DEEP_OCEAN, BiomeTypes.DEEP_OCEAN)
            .add(Biome.DESERT, BiomeTypes.DESERT)
            .add(Biome.DESERT_HILLS, BiomeTypes.DESERT_HILLS)
            .add(Biome.DESERT_MOUNTAINS, BiomeTypes.DESERT_MOUNTAINS)
            .add(Biome.EXTREME_HILLS, BiomeTypes.EXTREME_HILLS)
            .add(Biome.EXTREME_HILLS_MOUNTAINS, BiomeTypes.EXTREME_HILLS_MOUNTAINS)
            .add(Biome.EXTREME_HILLS_PLUS, BiomeTypes.EXTREME_HILLS_PLUS)
            .add(Biome.EXTREME_HILLS_PLUS_MOUNTAINS, BiomeTypes.EXTREME_HILLS_PLUS_MOUNTAINS)
            .add(Biome.FLOWER_FOREST, BiomeTypes.FLOWER_FOREST)
            .add(Biome.FOREST, BiomeTypes.FOREST)
            .add(Biome.FOREST_HILLS, BiomeTypes.FOREST_HILLS)
            .add(Biome.FROZEN_OCEAN, BiomeTypes.FROZEN_OCEAN)
            .add(Biome.FROZEN_RIVER, BiomeTypes.FROZEN_RIVER)
            .add(Biome.HELL, BiomeTypes.HELL)
            .add(Biome.ICE_MOUNTAINS, BiomeTypes.ICE_MOUNTAINS)
            .add(Biome.ICE_PLAINS, BiomeTypes.ICE_PLAINS)
            .add(Biome.ICE_PLAINS_SPIKES, BiomeTypes.ICE_PLAINS_SPIKES)
            .add(Biome.JUNGLE, BiomeTypes.JUNGLE)
            .add(Biome.JUNGLE_EDGE, BiomeTypes.JUNGLE_EDGE)
            .add(Biome.JUNGLE_EDGE_MOUNTAINS, BiomeTypes.JUNGLE_EDGE_MOUNTAINS)
            .add(Biome.JUNGLE_HILLS, BiomeTypes.JUNGLE_HILLS)
            .add(Biome.JUNGLE_MOUNTAINS, BiomeTypes.JUNGLE_MOUNTAINS)
            .add(Biome.MEGA_SPRUCE_TAIGA, BiomeTypes.MEGA_SPRUCE_TAIGA)
            .add(Biome.MEGA_SPRUCE_TAIGA_HILLS, BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS)
            .add(Biome.MEGA_TAIGA, BiomeTypes.MEGA_TAIGA)
            .add(Biome.MEGA_TAIGA_HILLS, BiomeTypes.MEGA_TAIGA_HILLS)
            .add(Biome.MESA, BiomeTypes.MESA)
            .add(Biome.MESA_BRYCE, BiomeTypes.MESA_BRYCE)
            .add(Biome.MESA_PLATEAU, BiomeTypes.MESA_PLATEAU)
            .add(Biome.MESA_PLATEAU_FOREST, BiomeTypes.MESA_PLATEAU_FOREST)
            .add(Biome.MESA_PLATEAU_FOREST_MOUNTAINS, BiomeTypes.MESA_PLATEAU_FOREST_MOUNTAINS)
            .add(Biome.MESA_PLATEAU_MOUNTAINS, BiomeTypes.MESA_PLATEAU_MOUNTAINS)
            .add(Biome.MUSHROOM_ISLAND, BiomeTypes.MUSHROOM_ISLAND)
            .add(Biome.MUSHROOM_SHORE, BiomeTypes.MUSHROOM_ISLAND_SHORE)
            .add(Biome.OCEAN, BiomeTypes.OCEAN)
            .add(Biome.PLAINS, BiomeTypes.PLAINS)
            .add(Biome.RIVER, BiomeTypes.RIVER)
            .add(Biome.ROOFED_FOREST, BiomeTypes.ROOFED_FOREST)
            .add(Biome.ROOFED_FOREST_MOUNTAINS, BiomeTypes.ROOFED_FOREST_MOUNTAINS)
            .add(Biome.SAVANNA, BiomeTypes.SAVANNA)
            .add(Biome.SAVANNA_MOUNTAINS, BiomeTypes.SAVANNA_MOUNTAINS)
            .add(Biome.SAVANNA_PLATEAU, BiomeTypes.SAVANNA_PLATEAU)
            .add(Biome.SAVANNA_PLATEAU_MOUNTAINS, BiomeTypes.SAVANNA_PLATEAU_MOUNTAINS)
            .add(Biome.SKY, BiomeTypes.SKY)
                    //.add(Biome.SMALL_MOUNTAINS, BiomeTypes.SMALL_MOUNTAINS) // TODO: Missing in Sponge
            .add(Biome.STONE_BEACH, BiomeTypes.STONE_BEACH)
            .add(Biome.SUNFLOWER_PLAINS, BiomeTypes.SUNFLOWER_PLAINS)
            .add(Biome.SWAMPLAND, BiomeTypes.SWAMPLAND)
            .add(Biome.SWAMPLAND_MOUNTAINS, BiomeTypes.SWAMPLAND_MOUNTAINS)
            .add(Biome.TAIGA, BiomeTypes.TAIGA)
            .add(Biome.TAIGA_HILLS, BiomeTypes.TAIGA_HILLS)
            .add(Biome.TAIGA_MOUNTAINS, BiomeTypes.TAIGA_MOUNTAINS)
            .build();

    public static BiomeType of(Biome biome) {
        return CONVERTER.convert(biome);
    }

    public static Biome of(BiomeType biomeType) {
        return CONVERTER.reverse().convert(biomeType);
    }

}
