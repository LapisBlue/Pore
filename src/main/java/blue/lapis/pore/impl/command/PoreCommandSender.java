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

package blue.lapis.pore.impl.command;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.permissions.PorePermissible;
import blue.lapis.pore.util.PoreText;

import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

public class PoreCommandSender extends PorePermissible implements CommandSender {

    public static CommandSender of(CommandSource source) {
        return WrapperConverter.of(PoreCommandSender.class, source);
    }

    protected PoreCommandSender(CommandSource handle) {
        super(handle);
    }

    @Override
    public CommandSource getHandle() {
        return (CommandSource) super.getHandle();
    }

    @Override
    public String getName() {
        return getHandle().getName();
    }

    @Override
    public Server getServer() {
        return Pore.getServer();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String message) {
        getHandle().sendMessage(PoreText.convert(message));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String[] messages) {
        Text[] texts = new Text[messages.length];
        for (int i = 0; i < messages.length; i++) {
            texts[i] = PoreText.convert(messages[i]);
        }
        this.getHandle().sendMessages(texts);
    }

}
