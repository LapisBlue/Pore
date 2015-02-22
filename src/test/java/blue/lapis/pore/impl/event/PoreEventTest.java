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

import static org.junit.Assert.fail;

import blue.lapis.pore.Pore;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.reflect.ClassPath;
import org.bukkit.event.Event;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

public class PoreEventTest {

    private static final String BUKKIT_PACKAGE = "org.bukkit.event";
    private static final String PORE_PACKAGE = "blue.lapis.pore.impl.event";

    private static ImmutableCollection<Class<?>> bukkitEvents;
    private static ImmutableCollection<Class<?>> poreEvents;

    @BeforeClass
    public static void findEvents() throws Exception {
        ClassPath classPath = ClassPath.from(ClassLoader.getSystemClassLoader());

        ImmutableSet.Builder<Class<?>> builder = ImmutableSet.builder();

        for (ClassPath.ClassInfo info : classPath.getTopLevelClassesRecursive(BUKKIT_PACKAGE)) {
            Class<?> event = info.load();
            if (Event.class.isAssignableFrom(event) && !Modifier.isAbstract(event.getModifiers())) {
                builder.add(event);
            }
        }

        bukkitEvents = builder.build();
        builder = ImmutableSet.builder();

        for (ClassPath.ClassInfo info : classPath.getTopLevelClassesRecursive(PORE_PACKAGE)) {
            Class<?> type = info.load();
            if (Event.class.isAssignableFrom(type)) {
                builder.add(type);
            }
        }

        poreEvents = builder.build();
    }

    @Test
    public void findUnimplementedEvents() {
        Set<Class<?>> events = Sets.newHashSet(bukkitEvents);

        for (Class<?> eventImpl : poreEvents) {
            events.remove(eventImpl.getSuperclass());
        }

        if (!events.isEmpty()) {
            Pore.getTestLogger().warn(events.size() + " Bukkit events haven't been implemented yet");
            for (Class<?> event : events) {
                Pore.getTestLogger().warn("Pore" + event.getSimpleName() + " for " + event.getSimpleName() + " is missing");
            }
        }
    }

    private static void checkSpongeEvent(Class<?> eventImpl, Class<?> type) {
        if (!org.spongepowered.api.util.event.Event.class.isAssignableFrom(type)) {
            fail(eventImpl.getSimpleName() + ": " + type.getSimpleName() + " is not a sponge event");
        }
    }

    @Test
    public void checkHandleGetter() {
        for (Class<?> eventImpl : poreEvents) {
            try {
                Method method = eventImpl.getMethod("getHandle");
                checkSpongeEvent(eventImpl, method.getReturnType());
            } catch (NoSuchMethodException ignored) {
                fail(eventImpl.getSimpleName() + ": missing getHandle() method (handle getter)");
            }
        }
    }

    @Test
    public void checkHandleField() {
        for (Class<?> eventImpl : poreEvents) {
            try {
                Field field = eventImpl.getDeclaredField("handle");
                checkSpongeEvent(eventImpl, field.getType());
            } catch (NoSuchFieldException e) {
                fail(eventImpl.getSimpleName() + ": missing handle field");
            }
        }
    }

    @Test
    public void checkConstructor() throws ReflectiveOperationException {
        events: for (Class<?> eventImpl : poreEvents) {
            for (Constructor<?> constructor : eventImpl.getConstructors()) {
                Class<?>[] parameters = constructor.getParameterTypes();
                if (parameters.length == 1) {
                    Class<?> handle = parameters[0];
                    if (org.spongepowered.api.util.event.Event.class.isAssignableFrom(handle)) {
                        // Check for null check
                        try {
                            constructor.newInstance(new Object[]{null});
                        } catch (InvocationTargetException e) {
                            Throwable cause = e.getCause();
                            if (cause != null && cause instanceof NullPointerException) {
                                continue events;
                            }
                            throw e;
                        }

                        fail(eventImpl.getSimpleName() + ": missing null-check for handle");
                    }
                }
            }

            fail(eventImpl.getSimpleName() + ": missing handle constructor");
        }
    }

}
