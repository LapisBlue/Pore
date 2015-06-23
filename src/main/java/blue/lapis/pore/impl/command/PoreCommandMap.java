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
import blue.lapis.pore.PoreBootstrap;
import blue.lapis.pore.command.PoreCommandCallable;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;

import java.util.Collection;
import java.util.List;

public class PoreCommandMap extends SimpleCommandMap {

    private static final CommandService handle = Pore.getGame().getCommandDispatcher();

    public PoreCommandMap(Server server) {
        super(server);
    }

    @Override
    public void setFallbackCommands() {
        // Don't register help command, let Sponge provide it instead
    }

    @Override
    public boolean register(String label, String fallbackPrefix, Command command) {
        // TODO: Label
        // TODO: Fallback prefix

        Object plugin = PoreBootstrap.getInstance();
        if (command instanceof PluginCommand) {
            plugin = Pore.getPlugin(((PluginCommand) command).getPlugin());
        }

        List<String> aliases = Lists.newArrayList(command.getAliases());
        String name = command.getName();
        if (!name.equals(label)) {
            aliases.add(0, label);
        }
        aliases.add(0, name);

        Optional<CommandMapping> result = handle.register(plugin, new PoreCommandCallable(command), aliases);
        if (result.isPresent()) {
            command.register(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Command getCommand(String name) {
        Optional<? extends CommandMapping> command = handle.get(name);
        if (command.isPresent()) {
            CommandCallable callable = command.get().getCallable();
            if (callable instanceof PoreCommandCallable) {
                return ((PoreCommandCallable) callable).getHandle();
            }
        }

        return null;
    }

    @Override
    public Collection<Command> getCommands() {
        // TODO: Support all commands
        return Collections2.transform(Collections2.filter(handle.getCommands(),
                PORE_COMMAND_CALLABLE), GET_PORE_COMMAND);
    }

    private static final Predicate<CommandMapping> PORE_COMMAND_CALLABLE = new Predicate<CommandMapping>() {

        @Override
        public boolean apply(CommandMapping input) {
            return input.getCallable() instanceof PoreCommandCallable;
        }
    };

    private static final Function<CommandMapping, Command> GET_PORE_COMMAND = new Function<CommandMapping, Command>() {

        @Override
        public Command apply(CommandMapping input) {
            return ((PoreCommandCallable) input).getHandle();
        }
    };

    @Override
    public synchronized void clearCommands() {
        throw new UnsupportedOperationException(); // Unsupported for now
    }

    @Override
    public boolean dispatch(CommandSender sender, String commandLine) throws CommandException {
        return handle.process(((PoreCommandSender) sender).getHandle(), commandLine).isPresent();
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String cmdLine) {
        return handle.getSuggestions(((PoreCommandSender) sender).getHandle(), cmdLine);
    }

    @Override
    public void registerServerAliases() {
        // TODO
    }

}
