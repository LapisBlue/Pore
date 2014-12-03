package net.amigocraft.pore.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PoreLogger extends Logger {
	private final org.slf4j.Logger handle;

	public PoreLogger(org.slf4j.Logger logger) {
		super(logger.getName(), null);
		this.handle = logger;
		addHandler(new ForwardHandler());
	}

	public org.slf4j.Logger getHandle() {
		return handle;
	}

	private class ForwardHandler extends Handler {

		@Override
		public void publish(LogRecord record) {
			Level level = record.getLevel();
			String message = getFormatter().formatMessage(record);
			Throwable thrown = record.getThrown();

			if (level == Level.SEVERE) {
				handle.error(message, thrown);
			} else if (level == Level.WARNING) {
				handle.warn(message, thrown);
			} else if (level == Level.INFO) {
				handle.info(message, thrown);
			} else if (level == Level.CONFIG) {
				handle.debug(message, thrown);
			} else {
				handle.trace(message, thrown);
			}
		}

		@Override
		public void flush() {
		}

		@Override
		public void close() throws SecurityException {
		}
	}
}
