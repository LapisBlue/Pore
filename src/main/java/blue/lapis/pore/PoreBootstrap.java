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
package blue.lapis.pore;

import blue.lapis.pore.util.PoreClassLoader;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerAboutToStartEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Bootstrap for Pore
 */
@Plugin(id = "pore", name = "Pore")
public class PoreBootstrap {

    private static PoreBootstrap instance;

    private Class<?> poreClass;
    private Object poreInstance;
    private URLClassLoader poreClassLoader;

    @Inject
    private Game game;

    @Inject
    private Logger logger;

    public static PoreBootstrap getInstance() {
        return Preconditions.checkNotNull(instance);
    }

    @Subscribe
    public void onInitialization(PreInitializationEvent event) {
        instance = this;
        URL[] urls;
        try {
            urls = new URL[]{
                    new URL(getClass().getProtectionDomain().getCodeSource().getLocation()
                            .toString().split("!")[0] + "!/")
            };
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        poreClassLoader = new PoreClassLoader(urls, this.getClass().getClassLoader());
        try {
            poreClass = Class.forName("blue.lapis.pore.Pore", true, poreClassLoader);
            poreInstance = poreClass.getConstructor(Game.class, Logger.class).newInstance(game, logger);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void delegateEvent(String name) {
        try {
            poreClass.getMethod(name).invoke(poreInstance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onAboutToStart(ServerAboutToStartEvent event) {
        delegateEvent("onAboutToStart");
    }

    @Subscribe
    public void onStarting(ServerStartingEvent event) {
        delegateEvent("onStarting");
    }

    @Subscribe
    public void onShutdown(ServerStoppingEvent event) {
        delegateEvent("onShutdown");
    }

}
