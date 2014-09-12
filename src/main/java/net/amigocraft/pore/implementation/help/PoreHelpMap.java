package net.amigocraft.pore.implementation.help;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

import java.util.Collection;
import java.util.List;

// TODO: Bridge

// TODO: Bridge

public class PoreHelpMap implements HelpMap {

	@Override
	public HelpTopic getHelpTopic(String topicName) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<HelpTopic> getHelpTopics() {
		throw new NotImplementedException();
	}

	@Override
	public void addTopic(HelpTopic topic) {
		throw new NotImplementedException();
	}

	@Override
	public void clear() {
		throw new NotImplementedException();
	}

	@Override
	public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<?> factory) {
		throw new NotImplementedException();
	}

	@Override
	public List<String> getIgnoredPlugins() {
		throw new NotImplementedException();
	}

}
