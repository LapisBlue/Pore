package net.amigocraft.pore.implementation.configuration;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Color;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: Bridge

// TODO: Bridge

public class PoreConfigurationSection implements ConfigurationSection {

	@Override
	public Set<String> getKeys(boolean deep) {
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Object> getValues(boolean deep) {
		throw new NotImplementedException();
	}

	@Override
	public boolean contains(String path) {
		return false;
	}

	@Override
	public boolean isSet(String path) {
		return false;
	}

	@Override
	public String getCurrentPath() {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

	@Override
	public Configuration getRoot() {
		throw new NotImplementedException();
	}

	@Override
	public ConfigurationSection getParent() {
		throw new NotImplementedException();
	}

	@Override
	public Object get(String path) {
		throw new NotImplementedException();
	}

	@Override
	public Object get(String path, Object def) {
		throw new NotImplementedException();
	}

	@Override
	public void set(String path, Object value) {
		throw new NotImplementedException();
	}

	@Override
	public ConfigurationSection createSection(String path) {
		throw new NotImplementedException();
	}

	@Override
	public ConfigurationSection createSection(String path, Map<?, ?> map) {
		throw new NotImplementedException();
	}

	@Override
	public String getString(String path) {
		throw new NotImplementedException();
	}

	@Override
	public String getString(String path, String def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isString(String path) {
		return false;
	}

	@Override
	public int getInt(String path) {
		return 0;
	}

	@Override
	public int getInt(String path, int def) {
		return 0;
	}

	@Override
	public boolean isInt(String path) {
		return false;
	}

	@Override
	public boolean getBoolean(String path) {
		return false;
	}

	@Override
	public boolean getBoolean(String path, boolean def) {
		return false;
	}

	@Override
	public boolean isBoolean(String path) {
		return false;
	}

	@Override
	public double getDouble(String path) {
		return 0;
	}

	@Override
	public double getDouble(String path, double def) {
		return 0;
	}

	@Override
	public boolean isDouble(String path) {
		return false;
	}

	@Override
	public long getLong(String path) {
		return 0;
	}

	@Override
	public long getLong(String path, long def) {
		return 0;
	}

	@Override
	public boolean isLong(String path) {
		return false;
	}

	@Override
	public List<?> getList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<?> getList(String path, List<?> def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isList(String path) {
		return false;
	}

	@Override
	public List<String> getStringList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Integer> getIntegerList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Boolean> getBooleanList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Double> getDoubleList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Float> getFloatList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Long> getLongList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Byte> getByteList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Character> getCharacterList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Short> getShortList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public List<Map<?, ?>> getMapList(String path) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getVector(String path) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getVector(String path, Vector def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isVector(String path) {
		return false;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String path) {
		throw new NotImplementedException();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOfflinePlayer(String path) {
		return false;
	}

	@Override
	public ItemStack getItemStack(String path) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItemStack(String path, ItemStack def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isItemStack(String path) {
		return false;
	}

	@Override
	public Color getColor(String path) {
		throw new NotImplementedException();
	}

	@Override
	public Color getColor(String path, Color def) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isColor(String path) {
		return false;
	}

	@Override
	public ConfigurationSection getConfigurationSection(String path) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isConfigurationSection(String path) {
		return false;
	}

	@Override
	public ConfigurationSection getDefaultSection() {
		throw new NotImplementedException();
	}

	@Override
	public void addDefault(String path, Object value) {
		throw new NotImplementedException();
	}

}
