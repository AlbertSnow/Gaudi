package com.sogou.babel.gaudi.plug;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class PluginUtil {

	public static void setFieldValue(Object paramClass, String paramString,
									 Object newClass) {
		setFieldValue(paramClass, paramClass.getClass(), paramString, newClass);
	}

	public static void setFieldValue(Object paramClass, Class classParam, String paramString,
									 Object newClass) {
		Field field = null;
		try {
			field = classParam.getDeclaredField(paramString);
			field.setAccessible(true);
			field.set(paramClass, newClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getFieldValue(Object paramClass, String paramString) {
		return getFieldValue(paramClass, paramClass.getClass(), paramString);
	}

	public static Object getFieldValue(Object objectParam, Class classParam, String paramString) {
		Field field = null;
		Object object = null;
		try {
			field = classParam.getDeclaredField(paramString);
			field.setAccessible(true);
			object = field.get(objectParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public static Class getCollectionTye() {
		return Collection.class;
	}


	/**
	 * 动态代理不可以代理 类，只能代理接口，因为 代理生成类 Proxy$0已经继承了Proxy，无法多继承
	 * @param base
	 */
	@Deprecated
	public static void hookPathList(@NotNull Context base) {
		//        copySoFile(base)
		Object packageInfo = PluginUtil.getFieldValue(base, "mPackageInfo");
		//        val classLoader = PlugClassLoader("/data/app/com.sogou.babel.gaudi-2/base.apk", base.classLoader)

		Object classLoader = PluginUtil.getFieldValue(packageInfo, "mClassLoader");
		Object pathList = PluginUtil.getFieldValue(
				classLoader,
				classLoader.getClass().getSuperclass(), "pathList"
		);

		DexPathListInvocationHandler handler = new DexPathListInvocationHandler(pathList);

		Object pathListProxy = Proxy.newProxyInstance(
				base.getClass().getClassLoader(),
				pathList.getClass().getInterfaces(),
				handler
		);

		PluginUtil.setFieldValue(
				classLoader, classLoader.getClass().getSuperclass(),
				"pathList", pathListProxy
		);
	}
}
