package mitchell.com;

import android.util.Log;

/**
 * A debugging class for the Android application.
 * 
 * LOG must be true or nothing will be logged.
 * The log type (or a lower type) must be enabled for this message to be logged.
 * 
 * Enable log types in a console window by: adb shell setProp "DEBUG_TAG" "TYPE"
 * where TYPE in priority order is VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, 
 * or SUPPRESS to suppress logging.
 * 
 * Setting a TYPE enables all types above it.
 * Default TYPE is INFO, so VERBOSE and DEBUG start out disabled.
 */
public final class Bug {

	private static Bug instance;

	public static final String DEBUG_TAG = "Mitchell";
	public static boolean LOG = false;
	int counter = 0;

	/**
	 * getInstance - Instantiate our singleton.
	 * @return Bug
	 */
	public static Bug getInstance() {
		if (instance == null) {

			instance = new Bug();
		}
		instance.counter++;
		return instance;
	}

	/**
	 * d - Debug message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void d(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.DEBUG)) {
			Log.d(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * d - Debug message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void d(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.DEBUG)) {
			Log.d(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * i - Information message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void i(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.INFO)) {
			Log.i(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * i - Information message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void i(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.INFO)) {
			Log.i(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * e - Error message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void e(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.ERROR)) {
			Log.e(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * e - Error message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void e(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.ERROR)) {
			Log.e(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * v - Verbose message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void v(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.VERBOSE)) {
			Log.v(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * v - Verbose message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void v(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.VERBOSE)) {
			Log.v(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * w - Warning message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void w(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.WARN)) {
			Log.w(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * w - Warning message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void w(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.WARN)) {
			Log.w(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * a - Assert message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 */
	public static void a(final Object where, String msg) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.ASSERT)) {
			Log.wtf(DEBUG_TAG, bldMsg(where, msg));
		}
	}

	/**
	 * a - Assert message type.
	 * @param where
	 *            Class of caller
	 * @param msg
	 *            Message to be logged
	 * @param tr
	 *            Exception to be logged
	 */
	public static void a(final Object where, String msg, Throwable tr) {
		getInstance();
		if (LOG && Log.isLoggable(DEBUG_TAG, Log.ASSERT)) {
			Log.wtf(DEBUG_TAG, bldMsg(where, msg), tr);
		}
	}

	/**
	 * bldMsg - Construct final message string.
	 * @param where
	 *            Class of caller
	 * @param message
	 *            Message to be logged
	 * @return String representing class and text
	 */
	private static String bldMsg(final Object where, String message) {
		StringBuffer sb = new StringBuffer();
		sb.append(instance.counter).append(": ");
		sb.append(where.getClass().getName()).append(": ").append(message);
		return sb.toString();
	}

}