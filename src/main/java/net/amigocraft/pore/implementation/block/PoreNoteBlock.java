package net.amigocraft.pore.implementation.block;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreNoteBlock extends PoreBlockState implements NoteBlock {

	@Override
	public Note getNote(){
		return null;
	}

	@Override
	public byte getRawNote(){
		return 0;
	}

	@Override
	public void setNote(Note note){

	}

	@Override
	public void setRawNote(byte note){

	}

	@Override
	public boolean play(){
		return false;
	}

	@Override
	public boolean play(byte instrument, byte note){
		return false;
	}

	@Override
	public boolean play(Instrument instrument, Note note){
		return false;
	}
}
