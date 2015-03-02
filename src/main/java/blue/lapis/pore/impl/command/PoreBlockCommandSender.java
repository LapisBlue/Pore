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

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.block.PoreBlock;

import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.spongepowered.api.util.command.source.CommandBlockSource;

public class PoreBlockCommandSender extends PoreCommandSender implements BlockCommandSender {

    public static PoreBlockCommandSender of(CommandBlockSource handle) {
        return WrapperConverter.of(PoreBlockCommandSender.class, handle);
    }

    protected PoreBlockCommandSender(CommandBlockSource handle) {
        super(handle);
    }

    @Override
    public CommandBlockSource getHandle() {
        return (CommandBlockSource) super.getHandle();
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getLocation().getBlock());
    }

}
