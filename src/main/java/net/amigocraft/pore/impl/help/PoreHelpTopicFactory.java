package net.amigocraft.pore.impl.help;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

//TODO: Bridge
public class PoreHelpTopicFactory<TCommand extends Command> implements HelpTopicFactory<TCommand> {

	@Override
	public HelpTopic createTopic(TCommand command) {
		throw new NotImplementedException();
	}

}
