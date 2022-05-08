package commons.logger;

import commons.logger.constants.EnvParameters;
import org.apache.log4j.xml.DOMConfigurator;

public class Logger {

  private final org.apache.log4j.Logger innerLogger;

  public Logger(final org.apache.log4j.Logger innerLogger) {
    this.innerLogger = innerLogger;
  }

  public static Logger fromType(final Class<?> type) {
    DOMConfigurator.configure(EnvParameters.LOG4J_URL.getValue());
    return new Logger(org.apache.log4j.Logger.getLogger(type));
  }

  public void debug(final String message, final Object... args) {
    this.innerLogger.debug(String.format(message, args));
  }

  public void info(final String message, final Object... args) {
    this.innerLogger.info(String.format(message, args));
  }

  public void warn(final String message, final Object... args) {
    this.innerLogger.warn(String.format(message, args));
  }

  public void exception(final Throwable exception, final String message, final Object... args) {
    this.innerLogger.error(String.format(message, args), exception);
  }

  public void exception(final Throwable exception) {
    this.innerLogger.error("Error: ", exception);
  }
}
