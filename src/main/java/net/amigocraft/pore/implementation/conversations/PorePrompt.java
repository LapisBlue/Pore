package net.amigocraft.pore.implementation.conversations;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

// TODO: Bridge

// TODO: Bridge

public class PorePrompt implements Prompt {

	@Override
	public String getPromptText(ConversationContext context) {
		throw new NotImplementedException();
	}

	@Override
	public boolean blocksForInput(ConversationContext context) {
		return false;
	}

	@Override
	public Prompt acceptInput(ConversationContext context, String input) {
		throw new NotImplementedException();
	}

}
