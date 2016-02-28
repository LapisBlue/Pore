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

import blue.lapis.pore.Pore;

import com.google.common.base.Throwables;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.spongepowered.api.service.ban.BanService;
import org.spongepowered.api.util.ban.Ban;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public abstract class PoreBanList<T extends Ban> implements BanList {

    private final Cache<String, PoreBanEntry> cache = CacheBuilder.newBuilder().weakValues().build();

    @Override
    public BanEntry getBanEntry(String target) {
        return getBanFor(target).map(this::loadBanEntry).orElse(null);
    }

    @Override
    public BanEntry addBan(String target, String reason, Date expires, String source) {
        try {
            BanEntry entry = cache.get(target, () -> new PoreBanEntry(target, this));
            entry.setCreated(new Date());
            entry.setReason(reason);
            entry.setExpiration(expires);
            entry.setSource(source);
            entry.save();
            return entry;
        } catch (ExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    @Override
    public Set<BanEntry> getBanEntries() {
        return getBans().stream().map(this::loadBanEntry).collect(Collectors.toSet());
    }

    @Override
    public boolean isBanned(String target) {
        return getBanFor(target).isPresent();
    }

    private BanEntry loadBanEntry(T ban) {
        try {
            return cache.get(getTarget(ban), () -> new PoreBanEntry(ban, this));
        } catch (ExecutionException e) {
            throw Throwables.propagate(e);
        }
    }

    protected abstract Optional<T> getBanFor(String target);

    protected abstract boolean setTarget(Ban.Builder builder, String target);

    protected abstract Collection<T> getBans();

    protected abstract String getTarget(T ban);

    protected static BanService getBanService() {
        return Pore.getGame().getServiceManager().provideUnchecked(BanService.class);
    }
}
