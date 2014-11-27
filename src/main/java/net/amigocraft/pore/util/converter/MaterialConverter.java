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

package net.amigocraft.pore.util.converter;

import net.amigocraft.pore.Pore;
import net.amigocraft.pore.util.CsvMap;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaterialConverter {

	private static HashMap<BlockType, Material> blockMap = new HashMap<BlockType, Material>();
	private static HashMap<ItemType, Material> itemMap = new HashMap<ItemType, Material>();

	// note: BiMap is unsuitable because some values are not unique
	private static HashMap<Material, BlockType> reverseBlockMap = new HashMap<Material, BlockType>();
	private static HashMap<Material, ItemType> reverseItemMap = new HashMap<Material, ItemType>();

	static {
		try {
			CsvMap bCsv = new CsvMap();
			bCsv.load(MaterialConverter.class.getResourceAsStream("block-map.csv"), "block-map");
			for (Map.Entry<String, String> e : bCsv.entrySet()){
				try {
					blockMap.put((BlockType)BlockTypes.class.getField(e.getValue()).get(null), Material.valueOf(e.getKey()));
				}
				catch (IllegalAccessException ex){
					ex.printStackTrace();
					Pore.getLogger().error("Material mapping for \"" + e.getKey() + "\" is invalid!");
				}
				catch (NoSuchFieldException ex){
					ex.printStackTrace();
					Pore.getLogger().error("Material mapping for \"" + e.getKey() + "\" is invalid!");
				}
			}

			for (Map.Entry<BlockType, Material> e : blockMap.entrySet()) {
				if (!reverseBlockMap.containsKey(e.getValue())) {
					reverseBlockMap.put(e.getValue(), e.getKey());
				}
			}
			for (Map.Entry<ItemType, Material> e : itemMap.entrySet()) {
				reverseItemMap.put(e.getValue(), e.getKey());
			}
		}
		catch (IOException ex){
			Pore.getLogger().error("Failed to initialize material mappings!");
		}
		try {
			CsvMap iCsv = new CsvMap();
			iCsv.load(MaterialConverter.class.getResourceAsStream("item-map.csv"), "item-map");
			for (Map.Entry<String, String> e : iCsv.entrySet()){
				try {
					itemMap.put((ItemType)ItemTypes.class.getField(e.getValue()).get(null), Material.valueOf(e.getKey()));
				}
				catch (IllegalAccessException ex){
					ex.printStackTrace();
					Pore.getLogger().error("Material mapping for \"" + e.getKey() + "\" is invalid!");
				}
				catch (NoSuchFieldException ex){
					ex.printStackTrace();
					Pore.getLogger().error("Material mapping for \"" + e.getKey() + "\" is invalid!");
				}
			}

			for (Map.Entry<BlockType, Material> e : blockMap.entrySet()) {
				if (!reverseBlockMap.containsKey(e.getValue())) {
					reverseBlockMap.put(e.getValue(), e.getKey());
				}
			}
			for (Map.Entry<ItemType, Material> e : itemMap.entrySet()) {
				if (!reverseItemMap.containsKey(e.getValue())) {
					reverseItemMap.put(e.getValue(), e.getKey());
				}
			}
		}
		catch (IOException ex){
			Pore.getLogger().error("Failed to initialize material mappings!");
		}
	}

	/**
	 * Attempts to convert a given Sponge {@link BlockType} to a Bukkit {@link Material}.
	 * @param spongeType the Sponge {@link BlockType} to convert.
	 * @return the respective Bukkit {@link Material} for the given type.
	 * @throws NotImplementedException if the provided Sponge type does not have a compatible Bukkit type
	 * (types introduced after Minecraft 1.7).
	 */
	public static Material toBukkitMaterial(BlockType spongeType){
		Material mat = blockMap.get(spongeType);
		if (mat != null) {
			return mat;
		}
		else {
			throw new NotImplementedException("No compatible Bukkit material for Sponge block type \"" + spongeType.getId() + "\"");
		}
	}

	/**
	 * Attempts to convert a given Sponge {@link ItemType} to a Bukkit {@link Material}.
	 * @param spongeType the Sponge {@link ItemType} to convert.
	 * @return the respective Bukkit {@link Material} for the given type.
	 * @throws NotImplementedException if the provided Sponge type does not have a compatible Bukkit type
	 * (types introduced after Minecraft 1.7).
	 */
	public static Material toBukkitMaterial(ItemType spongeType){
		Material mat = itemMap.get(spongeType);
		if (mat != null) {
			return mat;
		}
		else {
			throw new NotImplementedException("No compatible Bukkit material for Sponge item type \"" +
					spongeType.getId() + "\"");
		}
	}

	/**
	 * Attempts to convert a given Bukkit {@link Material} to a Sponge {@link BlockType}}.
	 * @param bukkitMaterial the Bukkit {@link Material} to convert.
	 * @return the {@link Material}'s respective Sponge {@link BlockType} or <strong>null</strong> if the
	 * {@link Material} cannot be represented as a block.
	 */
	public static BlockType toBlockType(Material bukkitMaterial){
		return reverseBlockMap.get(bukkitMaterial);
	}

	/**
	 * Attempts to convert a given Bukkit {@link Material} to a Sponge {@link ItemType}}.
	 * @param bukkitMaterial the Bukkit {@link Material} to convert.
	 * @return the {@link Material}'s respective Sponge {@link ItemType} or <strong>null</strong> if the
	 * {@link Material} cannot be represented as an item.
	 */
	public static ItemType toItemType(Material bukkitMaterial){
		return reverseItemMap.get(bukkitMaterial);
	}

	/**
	 * Determines whether a given Bukkit {@link Material} is a block type.
	 * @param bukkitMaterial the Bukkit {@link Material} to convert.
	 * @return whether <strong>bukkitMaterial</strong> is a block type.
	 */
	@SuppressWarnings("deprecation")
	public static boolean isBlock(Material bukkitMaterial){
		return bukkitMaterial.getId() < 256;
	}

	/**
	 * Determines whether a given Bukkit {@link Material} is an item type.
	 * @param bukkitMaterial the Bukkit {@link Material} to convert.
	 * @return whether <strong>bukkitMaterial</strong> is an item type.
	 */
	public static boolean isItem(Material bukkitMaterial){
		return !isBlock(bukkitMaterial);
	}

}
