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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import blue.lapis.pore.PoreTests;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang.StringUtils;
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
    public void checkNames() {
        for (Class<?> eventImpl : poreEvents) {
            Class<?> bukkitEvent = eventImpl.getSuperclass();

            String poreName = StringUtils.removeStart(eventImpl.getName(), PORE_PACKAGE + '.');
            String porePackage = StringUtils.substringBeforeLast(poreName, ".");
            poreName = StringUtils.substringAfterLast(poreName, ".");

            String bukkitName = StringUtils.removeStart(bukkitEvent.getName(), BUKKIT_PACKAGE + '.');
            String bukkitPackage = StringUtils.substringBeforeLast(bukkitName, ".");
            bukkitName = StringUtils.substringAfterLast(bukkitName, ".");

            String expectedName = "Pore" + bukkitName;

            assertTrue(poreName + " should be called " + expectedName, poreName.equals(expectedName));
            assertTrue(poreName + " is in wrong package: should be in " + PORE_PACKAGE + '.' + bukkitPackage,
                    porePackage.equals(bukkitPackage));
        }
    }

    @Test
    public void findUnimplementedEvents() {
        Set<Class<?>> events = Sets.newHashSet(bukkitEvents);

        for (Class<?> eventImpl : poreEvents) {
            events.remove(eventImpl.getSuperclass());
        }

        if (!events.isEmpty()) {
            for (Class<?> event : events) {
                PoreTests.getLogger().warn(
                        "Pore" + event.getSimpleName() + " for " + event.getSimpleName() + " is missing");
            }
        }
    }

    private static void checkSpongeEvent(Class<?> eventImpl, Class<?> type) {
        assertTrue(eventImpl.getSimpleName() + ": " + type.getSimpleName() + " is not a sponge event",
                org.spongepowered.api.util.event.Event.class.isAssignableFrom(type));
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
    public void checkConstructor() throws Throwable {
        events:
        for (Class<?> eventImpl : poreEvents) {
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
                            if (cause != null) {
                                if (cause instanceof NullPointerException
                                        && Objects.equal(cause.getMessage(), "handle")) {
                                    continue events;
                                }

                                throw cause;
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

    @Test
    public void checkImplementedMethods() {
        for (Class<?> eventImpl : poreEvents) {
            Class<?> bukkitEvent = eventImpl.getSuperclass();
            for (Method method : bukkitEvent.getMethods()) {
                int modifiers = method.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || isDefault(method)
                        || method.getDeclaringClass() == Event.class || method.getDeclaringClass() == Object.class
                        || method.getName().equals("getHandlers") || method.getName().startsWith("_INVALID_")) {
                    continue;
                }

                try {
                    eventImpl.getDeclaredMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e) {
                    fail(eventImpl.getSimpleName() + ": should override method " + method);
                }
            }
        }
    }

    // Taken from JDK8 for compatibility with older Java versions
    private static boolean isDefault(Method method) {
        // Default methods are public non-abstract instance methods declared in an interface.
        return ((method.getModifiers() & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC)
                && method.getDeclaringClass().isInterface();
    }

    @Test
    public void checkInvalidMethods() {
        for (Class<?> eventImpl : poreEvents) {
            for (Method method : eventImpl.getDeclaredMethods()) {
                if (method.getName().startsWith("_INVALID_")) {
                    fail(eventImpl.getSimpleName() + ": shouldn't override _INVALID_ method " + method);
                }
            }
        }
    }

}
