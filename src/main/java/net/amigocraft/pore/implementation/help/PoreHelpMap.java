package net.amigocraft.pore.implementation.help;

import java.util.Collection;
import java.util.List;

import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

// TODO: Bridge

public class PoreHelpMap implements HelpMap {

	@Override
	public HelpTopic getHelpTopic(String topicName) {
		return null;
	}

	@Override
	public Collection<HelpTopic> getHelpTopics() {
		return null;
	}

	@Override
	public void addTopic(HelpTopic topic) {

	}

	@Override
	public void clear() {

	}

	@Override
	public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<?> factory) {

	}

	@Override
	public List<String> getIgnoredPlugins() {
		return null;
	}

}
