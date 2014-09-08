package net.amigocraft.pore.implementation.conversations;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

// TODO: Bridge

public class PorePrompt implements Prompt {

	@Override
	public String getPromptText(ConversationContext context) {
		return null;
	}

	@Override
	public boolean blocksForInput(ConversationContext context) {
		return false;
	}

	@Override
	public Prompt acceptInput(ConversationContext context, String input) {
		return null;
	}

}
