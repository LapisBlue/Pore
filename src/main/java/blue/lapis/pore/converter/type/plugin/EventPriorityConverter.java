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
package blue.lapis.pore.converter.type.plugin;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.event.EventPriority;
import org.spongepowered.api.event.Order;

public final class EventPriorityConverter {

    private EventPriorityConverter() {
    }

    // TODO: Verify this
    private static final Converter<EventPriority, Order> CONVERTER = TypeConverter.<EventPriority, Order>builder()
            .add(EventPriority.LOWEST, Order.PRE)
            .add(EventPriority.LOW, Order.EARLY)
            .add(EventPriority.NORMAL, Order.DEFAULT)
            .add(EventPriority.HIGH, Order.LATE)
            .add(EventPriority.HIGHEST, Order.LAST)
            .add(EventPriority.MONITOR, Order.POST)
            .build();

    public static Order of(EventPriority eventPriority) {
        return CONVERTER.convert(eventPriority);
    }

    public static EventPriority of(Order order) {
        return CONVERTER.reverse().convert(order);
    }

}
