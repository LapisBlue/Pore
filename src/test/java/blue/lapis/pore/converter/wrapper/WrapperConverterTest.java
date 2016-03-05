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

package blue.lapis.pore.converter.wrapper;

import static blue.lapis.pore.PoreTests.PACKAGE;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import blue.lapis.pore.PoreTests;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(Parameterized.class)
public class WrapperConverterTest {

    private static final String IMPL_PREFIX = PACKAGE + "impl.";

    @BeforeClass
    public static void initPlugin() {
        PoreTests.mockPlugin();
    }

    @Parameterized.Parameters(name = "{0}")
    public static Set<Object[]> getObjects() throws Exception {
        ImmutableSet.Builder<Object[]> objects = ImmutableSet.builder();
        ListMultimap<Class<?>, Class<?>> registry = createRegistry();
        for (Class<?> type : registry.keySet()) {
            objects.add(new Object[]{
                    StringUtils.removeStart(type.getName(), IMPL_PREFIX),
                    type,
                    registry.get(type)
            });
        }
        return objects.build();
    }

    @SuppressWarnings("rawtypes")
    private static ListMultimap<Class<?>, Class<?>> createRegistry() {
        ImmutableListMultimap.Builder<Class<?>, Class<?>> builder = ImmutableListMultimap.builder();

        for (Map.Entry<Class<?>, CachedWrapperConverter.Converter<?, ? extends PoreWrapper>> entry :
                WrapperConverter.converter.registry.entrySet()) {

            scan(builder, entry.getKey(), null, entry.getValue());
        }

        return builder.build();
    }

    private static void scan(ImmutableMultimap.Builder<Class<?>, Class<?>> builder, Class<?> sponge,
            Set<Class<?>> parents, CachedWrapperConverter.Converter<?, ?> converter) {
        Class<?> pore = converter.constructor.getType();
        builder.put(pore, sponge);

        ImmutableSet.Builder<Class<?>> parentsBuilder = ImmutableSet.<Class<?>>builder().add(sponge);

        if (parents != null) {
            builder.putAll(pore, parents);
            parentsBuilder.addAll(parents);
        }

        parents = parentsBuilder.build();

        for (Map.Entry<? extends Class<?>, ? extends CachedWrapperConverter.Converter<?, ?>> entry :
                converter.registry.entrySet()) {

            scan(builder, entry.getKey(), parents, entry.getValue());
        }
    }

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public Class<?> pore;
    @Parameterized.Parameter(2)
    public List<Class<?>> interfaces;

    private Object create() {
        Class<?> base = interfaces.get(0);

        if (!base.isInterface() && Modifier.isFinal(base.getModifiers())) {
            if (base == Location.class) {
                return new Location<>(mock(Extent.class), 0, 0, 0);
            }
        }

        Object mock;
        if (interfaces.size() == 1) {
            mock = mock(base);
        } else {
            mock = mock(base, withSettings().extraInterfaces(
                    interfaces.subList(1, interfaces.size()).toArray(new Class<?>[interfaces.size() - 1])));
        }
        // o.b.BlockState's subclasses break this test because of incongruencies between SpongeAPI and Bukkit
        // this code basically assures that a NullPointerException won't be thrown while converting
        if (base.getPackage().getName().startsWith("org.spongepowered.api.block.tileentity")) {
            Location<World> loc = new Location<>(mock(World.class), 0, 0, 0);
            BlockSnapshot snapshot = mock(BlockSnapshot.class);
            when(loc.createSnapshot()).thenReturn(snapshot);
            when(((TileEntity) mock).getLocation()).thenReturn(loc);
        }
        return mock;
    }

    @Test
    public void resolve() {
        assertSame(pore, WrapperConverter.of(create()).getClass());
    }

}
