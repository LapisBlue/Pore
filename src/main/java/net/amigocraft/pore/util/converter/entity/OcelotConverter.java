package net.amigocraft.pore.util.converter.entity;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Ocelot;
import org.spongepowered.api.entity.living.meta.OcelotType;
import org.spongepowered.api.entity.living.meta.OcelotTypes;

public class OcelotConverter {

	private static ImmutableBiMap<Ocelot.Type, OcelotType> map =
			ImmutableBiMap.<Ocelot.Type, OcelotType>builder()
					.put(Ocelot.Type.BLACK_CAT, OcelotTypes.BLACK_CAT)
					.put(Ocelot.Type.RED_CAT, OcelotTypes.RED_CAT)
					.put(Ocelot.Type.SIAMESE_CAT, OcelotTypes.SIAMESE_CAT)
					.put(Ocelot.Type.WILD_OCELOT, OcelotTypes.WILD_OCELOT)
					.build();

	public static OcelotType of(Ocelot.Type type){
		return map.get(type);
	}

	public static Ocelot.Type of(OcelotType type){
		return map.inverse().get(type);
	}

}
