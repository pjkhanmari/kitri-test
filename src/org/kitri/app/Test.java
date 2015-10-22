package org.kitri.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("2015-10-02");
		Date d2 = sdf.parse("2015-10-05");
		System.out.println ("Days: " + TimeUnit.DAYS.convert(d1.getTime() - d2.getTime(), TimeUnit.MILLISECONDS));
	}
}
