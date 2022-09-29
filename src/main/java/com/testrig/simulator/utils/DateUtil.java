package com.testrig.simulator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtil {
	private DateUtil() {
	}

	public static Date parseDateToFormat(String dateString, String format) {
		if (dateString == null) {
			return null;
		}

		SimpleDateFormat fmt = new SimpleDateFormat(format, Locale.ENGLISH);
		fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

		try {
			return fmt.parse(dateString);
		} catch (ParseException ignored) {
		}

		return null;
	}

	public static Date parseYmdDate(String dateString) {
		return parseDateToFormat(dateString, "yyyy-MM-dd");
	}

	public static Date parseMYDate(String dateString) {
		return parseDateToFormat(dateString, "M/yyyy");
	}
}