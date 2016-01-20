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
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;

import blue.lapis.pore.Pore;
import blue.lapis.pore.util.classloader.LocalClassLoaders;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public abstract class SimpleClassConstructor<T, P> implements SimpleConstructor<T, P> {

    private final Class<T> type;

    protected SimpleClassConstructor(Class<T> type) {
        this.type = checkNotNull(type, "type");
    }

    @Override
    public final Class<T> getType() {
        return this.type;
    }

    public static class Provider implements SimpleConstructor.Provider {

        private static final String BASE_CLASS = Type.getInternalName(SimpleClassConstructor.class);

        @Override
        public <T, P> SimpleConstructor<T, P> create(Class<T> type, Class<P> parameter) throws Exception {
            return load(type, parameter).getConstructor(Class.class).newInstance(type);
        }

        private static <T, P> Class<? extends SimpleClassConstructor<T, P>> load(Class<T> type, Class<P> parameter)
                throws NoSuchMethodException {
            try {
                type.getDeclaredConstructor(parameter);
                String name = type.getName() + "Constructor";
                return LocalClassLoaders.of(type).defineClass(name, generate(name, type, parameter));
            } catch (NoSuchMethodException ex) {
                // for future reference (and to combat my future stupidity)
                Pore.getLogger().error("Cannot initialize wrapper class " + type.getName()
                        + " (maybe registered type and ctor/of() parameters mismatch?)");
                throw ex;
            }
        }

        private static byte[] generate(String name, Class<?> type, Class<?> parameter) {
            name = name.replace('.', '/');

            String typeName = Type.getInternalName(type);
            String typeDesc = Type.getDescriptor(type);
            String parameterName = Type.getInternalName(parameter);
            String parameterDesc = Type.getDescriptor(parameter);

            String constructSignature = '(' + parameterDesc + ')' + typeDesc;

            ClassWriter cw = new ClassWriter(0);
            MethodVisitor mv;

            cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, name, null, BASE_CLASS, null);

            {
                mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/Class;)V", null, null);
                mv.visitCode();
                mv.visitVarInsn(ALOAD, 0);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitMethodInsn(INVOKESPECIAL, BASE_CLASS, "<init>", "(Ljava/lang/Class;)V", false);
                mv.visitInsn(RETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            {
                mv = cw.visitMethod(ACC_PUBLIC, "construct", constructSignature, null, null);
                mv.visitCode();
                mv.visitTypeInsn(NEW, typeName);
                mv.visitInsn(DUP);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitMethodInsn(INVOKESPECIAL, typeName, "<init>", '(' + parameterDesc + ")V", false);
                mv.visitInsn(ARETURN);
                mv.visitMaxs(3, 2);
                mv.visitEnd();
            }
            {
                mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "construct",
                        "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                mv.visitCode();
                mv.visitVarInsn(ALOAD, 0);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitTypeInsn(CHECKCAST, parameterName);
                mv.visitMethodInsn(INVOKEVIRTUAL, name, "construct", constructSignature, false);
                mv.visitInsn(ARETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            cw.visitEnd();

            return cw.toByteArray();
        }

    }

}
