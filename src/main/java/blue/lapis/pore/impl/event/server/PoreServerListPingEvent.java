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
package blue.lapis.pore.impl.event.server;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.util.PoreCachedServerIcon;
import blue.lapis.pore.util.PoreText;

import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;
import org.spongepowered.api.event.server.ClientPingServerEvent;

import java.net.InetAddress;
import java.util.Iterator;

@RegisterEvent
public class PoreServerListPingEvent extends ServerListPingEvent {

    private final ClientPingServerEvent handle;

    public PoreServerListPingEvent(ClientPingServerEvent handle) {
        super(null, null, 0, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public ClientPingServerEvent getHandle() {
        return handle;
    }

    @Override
    public InetAddress getAddress() {
        return handle.getClient().getAddress().getAddress();
    }

    @Override
    public String getMotd() {
        return PoreText.convert(handle.getResponse().getDescription());
    }

    @Override
    public void setMotd(String motd) {
        handle.getResponse().setDescription(PoreText.convert(motd));
    }

    @Override
    public int getNumPlayers() {
        return handle.getResponse().getPlayers().get().getOnline();
    }

    @Override
    public int getMaxPlayers() {
        return handle.getResponse().getPlayers().get().getMax();
    }

    @Override
    public void setMaxPlayers(int maxPlayers) {
        handle.getResponse().getPlayers().get().setMax(maxPlayers);
    }

    @Override
    public void setServerIcon(CachedServerIcon icon) throws IllegalArgumentException {
        handle.getResponse().setFavicon(((PoreCachedServerIcon) icon).getHandle());
    }

    @Override
    public Iterator<Player> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(); // Unsupported for now
    }

}
