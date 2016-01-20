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
package blue.lapis.pore.converter.type.world.effect;

import com.google.common.collect.Lists;
import org.bukkit.Note;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.NotePitches;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class NoteConverter {

    private NoteConverter() {
    }

    // SpongeAPI's method of storing notes is kind of horrific compared to Bukkit's, for a change. I honestly might
    // consider creating an issue about it.
    public static final ArrayList<NotePitch> NOTES
            = Lists.newArrayListWithExpectedSize(NotePitches.class.getDeclaredFields().length);

    static {
        // this basically iterates the values of the SpongeAPI pseudo-enum and adds them to the class's internal list,
        // giving each an ordinal which can be used to convert directly to Bukkit Note objects
        for (Field f : NotePitches.class.getDeclaredFields()) {
            try {
                if (f.getType() == NotePitch.class) {
                    NOTES.add((NotePitch) f.get(null));
                }
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
                NOTES.add(null);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static NotePitch of(Note note) {
        if (note == null) {
            return null;
        }
        return NOTES.get(note.getId());
    }

    public static Note of(NotePitch note) {
        if (note == null) {
            return null;
        }
        return new Note(NOTES.indexOf(note));
    }
}
