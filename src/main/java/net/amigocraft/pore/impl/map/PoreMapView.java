/*
 * Pore
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.impl.map;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.List;

public class PoreMapView implements MapView {

    // TODO: Bridge

    @Override
    public short getId() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isVirtual() {
        throw new NotImplementedException();
    }

    @Override
    public Scale getScale() {
        throw new NotImplementedException();
    }

    @Override
    public void setScale(Scale scale) {
        throw new NotImplementedException();
    }

    @Override
    public int getCenterX() {
        throw new NotImplementedException();
    }

    @Override
    public int getCenterZ() {
        throw new NotImplementedException();
    }

    @Override
    public void setCenterX(int x) {
        throw new NotImplementedException();
    }

    @Override
    public void setCenterZ(int z) {
        throw new NotImplementedException();
    }

    @Override
    public World getWorld() {
        throw new NotImplementedException();
    }

    @Override
    public void setWorld(World world) {
        throw new NotImplementedException();
    }

    @Override
    public List<MapRenderer> getRenderers() {
        throw new NotImplementedException();
    }

    @Override
    public void addRenderer(MapRenderer renderer) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeRenderer(MapRenderer renderer) {
        throw new NotImplementedException();
    }

}
