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

import java.io.*;
import java.util.HashMap;

public class CsvMap extends HashMap<String, String> {

	private char separator = ',';
	private char comment = '#';

	public void load(InputStream stream, String id) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(stream));
			int lineNum = 0;
			String line;
			while ((line = reader.readLine()) != null){
				lineNum += 1;
				if (line.trim().isEmpty() || !line.trim().startsWith(Character.toString(comment))) {
					String[] array = line.split(Character.toString(separator));
					if (array.length == 2){
						super.put(array[0].trim(), array[1].trim());
					}
					else if (array.length < 2){
						System.err.println("Invalid class mapping found in " + id + " on line " + lineNum + ": parameters < 2");
					}
					else if (array.length > 2){
						System.err.println("Invalid class mapping found in " + id + " on line " + lineNum + ": parameters > 2");
					}
				}
			}
		}
		finally {
			try {
				if (reader != null) {
					reader.close();
					stream.close();
				}
			}
			catch (IOException ex){
				ex.printStackTrace();
				System.err.println("Failed to properly close FileOutputStream!");
			}
		}
	}

	public void load(File file) throws IOException{
		this.load(new FileInputStream(file), file.getName());
	}

	public char getSeparator(){
		return separator;
	}

	public void setSeparator(char separator){
		this.separator = separator;
	}

	public char getCommentChar(){
		return comment;
	}

	public void setCommentChar(char comment){
		this.comment = comment;
	}

}