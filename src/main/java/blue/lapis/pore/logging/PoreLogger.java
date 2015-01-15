/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.logging;

import java.util.logging.Formatter;
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
        private ForwardHandler() {
            setFormatter(new DummyFormatter());
        }

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

    private static final class DummyFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            throw new UnsupportedOperationException();
        }
    }
}
