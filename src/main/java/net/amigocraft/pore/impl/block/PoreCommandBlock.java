package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CommandBlock;
import org.spongepowered.api.block.BlockState;

public class PoreCommandBlock extends PoreBlockState implements CommandBlock {

	private static TypeConverter<BlockState, PoreCommandBlock> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreCommandBlock> getCommandBlockConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreCommandBlock>() {
				@Override
				protected PoreCommandBlock convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreCommandBlock(handle);
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
	public static PoreCommandBlock of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreCommandBlock(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public String getCommand() {
		throw new NotImplementedException();
	}

	@Override
	public void setCommand(String command) {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

	@Override
	public void setName(String name) {
		throw new NotImplementedException();
	}
}
