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
package net.amigocraft.pore.impl;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.BanEntry;
import org.bukkit.BanList;

import java.util.Date;
import java.util.Set;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreBanList implements BanList {

    @Override
    public BanEntry getBanEntry(String target) {
        throw new NotImplementedException();
    }

    @Override
    public BanEntry addBan(String target, String reason, Date expires, String source) {
        throw new NotImplementedException();
    }

    @Override
    public Set<BanEntry> getBanEntries() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBanned(String target) {
        throw new NotImplementedException();
    }

    @Override
    public void pardon(String target) {
        throw new NotImplementedException();
    }
}
