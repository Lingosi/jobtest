package com.zyh.springcloud.jobtest.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	public static List<String> string2List(final String source, final List<String> dest) {
		if ("".equals(source)) {
			return new ArrayList<String>();
		}
		String[] paramArray = source.split(",");
		for (int i = 0; i < paramArray.length; i++) {
			dest.add(paramArray[i]);
		}
		return dest;
	}
}
