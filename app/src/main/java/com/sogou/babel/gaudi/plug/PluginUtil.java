package com.sogou.babel.gaudi.plug;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.Collection;

public class PluginUtil {

	public static void setField(Object paramClass, String paramString,
								Object newClass) {
		Field field = null;
		try {
			field = paramClass.getClass().getDeclaredField(paramString);
			field.setAccessible(true);
			field.set(paramClass, newClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	public static Object getField(Object paramClass, String paramString) {
		Field field = null;
		Object object = null;
		try {
			field = paramClass.getClass().getDeclaredField(paramString);
			field.setAccessible(true);
			object = field.get(paramClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public static void addNativePath() {

	}

	public static Class getCollectionTye() {
		return Collection.class;
	}


	public static void setFieldUnsafe(Object paramClass, String paramString,
														 Object newClass) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
		Field field = null;
		field = paramClass.getClass().getDeclaredField(paramString);
		field.setAccessible(true);
		field.set(paramClass, newClass);
	}


}
