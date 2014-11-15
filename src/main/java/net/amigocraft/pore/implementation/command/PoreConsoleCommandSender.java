package net.amigocraft.pore.implementation.command;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.spongepowered.api.service.permission.Subject;

// TODO: Bridge

// TODO: Bridge

public class PoreConsoleCommandSender extends PoreServerCommandSender implements ConsoleCommandSender {

	// TODO
	protected PoreConsoleCommandSender(Subject handle) {
		super(handle);
	}

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
