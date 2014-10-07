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

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

public class CsvMapTest {

	@Test
	public void loadTest(){
		CsvMap cm = new CsvMap();
		try {
			assertNotNull(getClass().getClassLoader().getResourceAsStream("test-map.csv"));
			cm.load(getClass().getClassLoader().getResourceAsStream("test-map.csv"), "test-map.csv");
			assertEquals(cm.get("valid"), "this line is valid");
			assertEquals(cm.get("spaceTest"), "this line is trimmed");
			assertEquals(cm.get("tabTest"), "this line is trimmed");
			assertNull(cm.get("tooMany"));
			assertNull(cm.get("tooFew"));
			assertNull(cm.get("#comment"));
		}
		catch (IOException ex){
			fail();
		}
	}

}
