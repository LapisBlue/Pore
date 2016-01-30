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

import org.bukkit.event.EventPriority;
import org.spongepowered.api.event.Event;

final class SpongeEvent<S extends Event> extends SpongeEventHandler<S> {

    private static final EventPriority[] priorities = EventPriority.values();

    private final Class<S> event;

    @SuppressWarnings({"unchecked", "rawtypes"})
    private final SpongeEventHandler<S>[] handlers = new SpongeEventHandler[priorities.length - 1];
    private byte registrationCount;

    SpongeEvent(Class<S> event) {
        super(EventPriority.MONITOR);
        this.event = checkNotNull(event, "event");
    }

    Class<S> getEvent() {
        return this.event;
    }

    @Override
    boolean isInactive() {
        return this.registrationCount == 0 && super.isInactive();
    }

    @Override
    public void handle(S handle) {
        if (!super.isInactive()) {
            super.handle(handle);
        }

        // Cleanup cached events
        PoreEventWrapper.remove(handle);
    }

    void register(RegisteredPoreEvent<?, S> event, EventPriority priority) {
        if (priority == EventPriority.MONITOR) {
            register(event);
            return;
        }

        SpongeEventHandler<S> handler = this.handlers[priority.ordinal()];
        if (handler == null) {
            handler = new SpongeEventHandler<>(priority);
            this.handlers[priority.ordinal()] = handler;
        }

        if (handler.register(event)) {
            this.registrationCount++;
            register(this.event); // Register post event handler
        }
    }

    void unregisterAll(RegisteredPoreEvent<?, S> event) {
        for (EventPriority priority : priorities) {
            unregister(event, priority);
        }
    }

    void unregister(RegisteredPoreEvent<?, S> event, EventPriority priority) {
        if (priority == EventPriority.MONITOR) {
            unregister(event);
            return;
        }

        SpongeEventHandler<S> handler = this.handlers[priority.ordinal()];
        if (handler != null) {
            if (handler.unregister(event)) {
                this.registrationCount--;
                if (isInactive()) {
                    unregister(); // Unregister post event handler
                }
            }
        }
    }

}
