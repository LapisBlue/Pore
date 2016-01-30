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

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.util.PoreText;

import com.google.common.collect.ImmutableSet;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.GuavaCollectors;

import java.util.IllegalFormatException;
import java.util.Set;

@RegisterEvent
public final class PoreAsyncPlayerChatEvent extends AsyncPlayerChatEvent
        implements PoreEvent<MessageChannelEvent.Chat> {

    private final MessageChannelEvent.Chat handle;
    private final Player player;

    public PoreAsyncPlayerChatEvent(MessageChannelEvent.Chat handle, @Source Player player) {
        super(true, null, null, null);
        this.handle = checkNotNull(handle, "handle");
        this.player = checkNotNull(player, "player");
    }

    @Override
    public MessageChannelEvent.Chat getHandle() {
        return handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(player);
    }

    @Override
    public String getMessage() {
        return PoreText.convert(getHandle().getRawMessage());
    }

    @Override
    public void setMessage(String message) {
        // TODO
    }

    @Override
    public String getFormat() {
        return PoreText.convert(getHandle().getMessage().orElse(null));
    }

    @Override
    public void setFormat(String format) throws IllegalFormatException, NullPointerException {
        getHandle().setMessage(PoreText.convert(String.format(format, getPlayer().getDisplayName(), getMessage())));
    }

    @Override
    public Set<org.bukkit.entity.Player> getRecipients() {
        MessageChannel channel = getHandle().getChannel().orElse(null);
        if (channel != null) {
            return channel.getMembers().stream()
                    .filter(receiver -> receiver instanceof Player)
                    .map(receiver -> PorePlayer.of((Player) receiver))
                    .collect(GuavaCollectors.toImmutableSet());
        } else {
            return ImmutableSet.of();
        }
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        getHandle().setCancelled(cancel);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

}
