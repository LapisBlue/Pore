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
package blue.lapis.pore.impl.metadata;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class PoreMetadataValue implements MetadataValue {

    // TODO: Bridge

    @Override
    public Object value() {
        throw new NotImplementedException();
    }

    @Override
    public int asInt() {
        throw new NotImplementedException();
    }

    @Override
    public float asFloat() {
        throw new NotImplementedException();
    }

    @Override
    public double asDouble() {
        throw new NotImplementedException();
    }

    @Override
    public long asLong() {
        throw new NotImplementedException();
    }

    @Override
    public short asShort() {
        throw new NotImplementedException();
    }

    @Override
    public byte asByte() {
        throw new NotImplementedException();
    }

    @Override
    public boolean asBoolean() {
        throw new NotImplementedException();
    }

    @Override
    public String asString() {
        throw new NotImplementedException();
    }

    @Override
    public Plugin getOwningPlugin() {
        throw new NotImplementedException();
    }

    @Override
    public void invalidate() {
        throw new NotImplementedException();
    }

}
