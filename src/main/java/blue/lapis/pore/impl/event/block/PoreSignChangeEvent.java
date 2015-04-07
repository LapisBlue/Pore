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
package blue.lapis.pore.impl.event.block;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.spongepowered.api.event.block.tile.SignChangeEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

public class PoreSignChangeEvent extends org.bukkit.event.block.SignChangeEvent {

    private final SignChangeEvent handle;

    public PoreSignChangeEvent(SignChangeEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public SignChangeEvent getHandle() {
        return handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getSign().getBlock());
    }

    @Override
    public Player getPlayer() {
        return getHandle().getCause() instanceof org.spongepowered.api.entity.player.Player
                ? PorePlayer.of((org.spongepowered.api.entity.player.Player) getHandle().getCause())
                : null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String[] getLines() {
        Text[] lines = getHandle().getNewLines();
        String[] result = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = Texts.toLegacy(lines[i]);
        }
        return result;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getLine(int index) throws IndexOutOfBoundsException {
        return Texts.toLegacy(getHandle().getNewLines()[index]);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        Text[] lines = getHandle().getNewLines();
        lines[index] = Texts.fromLegacy(line);
        getHandle().setNewMessages(lines);
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        getHandle().setCancelled(cancel);
    }

}
