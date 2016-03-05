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

package blue.lapis.pore.impl.event.player;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.command.TabCompleteEvent;

import java.util.Collection;
import java.util.Collections;

@RegisterEvent
public final class PorePlayerChatTabCompleteEvent extends PlayerChatTabCompleteEvent
        implements PoreEvent<TabCompleteEvent> {

    private final TabCompleteEvent handle;
    private final Player source;

    public PorePlayerChatTabCompleteEvent(TabCompleteEvent handle, @Source Player source) {
        super(null, "", Collections.<String>emptyList());
        this.handle = checkNotNull(handle, "handle");
        this.source = checkNotNull(source, "source");
    }

    @Override
    public TabCompleteEvent getHandle() {
        return handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(source);
    }

    @Override
    public String getChatMessage() {
        return getHandle().getRawMessage();
    }

    @Override
    public String getLastToken() {
        return StringUtils.substringAfterLast(getChatMessage(), " ");
    }

    @Override
    public Collection<String> getTabCompletions() {
        return getHandle().getTabCompletions();
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

}
