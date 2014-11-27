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

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vectors;

public class Vector3fFactory {

	public static Vector3f fromLocation(Location location){
		return Vectors.create3f((float)location.getX(), (float)location.getY(), (float)location.getZ());
	}

	public static Vector3f fromBukkitVector(Vector vector){
		return Vectors.create3f((float)vector.getX(), (float)vector.getY(), (float)vector.getZ());
	}

}
