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
package blue.lapis.pore.converter;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;

public class TextConverter {

    /**
     * Converts the given {@link Text} to a legacy string.
     * @param text The {@link Text} to convert
     * @return The corresponding legacy string
     */
    public static String of(Text text) {
        StringBuilder sb = new StringBuilder();
        for (Text t : text.withChildren()) {
            if (t.getColor() instanceof TextColor.Base) { // verify it's a legacy-compatible color
                sb.append(Texts.getLegacyChar())
                        .append(((TextColor.Base) t.getColor()).getCode());
            }
            if (t.getStyle() instanceof TextStyle.Base) { // verify it's a legacy-compatible style
                sb.append(Texts.getLegacyChar())
                        .append(((TextStyle.Base) t.getStyle()).getCode());
            }
        }
        return sb.toString();
    }

}
