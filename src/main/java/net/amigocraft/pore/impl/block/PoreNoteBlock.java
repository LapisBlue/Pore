package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;
import org.spongepowered.api.block.BlockState;

public class PoreNoteBlock extends PoreBlockState implements NoteBlock {

	private static TypeConverter<BlockState, PoreNoteBlock> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreNoteBlock> getNoteBlockConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreNoteBlock>() {
				@Override
				protected PoreNoteBlock convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreNoteBlock(handle);
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
	public static PoreNoteBlock of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreNoteBlock(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public Note getNote() {
		throw new NotImplementedException();
	}

	@Override
	public byte getRawNote() {
		throw new NotImplementedException();
	}

	@Override
	public void setNote(Note note) {
		throw new NotImplementedException();
	}

	@Override
	public void setRawNote(byte note) {
		throw new NotImplementedException();
	}

	@Override
	public boolean play() {
		throw new NotImplementedException();
	}

	@Override
	public boolean play(byte instrument, byte note) {
		throw new NotImplementedException();
	}

	@Override
	public boolean play(Instrument instrument, Note note) {
		throw new NotImplementedException();
	}
}
