package com.zyh.springcloud.jobtest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date getDate(Date source){
		try {
			return sdfDate.parse(sdfDate.format(source));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date parse(String source){
		try {
			return sdfDate.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
