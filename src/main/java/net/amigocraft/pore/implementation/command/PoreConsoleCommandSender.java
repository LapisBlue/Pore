package net.amigocraft.pore.implementation.command;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;

// TODO: Bridge

public class PoreConsoleCommandSender extends PoreServerCommandSender implements ConsoleCommandSender {

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
