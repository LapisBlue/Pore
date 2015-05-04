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
package blue.lapis.pore.impl;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.BanEntry;
import org.spongepowered.api.util.ban.Ban;

import java.util.Date;

public class PoreBanEntry extends PoreWrapper<Ban> implements BanEntry {

    public static PoreBanEntry of(Ban handle) {
        return WrapperConverter.of(PoreBanEntry.class, handle);
    }

    protected PoreBanEntry(Ban handle) {
        super(handle);
    }

    @Override
    public String getTarget() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Date getCreated() {
        return getHandle().getStartDate();
    }

    @Override
    public void setCreated(Date created) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getSource() {
        if (!getHandle().getSource().isPresent()) {
            return null;
        }
        return getHandle().getSource().get().getName();
    }

    @Override
    public void setSource(String source) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Date getExpiration() {
        if (!getHandle().getExpirationDate().isPresent()) {
            return null;
        }
        return getHandle().getExpirationDate().get();
    }

    @Override
    public void setExpiration(Date expiration) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getReason() {
        return getHandle().getReason().toString();
    }

    @Override
    public void setReason(String reason) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void save() {
        throw new NotImplementedException("TODO");
    }
}
