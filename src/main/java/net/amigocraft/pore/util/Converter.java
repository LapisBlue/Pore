/**
 * This file is a part of Pore, licensed under the MIT License.
 *
 * Copyright (c) Maxim Roncacé
 * Copyright (c) Lapis Blue
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.amigocraft.pore.util;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Contains a weak map between Sponge objects and their respective Pore wrappers.
 * This class allows for Pore to maintain a single wrapper for each object in Sponge, as opposed to multiple.
 * @param <S> The class of the Sponge object to be wrapped.
 * @param <B> The class of the Sponge class's corresponding wrapper in Pore.
 */
public abstract class Converter<S, B> implements Function<S, B> {
	private final Map<S, B> instances = new MapMaker().concurrencyLevel(1).weakKeys().weakValues().makeMap();

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return The Pore wrapper for the given Sponge object (<b>handle</b>).
	 */
	@Nullable
	@Override
	public B apply(@Nullable S handle) {
		if (handle == null) return null;
		B result = instances.get(handle);
		if (result == null) {
			instances.put(handle, result = convert(handle));
		}
		return result;
	}

	protected B applyUnchecked(Object handle) {
		return apply((S) handle);
	}

	protected abstract B convert(S handle);

}
