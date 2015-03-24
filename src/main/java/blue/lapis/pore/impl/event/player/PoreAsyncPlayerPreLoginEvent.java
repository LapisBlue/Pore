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
package blue.lapis.pore.impl.event.player;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.spongepowered.api.event.entity.player.PlayerEvent;

import java.net.InetAddress;
import java.util.UUID;

public class PoreAsyncPlayerPreLoginEvent extends AsyncPlayerPreLoginEvent {

    private final PlayerEvent handle;

    public PoreAsyncPlayerPreLoginEvent(PlayerEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public PlayerEvent getHandle() {
        return handle;
    }

    @Override
    public String getName() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public InetAddress getAddress() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public UUID getUniqueId() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public PlayerPreLoginEvent.Result getResult() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setResult(PlayerPreLoginEvent.Result result) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public Result getLoginResult() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setLoginResult(Result result) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void allow() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void disallow(Result result, String message) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void disallow(PlayerPreLoginEvent.Result result, String message) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public String getKickMessage() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setKickMessage(String message) {
        throw new NotImplementedException(); // TODO
    }

}
