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
package blue.lapis.pore.converter.type.scoreboard;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.scoreboard.NameTagVisibility;
import org.spongepowered.api.scoreboard.Visibilities;
import org.spongepowered.api.scoreboard.Visibility;

public class NameTagVisibilityConverter {

    private static final Converter<NameTagVisibility, Visibility> CONVERTER =
            TypeConverter.<NameTagVisibility, Visibility>builder()
                    .add(NameTagVisibility.ALWAYS, Visibilities.ALL)
                    .add(NameTagVisibility.NEVER, Visibilities.NONE)
                    .add(NameTagVisibility.HIDE_FOR_OTHER_TEAMS, Visibilities.OWN_TEAM)
                    .add(NameTagVisibility.HIDE_FOR_OWN_TEAM, Visibilities.OTHER_TEAMS)
                    .build();

    public static Visibility of(NameTagVisibility slot) {
        return CONVERTER.convert(slot);
    }

    public static NameTagVisibility of(Visibility slot) {
        return CONVERTER.reverse().convert(slot);
    }

}
