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

import blue.lapis.pore.converter.type.EventPriorityConverter;
import com.google.common.base.Throwables;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.objectweb.asm.Opcodes.*;

public final class PoreListenerGenerator {

    private static final String PACKAGE = PoreListenerGenerator.class.getPackage().getName() + '.';

    private static final String ANNOTATION = Type.getDescriptor(Subscribe.class);

    private static final String PRIORITY_CLASS = Type.getInternalName(EventPriority.class);
    private static final String PRIORITY_DESCRIPTOR = Type.getDescriptor(EventPriority.class);
    private static final String ORDER_DESCRIPTOR = Type.getDescriptor(Order.class);

    private static final String EVENT_WRAPPER_CLASS = Type.getInternalName(PoreEventWrapper.class);
    private static final String CALL_EVENT =
            "(L" + Type.getInternalName(Event.class) + ';' + PRIORITY_DESCRIPTOR + ")V";

    private static byte[] generate(String name, Class<?> pore, Class<?> sponge, EventPriority priority, Order order) {
        name = name.replace('.', '/');
        String poreName = Type.getInternalName(pore);
        String spongeSignature = "(L" + Type.getInternalName(sponge) + ";)V";

        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;
        AnnotationVisitor av;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, name, null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "on" + sponge.getSimpleName(), spongeSignature, null, null);
            {
                av = mv.visitAnnotation(ANNOTATION, true);
                av.visitEnum("order", ORDER_DESCRIPTOR, order.name());
                av.visitEnd();
            }
            mv.visitCode();
            mv.visitTypeInsn(NEW, poreName);
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, poreName, "<init>", spongeSignature, false);
            mv.visitFieldInsn(GETSTATIC, PRIORITY_CLASS, priority.name(), PRIORITY_DESCRIPTOR);
            mv.visitMethodInsn(INVOKESTATIC, EVENT_WRAPPER_CLASS, "call", CALL_EVENT, false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    private static Class<?> load(String name, Class<?> pore, Class<?> sponge, EventPriority priority, Order order) {
        byte[] bytes = generate(name, pore, sponge, priority, order);
        try {
            return (Class<?>) defineClass.invoke(PoreListenerGenerator.class.getClassLoader(),
                    name, bytes, 0, bytes.length);
        } catch (IllegalAccessException e) {
            throw Throwables.propagate(e);
        } catch (InvocationTargetException e) {
            throw Throwables.propagate(e);
        }
    }

    public static Object createListener(Class<? extends Event> pore,
                                        Class<? extends org.spongepowered.api.util.event.Event> sponge,
                                        EventPriority priority) {

        try {
            return load(PACKAGE + sponge.getSimpleName() + "$Handler$" + priority.name(), pore, sponge, priority,
                    EventPriorityConverter.of(priority)).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to create event handler for " + sponge + " with " + pore, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to create event handler for " + sponge + " with " + pore, e);
        }

    }

    private static final Method defineClass;

    static {
        try {
            defineClass = ClassLoader.class.getDeclaredMethod("defineClass",
                    String.class, byte[].class, int.class, int.class);
            defineClass.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    /* TODO: Sponge doesn't like classes loaded like this :/
    private static final LocalClassLoader loader = new LocalClassLoader(PoreListenerGenerator.class.getClassLoader());

    private static class LocalClassLoader extends ClassLoader {

        public LocalClassLoader(ClassLoader parent) {
            super(parent);
        }

        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }

    }
    */
}
