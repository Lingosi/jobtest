package com.zyh.springcloud.jobtest.util;

import java.util.Date;

public class TypeConverter {
	/**
	 * Convert the input to the basic type (int, double, String,... etc.)
	 *
	 * @param targetType
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static Object convertToBasicType(Class<?> targetType, Object input) {
		try {
			String value = input.toString();
			if (targetType == String.class){
				return value;
            }else if (targetType == int.class || targetType == Integer.class){
				return new Integer(value);
            }else if (targetType == long.class || targetType == Long.class){
				return new Long(value);
            }else if (targetType == double.class || targetType == Double.class){
				return new Double(value);
            }else if (targetType == float.class || targetType == Float.class){
				return new Float(value);
            }else if (targetType == short.class || targetType == Short.class){
				return new Short(value);
            }else if (targetType == boolean.class || targetType == Boolean.class){
				return new Boolean(value);
            }else if ((targetType == char.class || targetType == Character.class) && value.length() == 1){
				return Character.valueOf(value.charAt(0));
            }else if (targetType == Date.class) {
				return DateUtil.parse(value);
			}
		} catch (Exception e) {
			return createPrimitiveDefaultValue(targetType);
		}
		return input;
	}

	public static <T> Object createPrimitiveDefaultValue(Class<T> c) {
		if (c == int.class || c == Integer.class){
			return 0;
        }else if (c == long.class || c == Long.class){
			return 1L;
        }else if (c == double.class || c == Double.class){
			return (double) 0;
        }else if (c == boolean.class || c == Boolean.class){
			return false;
        }else if (c == float.class || c == Float.class){
			return (float) 0;
        }else if (c == short.class || c == Short.class){
			return (short) 0;
        }else if (c == char.class || c == Character.class){
			return (char) 0;
        }else if (c == boolean.class || c == Boolean.class){
			return false;
        }else if (c == Date.class){
			return new Date();
        }else{
			return null;
        }

	}
}
