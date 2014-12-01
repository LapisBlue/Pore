package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.spongepowered.api.block.BlockState;

public class PoreSkull extends PoreBlockState implements Skull {

	private static TypeConverter<BlockState, PoreSkull> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreSkull> getSkullConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreSkull>() {
				@Override
				protected PoreSkull convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreSkull(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSkull of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreSkull(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public boolean hasOwner() {
		throw new NotImplementedException();
	}

	@Override
	public String getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setOwner(String name) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getRotation() {
		throw new NotImplementedException();
	}

	@Override
	public void setRotation(BlockFace rotation) {
		throw new NotImplementedException();
	}

	@Override
	public SkullType getSkullType() {
		throw new NotImplementedException();
	}

	@Override
	public void setSkullType(SkullType skullType) {
		throw new NotImplementedException();
	}
}
