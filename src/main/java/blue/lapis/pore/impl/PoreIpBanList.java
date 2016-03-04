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

import org.spongepowered.api.util.ban.Ban;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Optional;

public final class PoreIpBanList extends PoreBanList<Ban.Ip> {

    @Override
    protected Optional<Ban.Ip> getBanFor(String target) {
        try {
            return getBanService().getBanFor(InetAddress.getByName(target));
        } catch (UnknownHostException e) {
            return Optional.empty();
        }
    }

    @Override
    protected boolean setTarget(Ban.Builder builder, String target) {
        try {
            builder.address(InetAddress.getByName(target));
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    @Override
    protected Collection<Ban.Ip> getBans() {
        return getBanService().getIpBans();
    }

    @Override
    protected String getTarget(Ban.Ip ban) {
        return ban.getAddress().toString();
    }

    @Override
    public void pardon(String target) {
        try {
            getBanService().pardon(InetAddress.getByName(target));
        } catch (UnknownHostException ignored) {
            // Ignore
        }
    }
}
