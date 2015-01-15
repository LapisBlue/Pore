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

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.block.Biome;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.BiomeTypes;

public class BiomeConverter {

    private static final BiMap<Biome, BiomeType> map =
            ImmutableBiMap.<Biome, BiomeType>builder()
                    .put(Biome.BEACH, BiomeTypes.BEACH)
                    .put(Biome.BIRCH_FOREST, BiomeTypes.BIRCH_FOREST)
                    .put(Biome.BIRCH_FOREST_HILLS, BiomeTypes.BIRCH_FOREST_HILLS)
                    .put(Biome.BIRCH_FOREST_HILLS_MOUNTAINS, BiomeTypes.BIRCH_FOREST_HILLS_MOUNTAINS)
                    .put(Biome.BIRCH_FOREST_MOUNTAINS, BiomeTypes.BIRCH_FOREST_MOUNTAINS)
                    .put(Biome.COLD_BEACH, BiomeTypes.COLD_BEACH)
                    .put(Biome.COLD_TAIGA, BiomeTypes.COLD_TAIGA)
                    .put(Biome.COLD_TAIGA_HILLS, BiomeTypes.COLD_TAIGA_HILLS)
                    .put(Biome.COLD_TAIGA_MOUNTAINS, BiomeTypes.COLD_TAIGA_MOUNTAINS)
                    .put(Biome.DEEP_OCEAN, BiomeTypes.DEEP_OCEAN)
                    .put(Biome.DESERT, BiomeTypes.DESERT)
                    .put(Biome.DESERT_HILLS, BiomeTypes.DESERT_HILLS)
                    .put(Biome.DESERT_MOUNTAINS, BiomeTypes.DESERT_MOUNTAINS)
                    .put(Biome.EXTREME_HILLS, BiomeTypes.EXTREME_HILLS)
                    .put(Biome.EXTREME_HILLS_MOUNTAINS, BiomeTypes.EXTREME_HILLS_MOUNTAINS)
                    .put(Biome.EXTREME_HILLS_PLUS, BiomeTypes.EXTREME_HILLS_PLUS)
                    .put(Biome.EXTREME_HILLS_PLUS_MOUNTAINS, BiomeTypes.EXTREME_HILLS_PLUS_MOUNTAINS)
                    .put(Biome.FLOWER_FOREST, BiomeTypes.FLOWER_FOREST)
                    .put(Biome.FOREST, BiomeTypes.FOREST)
                    .put(Biome.FOREST_HILLS, BiomeTypes.FOREST_HILLS)
                    .put(Biome.FROZEN_OCEAN, BiomeTypes.FROZEN_OCEAN)
                    .put(Biome.FROZEN_RIVER, BiomeTypes.FROZEN_RIVER)
                    .put(Biome.HELL, BiomeTypes.HELL)
                    .put(Biome.ICE_MOUNTAINS, BiomeTypes.ICE_MOUNTAINS)
                    .put(Biome.ICE_PLAINS, BiomeTypes.ICE_PLAINS)
                    .put(Biome.ICE_PLAINS_SPIKES, BiomeTypes.ICE_PLAINS_SPIKES)
                    .put(Biome.JUNGLE, BiomeTypes.JUNGLE)
                    .put(Biome.JUNGLE_EDGE, BiomeTypes.JUNGLE_EDGE)
                    .put(Biome.JUNGLE_EDGE_MOUNTAINS, BiomeTypes.JUNGLE_EDGE_MOUNTAINS)
                    .put(Biome.JUNGLE_HILLS, BiomeTypes.JUNGLE_HILLS)
                    .put(Biome.JUNGLE_MOUNTAINS, BiomeTypes.JUNGLE_MOUNTAINS)
                    .put(Biome.MEGA_SPRUCE_TAIGA, BiomeTypes.MEGA_SPRUCE_TAIGA)
                    .put(Biome.MEGA_SPRUCE_TAIGA_HILLS, BiomeTypes.MEGA_SPRUCE_TAIGA_HILLS)
                    .put(Biome.MEGA_TAIGA, BiomeTypes.MEGA_TAIGA)
                    .put(Biome.MEGA_TAIGA_HILLS, BiomeTypes.MEGA_TAIGA_HILLS)
                    .put(Biome.MESA, BiomeTypes.MESA)
                    .put(Biome.MESA_BRYCE, BiomeTypes.MESA_BRYCE)
                    .put(Biome.MESA_PLATEAU, BiomeTypes.MESA_PLATEAU)
                    .put(Biome.MESA_PLATEAU_FOREST, BiomeTypes.MESA_PLATEAU_FOREST)
                    .put(Biome.MESA_PLATEAU_FOREST_MOUNTAINS, BiomeTypes.MESA_PLATEAU_FOREST_MOUNTAINS)
                    .put(Biome.MESA_PLATEAU_MOUNTAINS, BiomeTypes.MESA_PLATEAU_MOUNTAINS)
                    .put(Biome.MUSHROOM_ISLAND, BiomeTypes.MUSHROOM_ISLAND)
                    .put(Biome.MUSHROOM_SHORE, BiomeTypes.MUSHROOM_ISLAND_SHORE)
                    .put(Biome.OCEAN, BiomeTypes.OCEAN)
                    .put(Biome.PLAINS, BiomeTypes.PLAINS)
                    .put(Biome.RIVER, BiomeTypes.RIVER)
                    .put(Biome.ROOFED_FOREST, BiomeTypes.ROOFED_FOREST)
                    .put(Biome.ROOFED_FOREST_MOUNTAINS, BiomeTypes.ROOFED_FOREST_MOUNTAINS)
                    .put(Biome.SAVANNA, BiomeTypes.SAVANNA)
                    .put(Biome.SAVANNA_MOUNTAINS, BiomeTypes.SAVANNA_MOUNTAINS)
                            //.put(Biome.SAVANNA_PLATEAU,               BiomeTypes.SAVANNA_PLATEAU) //TODO:
                            // value typo'd
                    .put(Biome.SAVANNA_PLATEAU_MOUNTAINS, BiomeTypes.SAVANNA_PLATEAU_MOUNTAINS)
                    .put(Biome.SKY, BiomeTypes.SKY)
                            //.put(Biome.SMALL_MOUNTAINS,               BiomeTypes.SMALL_MOUNTAINS) //TODO:
                            // missing from Sponge
                    .put(Biome.STONE_BEACH, BiomeTypes.STONE_BEACH)
                    .put(Biome.SUNFLOWER_PLAINS, BiomeTypes.SUNFLOWER_PLAINS)
                    .put(Biome.SWAMPLAND, BiomeTypes.SWAMPLAND)
                    .put(Biome.SWAMPLAND_MOUNTAINS, BiomeTypes.SWAMPLAND_MOUNTAINS)
                    .put(Biome.TAIGA, BiomeTypes.TAIGA)
                    .put(Biome.TAIGA_HILLS, BiomeTypes.TAIGA_HILLS)
                    .put(Biome.TAIGA_MOUNTAINS, BiomeTypes.TAIGA_MOUNTAINS)
                    .build();

    public BiomeType of(Biome biome) {
        return map.get(biome);
    }

    public Biome of(BiomeType biome) {
        return map.inverse().get(biome);
    }

}
