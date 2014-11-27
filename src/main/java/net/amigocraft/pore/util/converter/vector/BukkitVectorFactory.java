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

package net.amigocraft.pore.util.converter.vector;

import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vector3i;

public class BukkitVectorFactory {

	public static Vector fromVector3i(Vector3i vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

	public static Vector fromVector3d(Vector3d vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

	public static Vector fromVector3f(Vector3f vector){
		return new Vector(vector.getX(), vector.getY(), vector.getZ());
	}

}
