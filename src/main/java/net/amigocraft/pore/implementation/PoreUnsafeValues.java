package net.amigocraft.pore.implementation;

import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.inventory.ItemStack;

import java.util.List;

//TODO: skeleton implementation

public class PoreUnsafeValues implements UnsafeValues {

	@Override
	public Material getMaterialFromInternalName(String name) {
		return null;
	}

	@Override
	public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
		return null;
	}

	@Override
	public ItemStack modifyItemStack(ItemStack stack, String arguments) {
		return null;
	}

	@Override
	public Statistic getStatisticFromInternalName(String name) {
		return null;
	}

	@Override
	public Achievement getAchievementFromInternalName(String name) {
		return null;
	}

	@Override
	public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
		return null;
	}
}
