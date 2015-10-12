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

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.tools.Diagnostic.Kind.ERROR;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("blue.lapis.pore.event.RegisterEvent")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class EventVerifierProcessor extends AbstractProcessor {

    private static final Diagnostic.Kind SEVERITY = ERROR;

    private static final String BUKKIT_PACKAGE = "org.bukkit.event";
    private static final String PORE_PACKAGE = "blue.lapis.pore.impl.event";

    private static final String BUKKIT_PREFIX = BUKKIT_PACKAGE + '.';
    private static final String PORE_PREFIX = PORE_PACKAGE + '.';

    private static final String BUKKIT_EVENT_CLASS = BUKKIT_PREFIX + "Event";
    private static final String SPONGE_EVENT_CLASS = "org.spongepowered.api.event.Event";

    private TypeMirror bukkitEventType;
    private TypeMirror spongeEventType;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        this.bukkitEventType = checkNotNull(processingEnv.getElementUtils().getTypeElement(BUKKIT_EVENT_CLASS),
                "Bukkit event class").asType();
        this.spongeEventType = checkNotNull(processingEnv.getElementUtils().getTypeElement(SPONGE_EVENT_CLASS),
                "Sponge event class").asType();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (TypeElement anno : annotations) {
                for (Element e : roundEnv.getElementsAnnotatedWith(anno)) {
                    if (e.getKind() != ElementKind.CLASS) {
                        processingEnv.getMessager().printMessage(ERROR, "Found @" + anno.getSimpleName()
                                + " annotation on a " + e.getKind().name() + " element instead of a class element", e);
                        continue;
                    }

                    TypeElement type = (TypeElement) e;

                    verifySuperClass(type);
                    verifyPackage(type);
                    verifyName(type);
                    verifyEnclosedElements(type);
                }
            }
        }

        return false;
    }

    private void verifySuperClass(TypeElement type) {
        if (!processingEnv.getTypeUtils().isSubtype(type.asType(), bukkitEventType)) {
            processingEnv.getMessager().printMessage(ERROR, "Annotated event does not extent Event", type);
        }
    }

    private void verifyPackage(TypeElement type) {
        if (!type.getQualifiedName().toString().startsWith(PORE_PACKAGE)) {
            processingEnv.getMessager().printMessage(SEVERITY, "Annotated event is not in pore package " +
                    PORE_PACKAGE, type);
        }
    }

    private void verifyName(TypeElement type) {
        TypeElement bukkitEvent = (TypeElement) ((DeclaredType) type.getSuperclass()).asElement();

        String poreName = StringUtils.removeStart(type.getQualifiedName().toString(), PORE_PREFIX);
        String porePackage = StringUtils.substringBeforeLast(poreName, ".");
        poreName = StringUtils.substringAfterLast(poreName, ".");

        String bukkitName = StringUtils.removeStart(bukkitEvent.getQualifiedName().toString(), BUKKIT_PREFIX);
        String bukkitPackage = StringUtils.substringBeforeLast(bukkitName, ".");
        bukkitName = StringUtils.substringAfterLast(bukkitName, ".");

        String expectedName = "Pore" + bukkitName;

        if (!poreName.equals(expectedName)) {
            processingEnv.getMessager().printMessage(SEVERITY, poreName + " should be called " + expectedName, type);
        }
        if (!porePackage.equals(bukkitPackage)) {
            processingEnv.getMessager().printMessage(SEVERITY, poreName + " is in wrong package: should be in " +
                    PORE_PREFIX + bukkitPackage, type);
        }
    }

    private boolean isSpongeEvent(TypeMirror type) {
        return processingEnv.getTypeUtils().isSubtype(type, spongeEventType);
    }

    private void verifySpongeEvent(Element element, TypeMirror type) {
        if (!isSpongeEvent(type)) {
            processingEnv.getMessager().printMessage(SEVERITY, "handle " + type.getKind() + " is not Sponge event",
                    element);
        }
    }

    private void verifyEnclosedElements(TypeElement type) {
        boolean searchField = true;
        boolean searchMethod = true;
        boolean searchConstructor = true;

        for (Element element : type.getEnclosedElements()) {
            switch (element.getKind()) {
                case FIELD:
                    if (searchField) {
                        if (element.getSimpleName().contentEquals("handle")) {
                            searchField = false;
                            verifySpongeEvent(element, element.asType());
                        }
                    }
                    break;
                case METHOD:
                    if (searchMethod) {
                        if (element.getSimpleName().contentEquals("getHandle")) {
                            searchMethod = false;
                            verifySpongeEvent(element, ((ExecutableElement) element).getReturnType());
                            break;
                        }
                    }

                    if (element.getSimpleName().toString().startsWith("_INVALID_")) {
                        processingEnv.getMessager().printMessage(ERROR, "Annotated event shouldn't override _INVALID_"
                                + " method", element);
                    }
                    break;
                case CONSTRUCTOR:
                    if (searchConstructor) {
                        ExecutableElement constructor = (ExecutableElement) element;
                        List<? extends VariableElement> parameters = constructor.getParameters();
                        if (parameters.size() == 1) {
                            VariableElement handle = parameters.get(0);
                            if (isSpongeEvent(handle.asType())) {
                                searchConstructor = false;
                            }
                        }
                    }
                    break;
            }
        }

        if (searchField) {
            processingEnv.getMessager().printMessage(SEVERITY, "Annotated event is missing handle field", type);
        }
        if (searchMethod) {
            processingEnv.getMessager().printMessage(SEVERITY, "Annotated event is missing getHandle getter", type);
        }
        if (searchConstructor) {
            processingEnv.getMessager().printMessage(SEVERITY, "Annotated event is missing handle constructor", type);
        }
    }

}
