/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

package blue.lapis.pore.util;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

/**
 * Displays an informative message if the user attempts to run the jar file as a
 * standalone program.
 */
public final class InfoMain {

    private InfoMain() {
    }

    private static final String ERROR = "You've just attempted to run the Pore JAR file.\n\n"
            + "Pore is a plugin for platforms implementing SpongeAPI, and must be installed on such in order "
            + "to function properly.\n"
            + "i.e., it cannot be run as a standalone program.\n";

    public static void main(String[] args) {
        // from SpongeAPI
        if (!GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, ERROR, "UnsupportedOperationException!", JOptionPane.ERROR_MESSAGE);
        } else {
            throw new UnsupportedOperationException(ERROR);
        }
    }

}
