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

package blue.lapis.pore.util.constructor;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_8;

import blue.lapis.pore.Pore;
import blue.lapis.pore.util.classloader.LocalClassLoaders;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public abstract class BytecodeClassConstructor<T> {

    private final Class<T> type;

    protected BytecodeClassConstructor(Class<T> type) {
        this.type = checkNotNull(type, "type");
    }

    public final Class<T> getType() {
        return this.type;
    }

    public static final class Provider implements ClassConstructor.Provider {

        private static final String BASE_CLASS = Type.getInternalName(BytecodeClassConstructor.class);

        private static final String[] SIMPLE_INTERFACE = {Type.getInternalName(SimpleClassConstructor.class)};
        private static final String SIMPLE_DESCRIPTOR = "(Ljava/lang/Object;)Ljava/lang/Object;";

        private static final String[] BI_INTERFACE = {Type.getInternalName(BiClassConstructor.class)};
        private static final String BI_DESCRIPTOR = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";

        @Override
        @SuppressWarnings("unchecked")
        public <T, P> SimpleClassConstructor<T, P> create(Class<T> type, Class<P> parameter) throws Exception {
            return ((Class<? extends SimpleClassConstructor<T, P>>) load(SIMPLE_INTERFACE, SIMPLE_DESCRIPTOR,
                    type, parameter)).newInstance();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T, A, B> BiClassConstructor<T, A, B> create(Class<T> type, Class<A> parameterA, Class<B> parameterB)
                throws Exception {
            return ((Class<? extends BiClassConstructor<T, A, B>>) load(BI_INTERFACE, BI_DESCRIPTOR,
                    type, parameterA, parameterB)).newInstance();
        }

        private static <T> Class<? extends ClassConstructor<T>> load(String[] interfaces, String applyDescriptor,
                Class<T> type, Class<?>... parameters) throws NoSuchMethodException {
            try {
                type.getDeclaredConstructor(parameters);
                String name = type.getName() + "Constructor";
                return LocalClassLoaders.of(type).defineClass(name, generate(interfaces, applyDescriptor, name,
                        type, parameters));
            } catch (NoSuchMethodException e) {
                // For future reference (and to combat my future stupidity)
                Pore.getLogger().error("Cannot initialize constructor class " + type.getName()
                        + " (maybe registered type and ctor/of() parameters mismatch?)");
                throw e;
            }
        }

        private static byte[] generate(String[] interfaces, String applyDescriptor, String name,
                Class<?> typeClass, Class<?>... parameters) {
            name = name.replace('.', '/');

            final Type type = Type.getType(typeClass);

            final String typeName = type.getInternalName();

            final int len = parameters.length;
            final Type[] parameterTypes = new Type[len];
            int i;
            for (i = 0; i < len; i++) {
                parameterTypes[i] = Type.getType(parameters[i]);
            }

            ClassWriter cw = new ClassWriter(0);
            cw.visit(V1_8, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, name, null, BASE_CLASS, interfaces);

            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitLdcInsn(type);
            mv.visitMethodInsn(INVOKESPECIAL, BASE_CLASS, "<init>", "(Ljava/lang/Class;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();

            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "apply", applyDescriptor, null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, typeName);
            mv.visitInsn(DUP);
            for (i = 0; i < len; i++) {
                mv.visitVarInsn(ALOAD, i + 1);
                mv.visitTypeInsn(CHECKCAST, parameterTypes[i].getInternalName());
            }
            mv.visitMethodInsn(INVOKESPECIAL, typeName, "<init>",
                    Type.getMethodDescriptor(Type.VOID_TYPE, parameterTypes), false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(2 + len, 1 + len);
            mv.visitEnd();

            cw.visitEnd();
            return cw.toByteArray();
        }

    }

}
