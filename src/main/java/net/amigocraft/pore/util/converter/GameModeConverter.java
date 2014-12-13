/*
 * Pore
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
package net.amigocraft.pore.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.GameMode;
import org.spongepowered.api.entity.player.gamemode.GameModes;

public class GameModeConverter {

    private static BiMap<org.bukkit.GameMode, org.spongepowered.api.entity.player.gamemode.GameMode> map =
            ImmutableBiMap.<org.bukkit.GameMode, org.spongepowered.api.entity.player.gamemode.GameMode>builder()
                    .put(GameMode.SURVIVAL, GameModes.SURVIVAL)
                    .put(GameMode.CREATIVE, GameModes.CREATIVE)
                    .put(GameMode.ADVENTURE, GameModes.ADVENTURE)
                    .put(GameMode.SPECTATOR, GameModes.SPECTATOR)
                    .build();

    public static org.spongepowered.api.entity.player.gamemode.GameMode of(org.bukkit.GameMode gameMode) {
        return map.get(gameMode);
    }

    public static org.bukkit.GameMode of(org.spongepowered.api.entity.player.gamemode.GameMode gameMode) {
        return map.inverse().get(gameMode);
    }

}
