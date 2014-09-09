package net.amigocraft.pore.implementation.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;

//TODO: skeleton implementation

public class PoreNoteBlock extends PoreBlockState implements NoteBlock {
	public PoreNoteBlock(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Note getNote() {
		return null;
	}

	@Override
	public byte getRawNote() {
		return 0;
	}

	@Override
	public void setNote(Note note) {

	}

	@Override
	public void setRawNote(byte note) {

	}

	@Override
	public boolean play() {
		return false;
	}

	@Override
	public boolean play(byte instrument, byte note) {
		return false;
	}

	@Override
	public boolean play(Instrument instrument, Note note) {
		return false;
	}
}
