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
package blue.lapis.pore.impl.command;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.wrapper.PoreConverter;
import blue.lapis.pore.impl.permissions.PorePermissible;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.spongepowered.api.util.command.CommandSource;

public class PoreCommandSender extends PorePermissible implements CommandSender {

    public static CommandSender of(CommandSource source) {
        return PoreConverter.of(PoreCommandSender.class, source);
    }

    // TODO
    protected PoreCommandSender(CommandSource handle) {
        super(handle);
    }

    @Override
    public CommandSource getHandle() {
        return (CommandSource) super.getHandle();
    }

    @Override
    public void sendMessage(String message) {
        getHandle().sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        getHandle().sendMessage(messages);
    }

    @Override
    public Server getServer() {
        return Pore.getServer();
    }

    @Override
    public String getName() {
        return "FAIL";
    }

}
