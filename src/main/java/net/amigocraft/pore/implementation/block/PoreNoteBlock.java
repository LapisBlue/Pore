package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreNoteBlock extends PoreBlockState implements NoteBlock {
	public PoreNoteBlock(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
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
