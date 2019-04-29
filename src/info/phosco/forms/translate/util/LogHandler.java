package info.phosco.forms.translate.util;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * The LogHandler class initializes the Java Logging Framework. We are using
 * different logfiles for RMI and a summarized logfile for the application. All
 * logout is also visible in the console, but only level INFO and above.
 * 
 * @author arothe
 * @since 0.1
 */
public class LogHandler {

	/**
	 * We can not instantiate the class.
	 */
	private LogHandler() {
	}

	/**
	 * init all Loggers and their handler/formatter.
	 */
	public static void init(Level level) {
		enableFileLogging("info.phosco.forms", "decompiler.log", level);
		enableConsoleLogging("info.phosco.forms", level);
	}

	/**
	 * Enable file logging for the specified logger. We log all levels.
	 * 
	 * @param loggername
	 *            The logger of the Java Logging Framework.
	 * @param filename
	 *            The dedicated logfile for the logger.
	 */
	private static void enableFileLogging(String loggername, String filename, Level level) {

		try {

			FileHandler fh = new FileHandler(System.getProperty("user.dir") + "/" + filename);
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(level);
			
			Logger logger = Logger.getLogger(loggername);

			logger.setUseParentHandlers(false);
			logger.setLevel(Level.ALL);
			logger.addHandler(fh);

		} catch (IOException e) {
			System.out.println("logger exception");
		}
	}

	/**
	 * Enable console logging for the specified logger. We log only level INFO
	 * and above.
	 * 
	 * @param loggername
	 *            The logger of the Java Logging Framework.
	 */
	private static void enableConsoleLogging(String loggername, Level level) {

		StreamHandler sh = new ConsoleHandler();
		sh.setLevel(level);
		sh.setFormatter(new SimpleFormatter());

		Logger logger = Logger.getLogger(loggername);

		logger.setUseParentHandlers(false);
		logger.setLevel(Level.ALL);
		logger.addHandler(sh);
	}
}
