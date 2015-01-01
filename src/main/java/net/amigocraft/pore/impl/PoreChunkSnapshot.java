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
package net.amigocraft.pore.impl;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreChunkSnapshot implements ChunkSnapshot {

    @Override
    public int getX() {
        throw new NotImplementedException();
    }

    @Override
    public int getZ() {
        throw new NotImplementedException();
    }

    @Override
    public String getWorldName() {
        throw new NotImplementedException();
    }

    @Override
    public int getBlockTypeId(int x, int y, int z) {
        throw new NotImplementedException();
    }

    @Override
    public int getBlockData(int x, int y, int z) {
        throw new NotImplementedException();
    }

    @Override
    public int getBlockSkyLight(int x, int y, int z) {
        throw new NotImplementedException();
    }

    @Override
    public int getBlockEmittedLight(int x, int y, int z) {
        throw new NotImplementedException();
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        throw new NotImplementedException();
    }

    @Override
    public Biome getBiome(int x, int z) {
        throw new NotImplementedException();
    }

    @Override
    public double getRawBiomeTemperature(int x, int z) {
        throw new NotImplementedException();
    }

    @Override
    public double getRawBiomeRainfall(int x, int z) {
        throw new NotImplementedException();
    }

    @Override
    public long getCaptureFullTime() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSectionEmpty(int sy) {
        throw new NotImplementedException();
    }

    //TODO: Placeholder class, may just call PoreChunk's methods
}
