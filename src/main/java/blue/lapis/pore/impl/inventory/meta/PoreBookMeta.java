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

package blue.lapis.pore.impl.inventory.meta;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

// TODO: bridge

public class PoreBookMeta extends PoreItemMeta implements BookMeta {

    @Override
    public boolean hasTitle() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getTitle() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean setTitle(String title) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasAuthor() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getAuthor() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setAuthor(String author) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPages() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getPage(int page) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setPage(int page, String data) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<String> getPages() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setPages(List<String> pages) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setPages(String... pages) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void addPage(String... pages) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getPageCount() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public BookMeta clone() {
        throw new NotImplementedException("TODO");
    }
}
