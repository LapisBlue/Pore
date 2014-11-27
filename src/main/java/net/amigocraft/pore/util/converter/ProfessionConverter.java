package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Villager;
import org.spongepowered.api.entity.living.villager.Profession;
import org.spongepowered.api.entity.living.villager.Professions;

public class ProfessionConverter {

	private static ImmutableBiMap<Villager.Profession, Profession> map =
			ImmutableBiMap.<Villager.Profession, Profession>builder()
					.put(Villager.Profession.BLACKSMITH,    Professions.BLACKSMITH)
					.put(Villager.Profession.BUTCHER,       Professions.BUTCHER)
					.put(Villager.Profession.FARMER,        Professions.FARMER)
					.put(Villager.Profession.LIBRARIAN,     Professions.LIBRARIAN)
					.put(Villager.Profession.PRIEST,        Professions.PRIEST)
					.build();

	public static Profession of(Villager.Profession profession){
		return map.get(profession);
	}

	public static Villager.Profession of(Profession profession){
		return map.inverse().get(profession);
	}

}
