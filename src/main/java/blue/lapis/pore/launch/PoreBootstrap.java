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

package blue.lapis.pore.launch;

import blue.lapis.pore.util.classloader.PoreClassLoader;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameAboutToStartServerEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.net.MalformedURLException;
import java.net.URL;

@Plugin(id = "pore", name = "Pore")
public class PoreBootstrap implements PoreEventManager {

    private static final String IMPLEMENTATION_CLASS = "blue.lapis.pore.Pore";

    private final PoreEventManager pore;

    @Inject
    public PoreBootstrap(Injector injector) {
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        String path = location.getPath();
        if (location.getProtocol().equals("jar")) {
            int pos = path.lastIndexOf('!');
            if (pos >= 0) {
                path = path.substring(0, pos + 2);
            }
        } else {
            path = StringUtils.removeEnd(path, getClass().getName().replace('.', '/') + ".class");
        }

        try {
            ClassLoader loader = new PoreClassLoader(getClass().getClassLoader(),
                    new URL(location.getProtocol(), location.getHost(), location.getPort(), path));
            Class<?> poreClass = Class.forName(IMPLEMENTATION_CLASS, true, loader);
            this.pore = (PoreEventManager) injector.getInstance(poreClass);
        } catch (ClassNotFoundException | MalformedURLException e) {
            throw new RuntimeException("Failed to load Pore implementation", e);
        }
    }

    @Listener
    @Override
    public void onPreInit(GamePreInitializationEvent event) throws Exception {
        pore.onPreInit(event);
    }

    @Listener
    @Override
    public void onAboutToStart(GameAboutToStartServerEvent event) throws Exception {
        pore.onAboutToStart(event);
    }

    @Listener
    @Override
    public void onStarting(GameStartingServerEvent event) throws Exception {
        pore.onStarting(event);
    }

    @Listener
    @Override
    public void onShutdown(GameStoppingServerEvent event) throws Exception {
        pore.onShutdown(event);
    }

}
