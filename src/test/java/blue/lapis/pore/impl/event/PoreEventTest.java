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

package blue.lapis.pore.impl.event;

import static blue.lapis.pore.PoreTests.PACKAGE;

import blue.lapis.pore.PoreTests;
import blue.lapis.pore.test.IgnoreResult;

import com.google.common.collect.Sets;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.event.Event;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Set;

public class PoreEventTest {

    static final String BUKKIT_PACKAGE = "org.bukkit.event";
    static final String PORE_PACKAGE = PACKAGE + "impl.event";

    @Rule
    public IgnoreResult ignoreResult = new IgnoreResult();

    @Test
    public void findUnimplementedEvents() throws IOException {
        Set<Class<?>> events = Sets.newLinkedHashSet();

        for (ClassPath.ClassInfo info : PoreTests.getClassPath().getTopLevelClassesRecursive(BUKKIT_PACKAGE)) {
            try {
                Class<?> event = info.load();
                if (Event.class.isAssignableFrom(event) && !Modifier.isAbstract(event.getModifiers())) {
                    events.add(event);
                }
            } catch (Throwable e) {
                PoreTests.getLogger().warn("Failed to load {}", info, e);
            }
        }

        for (ClassPath.ClassInfo info : PoreTests.getClassPath().getTopLevelClassesRecursive(PORE_PACKAGE)) {
            Class<?> type;
            try {
                type = info.load();
                if (!Event.class.isAssignableFrom(type)) {
                    continue;
                }
            } catch (Throwable e) {
                PoreTests.getLogger().warn("Failed to load {}", info, e);
                continue;
            }

            events.remove(type.getSuperclass());
        }

        if (!events.isEmpty()) {
            for (Class<?> event : events) {
                String bukkitPackage = StringUtils.removeStart(event.getPackage().getName(), BUKKIT_PACKAGE + '.');
                PoreTests.getLogger().warn("{}: Pore{} is missing", bukkitPackage, event.getSimpleName());
            }
        }
    }

}
