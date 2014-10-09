package net.amigocraft.pore.implementation.conversations;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;

// TODO: Bridge

// TODO: Bridge

public class PoreConversable implements Conversable {

	@Override
	public boolean isConversing() {
		throw new NotImplementedException();
	}

	@Override
	public void acceptConversationInput(String input) {
		throw new NotImplementedException();
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		throw new NotImplementedException();
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		throw new NotImplementedException();
	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
		throw new NotImplementedException();
	}

	@Override
	public void sendRawMessage(String message) {
		throw new NotImplementedException();
	}

}
