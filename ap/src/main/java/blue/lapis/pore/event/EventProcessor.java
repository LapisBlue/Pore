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

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes("blue.lapis.pore.event.Register")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class EventProcessor extends AbstractProcessor {

    private Set<String> events = new HashSet<String>();

    public EventProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            Writer w = null;
            try {
                FileObject file = processingEnv.getFiler()
                        .createResource(StandardLocation.CLASS_OUTPUT, "", "events.txt");
                w = file.openWriter();
                String[] eventsArray = new String[events.size()];
                events.toArray(eventsArray);
                for (int i = 0; i < eventsArray.length; i++) {
                    w.append(eventsArray[i]);
                    if (i < eventsArray.length - 1) {
                        w.append('\n');
                    }
                }
                w.flush();
            } catch (IOException ex) {
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
                if (!(e instanceof TypeElement)) {
                    throw new IllegalStateException("@Register element has unexpected type "
                            + e.getClass().getSimpleName());
                }
                if (e.getKind() == ElementKind.CLASS) {
                    events.add(((TypeElement) e).getQualifiedName().toString());
                } else {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Found @Register annotation "
                            + "on a non-class element");
                }
            }
        }
        return true;
    }
}
