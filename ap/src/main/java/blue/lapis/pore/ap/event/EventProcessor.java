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
package blue.lapis.pore.ap.event;

import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.NOTE;

import com.google.common.collect.Sets;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes("blue.lapis.pore.event.RegisterEvent")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class EventProcessor extends AbstractProcessor {

    private final Set<String> events = Sets.newHashSet();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            Writer w = null;
            try {
                FileObject file = processingEnv.getFiler()
                        .createResource(StandardLocation.CLASS_OUTPUT, "blue.lapis.pore.event", "events.txt");
                processingEnv.getMessager().printMessage(NOTE,
                        "Writing " + events.size() + " events to " + file.getName());

                w = file.openWriter();
                for (String event : events) {
                    w.write(event);
                    w.write('\n');
                }
            } catch (IOException ex) {
                processingEnv.getMessager().printMessage(ERROR, "Failed to write events to events.txt");
                ex.printStackTrace();
            } finally {
                try {
                    if (w != null) {
                        w.close();
                    }
                } catch (IOException ignored) {
                    // meh
                }
            }

            return false;
        }

        for (TypeElement anno : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(anno)) {
                if (e.getKind() == ElementKind.CLASS) {
                    events.add(((TypeElement) e).getQualifiedName().toString());
                }
            }
        }

        return true;
    }
}
