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
package blue.lapis.pore.converter.vector;

import blue.lapis.pore.impl.PoreWorld;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.bukkit.Location;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.world.World;

public final class LocationConverter {

    private LocationConverter() {
    }

    public static Location apply(Location loc, org.spongepowered.api.world.Location<World> spongeLocation) {
        loc.setWorld(PoreWorld.of(spongeLocation.getExtent()));
        loc.setX(spongeLocation.getPosition().getX());
        loc.setY(spongeLocation.getPosition().getY());
        loc.setZ(spongeLocation.getPosition().getZ());
        return loc;
    }

    public static Location of(org.spongepowered.api.world.Location<World> location) {
        return new Location(PoreWorld.of(location.getExtent()), location.getPosition().getX(),
                location.getPosition().getY(), location.getPosition().getZ());
    }

    public static org.spongepowered.api.world.Location<World> of(Location location) {
        return new org.spongepowered.api.world.Location<>(((PoreWorld) location.getWorld()).getHandle(),
                VectorConverter.create3d(location));
    }

    public static Location fromVector3i(World world, Vector3i locationVector) {
        return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(),
                locationVector.getZ());
    }

    public static Location fromVector3d(World world, Vector3d locationVector) {
        return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(),
                locationVector.getZ());
    }

    public static Location fromVector3f(World world, Vector3f locationVector) {
        return new Location(PoreWorld.of(world), locationVector.getX(), locationVector.getY(),
                locationVector.getZ());
    }

    public static Vector3d toVector3d(Location location) {
        return new Vector3d(location.getX(), location.getY(), location.getZ());
    }

    public static Vector3d toRotationVector3d(Location location) {
        return new Vector3d(location.getPitch(), location.getYaw(), 0);
    }

    public static Location fromTransform(Transform<World> transform) {
        return new Location(PoreWorld.of(transform.getExtent()),
                transform.getPosition().getX(), transform.getPosition().getY(), transform.getPosition().getZ(),
                (float) transform.getYaw(), (float) transform.getPitch());
    }

    public static Transform<World> toTransform(Location location) {
        return new Transform<World>(((PoreWorld) location.getWorld()).getHandle(), toVector3d(location),
                toRotationVector3d(location));
    }

}
