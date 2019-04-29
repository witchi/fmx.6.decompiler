package info.phosco.forms.translate.util;

import java.util.logging.Logger;

/**
 * Logger wrapper, it allows to use class references instead of class names
 * 
 * @author arothe
 * @since 0.1
 */
public class Log {

	/**
	 * We can not instantiate this class!
	 */
	private Log() {
	}

	/**
	 * Return a logger for the specified class. The Java framework uses
	 * full-qualified class names (incl. package name).
	 * 
	 * @param clazz
	 *            The Class object, which is used to get a fully-qualified name.
	 * @return The Logger as part of the Java Logging Framework.
	 */
	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz.getCanonicalName());
	}
}
