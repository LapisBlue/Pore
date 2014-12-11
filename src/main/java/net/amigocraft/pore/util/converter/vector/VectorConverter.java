/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
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
package net.amigocraft.pore.util.converter.vector;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class VectorConverter {

    public static Vector3d create3i(Location location) {
        return new Vector3d((int)location.getX(), (int)location.getY(), (int)location.getZ());
    }

    public static Vector3d create3d(Location location) {
        return new Vector3d(location.getX(), location.getY(), location.getZ());
    }

    public static Vector3f create3f(Vector vector) {
        return new Vector3f(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Vector createBukkitVector(Vector3i vector){
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Vector createBukkitVector(Vector3d vector){
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Vector createBukkitVector(Vector3f vector){
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }

}
