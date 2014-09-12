package net.amigocraft.pore.implementation;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.inventory.ItemStack;

import java.util.List;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreUnsafeValues implements UnsafeValues {

	@Override
	public Material getMaterialFromInternalName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack modifyItemStack(ItemStack stack, String arguments) {
		throw new NotImplementedException();
	}

	@Override
	public Statistic getStatisticFromInternalName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public Achievement getAchievementFromInternalName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
		throw new NotImplementedException();
	}
}
