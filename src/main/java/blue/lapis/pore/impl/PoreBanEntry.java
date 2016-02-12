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

import blue.lapis.pore.util.PoreText;

import org.bukkit.BanEntry;
import org.spongepowered.api.util.ban.Ban;

import java.util.Date;

final class PoreBanEntry implements BanEntry {

    private final String target;
    private final PoreBanList<?> banList;
    private Date created;
    private String source;
    private Date expiration;
    private String reason;

    PoreBanEntry(String target, PoreBanList<?> banList) {
        this.target = target;
        this.banList = banList;
    }

    <T extends Ban> PoreBanEntry(T ban, PoreBanList<T> banList) {
        this.banList = banList;
        this.target = banList.getTarget(ban);
        this.created = Date.from(ban.getCreationDate());
        this.source = ban.getBanSource().map(PoreText::convert).orElse(null);
        this.expiration = ban.getExpirationDate().map(Date::from).orElse(null);
        this.reason = PoreText.convert(ban.getReason());
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public Date getExpiration() {
        return expiration;
    }

    @Override
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void save() {
        Ban.Builder builder = Ban.builder();
        if (!banList.setTarget(builder, target)) {
            return;
        }
        if (reason != null) {
            builder.reason(PoreText.convert(reason));
        }
        if (expiration != null) {
            builder.expirationDate(expiration.toInstant());
        }
        if (source != null) {
            builder.source(PoreText.convert(source));
        }
        PoreBanList.getBanService().addBan(builder.build());
    }
}
