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

package blue.lapis.pore.event;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.plugin.EventPriorityConverter;

import com.google.common.collect.Sets;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventListener;

import java.util.Collection;
import java.util.logging.Level;

class SpongeEventHandler<S extends Event> implements EventListener<S> {

    private final EventPriority priority;
    private final Collection<RegisteredPoreEvent<?, S>> events = Sets.newIdentityHashSet();
    private boolean registered;

    SpongeEventHandler(EventPriority priority) {
        this.priority = checkNotNull(priority, "priority");
    }

    final boolean register(Class<S> event) {
        if (this.registered) {
            return false;
        } else {
            this.registered = true;
            Sponge.getEventManager().registerListener(Pore.getPlugin(), event,
                    EventPriorityConverter.of(this.priority), this);
            return true;
        }
    }

    final boolean register(RegisteredPoreEvent<?, S> event) {
        this.events.add(event);
        return register(event.getSpongeEvent());
    }

    boolean isInactive() {
        return this.events.isEmpty();
    }

    final boolean unregister() {
        if (this.registered) {
            this.registered = false;
            Sponge.getEventManager().unregisterListeners(this);
            return true;
        } else {
            return false;
        }
    }

    final boolean unregister(RegisteredPoreEvent<?, S> event) {
        this.events.remove(event);
        return isInactive() && unregister();
    }

    @Override
    public void handle(S handle) {
        final PoreEventWrapper wrapper = PoreEventWrapper.get(handle);
        for (RegisteredPoreEvent<?, S> event : this.events) {
            // Check if the event accepts this special event
            for (org.bukkit.event.Event bukkitEvent : wrapper.get(handle, event)) {
                call(bukkitEvent, this.priority);
            }
        }
    }

    private static void call(org.bukkit.event.Event event, EventPriority priority) {
        for (RegisteredListener registration : event.getHandlers().getRegisteredListeners(priority)) {
            if (!registration.getPlugin().isEnabled()) {
                continue;
            }

            try {
                registration.callEvent(event);
            } catch (AuthorNagException ex) {
                Plugin plugin = registration.getPlugin();

                if (plugin.isNaggable()) {
                    plugin.setNaggable(false);

                    Pore.getServer().getLogger().log(Level.SEVERE, String.format(
                            "Nag author(s): '%s' of '%s' about the following: %s",
                            plugin.getDescription().getAuthors(),
                            plugin.getDescription().getFullName(),
                            ex.getMessage()
                    ));
                }
            } catch (EventException ex) {
                Pore.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to "
                        + registration.getPlugin().getDescription().getFullName(), ex);
            }
        }
    }

}
