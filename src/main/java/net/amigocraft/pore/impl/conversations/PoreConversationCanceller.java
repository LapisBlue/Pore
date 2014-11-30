package net.amigocraft.pore.impl.conversations;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationCanceller;
import org.bukkit.conversations.ConversationContext;

public class PoreConversationCanceller implements ConversationCanceller {

	// TODO: Bridge

	@Override
	public void setConversation(Conversation conversation) {
		throw new NotImplementedException();
	}

	@Override
	public boolean cancelBasedOnInput(ConversationContext context, String input) {
		throw new NotImplementedException();
	}


	public ConversationCanceller clone() {
		throw new NotImplementedException();
	}

}
