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

import static blue.lapis.pore.impl.event.PoreEventTest.BUKKIT_PACKAGE;
import static blue.lapis.pore.impl.event.PoreEventTest.PORE_PACKAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import blue.lapis.pore.PoreTests;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.event.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

@RunWith(Parameterized.class)
public class PoreEventImplTest {

    private static final String BUKKIT_PREFIX = BUKKIT_PACKAGE + '.';
    private static final String PORE_PREFIX = PORE_PACKAGE + '.';

    @Parameterized.Parameters(name = "{0}")
    public static Set<Object[]> getEvents() throws Exception {
        ImmutableSet.Builder<Object[]> events = ImmutableSet.builder();
        for (ClassPath.ClassInfo event : PoreTests.getClassPath().getTopLevelClassesRecursive(PORE_PACKAGE)) {
            String name = event.getName();
            if (!name.endsWith("Test")) {
                Class<?> eventImpl = event.load();
                events.add(new Object[]{StringUtils.removeStart(event.getName(), PORE_PREFIX), eventImpl});

                for (Class<?> innerClass : eventImpl.getClasses()) {
                    if (Event.class.isAssignableFrom(innerClass)) {
                        events.add(new Object[]{StringUtils.removeStart(innerClass.getName(), PORE_PREFIX),
                                innerClass});
                    }
                }
            }
        }
        return events.build();
    }

    @Parameterized.Parameter
    public String event;

    @Parameterized.Parameter(1)
    public Class<?> eventImpl;

    @Test
    public void checkEvent() {
        assumeTrue(Event.class.isAssignableFrom(eventImpl));
    }

    @Test
    public void checkFinalOrAbstract() {
        assertTrue(eventImpl.getSimpleName() + ": should be final or abstract",
                Modifier.isFinal(eventImpl.getModifiers()) || Modifier.isAbstract(eventImpl.getModifiers()));
    }

    @Test
    public void checkName() {
        if (event.contains("$")) {
            return; // Skip inner classes
        }

        Class<?> bukkitEvent = eventImpl.getSuperclass();

        String poreName = event;
        String porePackage = StringUtils.substringBeforeLast(poreName, ".");
        poreName = StringUtils.substringAfterLast(poreName, ".");

        String bukkitName = StringUtils.removeStart(bukkitEvent.getName(), BUKKIT_PREFIX);
        String bukkitPackage = StringUtils.substringBeforeLast(bukkitName, ".");
        bukkitName = StringUtils.substringAfterLast(bukkitName, ".");

        String expectedName = "Pore" + bukkitName;

        assertEquals(poreName + " should be called " + expectedName, poreName, expectedName);
        assertEquals(poreName + " is in wrong package: should be in " + PORE_PREFIX + bukkitPackage,
                porePackage, bukkitPackage);
    }

    private static void checkSpongeEvent(Class<?> eventImpl, Class<?> type) {
        assertTrue(eventImpl.getSimpleName() + ": " + type.getSimpleName() + " is not a sponge event",
                org.spongepowered.api.event.Event.class.isAssignableFrom(type));
    }

    @Test
    public void checkImplements() {
        assertTrue(eventImpl.getSimpleName() + ": should implement PoreEvent",
                PoreEvent.class.isAssignableFrom(eventImpl));
    }

    @Test
    public void checkHandleField() {
        Class<?> superClass = eventImpl;
        do {
            try {
                Field field = superClass.getDeclaredField("handle");
                checkSpongeEvent(eventImpl, field.getType());
                return;
            } catch (NoSuchFieldException ignored) {
            }

            superClass = superClass.getSuperclass();
        } while (superClass != null);

        fail(eventImpl.getSimpleName() + ": missing handle field");
    }

    @Test
    public void checkConstructor() throws Throwable {
        if (eventImpl.getAnnotation(RegisterEvent.class) == null) {
            return;
        }

        for (Constructor<?> constructor : eventImpl.getConstructors()) {
            Class<?>[] parameters = constructor.getParameterTypes();
            if (parameters.length == 1 || parameters.length == 2) {
                Class<?> handle = parameters[0];
                if (org.spongepowered.api.event.Event.class.isAssignableFrom(handle)) {
                    if (parameters.length == 2) {
                        if (constructor.getParameters()[1].getAnnotation(Source.class) == null) {
                            continue;
                        }
                    }

                    // Check for null check
                    try {
                        constructor.newInstance(new Object[parameters.length]);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            if (cause instanceof NullPointerException
                                    && Objects.equal(cause.getMessage(), "handle")) {
                                return;
                            }

                            throw cause;
                        }

                        throw e;
                    }

                    fail(eventImpl.getSimpleName() + ": missing null-check for handle");
                }
            }
        }

        fail(eventImpl.getSimpleName() + ": missing handle/source constructor");
    }

    @Test
    public void checkImplementedMethods() {
        if (Modifier.isAbstract(eventImpl.getModifiers())) {
            return;
        }

        Class<?> bukkitEvent = eventImpl.getSuperclass();
        for (Method method : bukkitEvent.getMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers) || method.isDefault()
                    || method.getDeclaringClass() == Event.class || method.getDeclaringClass() == Object.class
                    || method.getName().equals("getHandlers") || method.getName().startsWith("_INVALID_")) {
                continue;
            }

            try {
                Method m = eventImpl.getMethod(method.getName(), method.getParameterTypes());
                assertTrue(eventImpl.getSimpleName() + ": should override method" + method,
                        m.getDeclaringClass().getName().startsWith(PORE_PREFIX));
            } catch (NoSuchMethodException e) {
                fail(eventImpl.getSimpleName() + ": should override method " + method);
            }
        }
    }

    @Test
    public void checkToString() {
        try {
            assertTrue(eventImpl.getSimpleName() + ": should override toString()",
                    eventImpl.getMethod("toString").getDeclaringClass().getName().startsWith(PORE_PREFIX));
        } catch (NoSuchMethodException e) {
            fail(eventImpl.getSimpleName() + ": should override method toString()");
        }
    }

    @Test
    public void checkInvalidMethods() {
        for (Method method : eventImpl.getDeclaredMethods()) {
            if (method.getName().startsWith("_INVALID_")) {
                fail(eventImpl.getSimpleName() + ": shouldn't override _INVALID_ method " + method);
            }
        }
    }

}
