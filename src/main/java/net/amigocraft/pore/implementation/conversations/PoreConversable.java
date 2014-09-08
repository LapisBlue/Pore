package net.amigocraft.pore.implementation.conversations;

import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;

// TODO: Bridge

public class PoreConversable implements Conversable {

	@Override
	public boolean isConversing() {
		return false;
	}

	@Override
	public void acceptConversationInput(String input) {

	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		return false;
	}

	@Override
	public void abandonConversation(Conversation conversation) {

	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {

	}

	@Override
	public void sendRawMessage(String message) {

	}

}
