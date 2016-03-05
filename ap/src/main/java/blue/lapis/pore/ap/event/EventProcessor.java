/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

package blue.lapis.pore.ap.event;

import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.NOTE;
import static javax.tools.Diagnostic.Kind.WARNING;

import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes("blue.lapis.pore.event.RegisterEvent")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class EventProcessor extends AbstractProcessor {

    private final Set<String> events = Sets.newHashSet();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        try {
            FileObject file = processingEnv.getFiler()
                    .getResource(StandardLocation.CLASS_OUTPUT, "blue.lapis.pore.event", "events.txt");
            try (Reader reader = file.openReader(false)) {
                events.addAll(CharStreams.readLines(reader));
            }

            processingEnv.getMessager().printMessage(NOTE, "Found " + events.size() + " events in " + file.getName());
        } catch (IOException ignored) {
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            try {
                FileObject file = processingEnv.getFiler()
                        .createResource(StandardLocation.CLASS_OUTPUT, "blue.lapis.pore.event", "events.txt");

                Iterator<String> itr = events.iterator();
                while (itr.hasNext()) {
                    String event = itr.next();

                    int pos = event.lastIndexOf(':');
                    if (pos >= 0) {
                        if (!validateMethod(event.substring(0, pos), event.substring(pos + 1), annotations)) {
                            itr.remove();
                        }
                    } else {
                        if (!validateClass(event, annotations)) {
                            itr.remove();
                        }
                    }
                }

                processingEnv.getMessager().printMessage(NOTE,
                        "Writing " + events.size() + " events to " + file.getName());

                try (Writer w = file.openWriter()) {
                    for (String event : events) {
                        w.write(event);
                        w.write('\n');
                    }
                }
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(ERROR, "Failed to write events to events.txt");
                e.printStackTrace();
            }

            return false;
        }

        for (TypeElement anno : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(anno)) {
                this.events.add(getQualifiedName(element));
            }
        }

        return true;
    }

    private boolean validateClass(String name, Set<? extends TypeElement> annotations) {
        name = name.replace('$', '.'); // Mirror API sucks, replace inner class signs
        TypeElement element = processingEnv.getElementUtils().getTypeElement(name);
        if (element != null) {
            return element.getAnnotationMirrors().containsAll(annotations);
        } else {
            processingEnv.getMessager().printMessage(WARNING, "Skipping unknown class: " + name);
            return false;
        }
    }

    private boolean validateMethod(String owner, String name, Set<? extends TypeElement> annotations) {
        TypeElement element = processingEnv.getElementUtils().getTypeElement(owner);
        if (element != null) {
            for (Element enclosed : element.getEnclosedElements()) {
                if (enclosed.getKind() == ElementKind.METHOD && enclosed.getSimpleName().toString().equals(name)
                        && enclosed.getAnnotationMirrors().containsAll(annotations)) {
                    return true;
                }
            }
        } else {
            processingEnv.getMessager().printMessage(WARNING, "Skipping unknown method owner: " + owner);
        }

        return false;
    }

    private static String getQualifiedName(Element element) {
        switch (element.getKind()) {
            case CLASS:
                // Mirror API sucks, return proper qualified name for inner classes
                if (element.getEnclosingElement().getKind() == ElementKind.CLASS) {
                    return getQualifiedName(element.getEnclosingElement()) + '$' + element.getSimpleName();
                } else {
                    return ((QualifiedNameable) element).getQualifiedName().toString();
                }
            case METHOD:
                return getQualifiedName(element.getEnclosingElement()) + ':' + element.getSimpleName().toString();
            default:
                throw new UnsupportedOperationException(element.getClass().toString());
        }
    }
}
