package com.lccf.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;


/**
 * 泛型工具类
 */
public class GenericsUtils {

	/**
	 * 获得指定类类的泛型参数类型
	 * @param clazz Class
	 * @param index  泛型参数所在索引,从0开始
	 * @return  Class
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {
		if (clazz == null) {
			return null;
		}

		Type genericType = clazz.getGenericSuperclass();
		while (genericType != null && !(genericType instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
			if (clazz == null) {
				break;
			} else {
				genericType = clazz.getGenericSuperclass();
			}
		}

		if (!(genericType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();
		if (params != null && index >= 0 && index < params.length ) {
			if (params[index] instanceof Class) {
				return (Class) params[index];
			}
		}

		return Object.class;
	}


	/**
	 * 获取接口的泛型类型
	 * @param clazz 目标类
	 * @param interface1 指定接口
	 * @param index 指定泛型index
	 * @return
	 */
	public static Class getInterfaceGenricType(Class clazz, Class interface1, int index) {
		if (clazz == null || interface1 == null) {
			return null;
		}

		Type foundInteface = null;
		Type[] interfaces = clazz.getGenericInterfaces();
		for (Type iType : interfaces) {
			if (!(iType instanceof ParameterizedType)) {
				continue;
			}

			if (((ParameterizedType) iType).getRawType() == interface1) {
				foundInteface = iType;
			}
		}

		if (foundInteface == null) {
			return null;
		}


		Type[] params = ((ParameterizedType) foundInteface).getActualTypeArguments();
		if (params != null && index >= 0 && index < params.length ) {
			if (params[index] instanceof Class) {
				return (Class) params[index];
			}
		}

		return Object.class;
	}


	/**
	 * 获取实际类参数
	 * @param actual 最终类
	 * @param generic 泛型声明类
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private static Map<String, Type> getActualTypeParametersMap(Class<?> actual, Class<?> generic) {
		List<String> names = new ArrayList<String>();
		for (TypeVariable t : generic.getTypeParameters()) {
			names.add(t.getName());
		}

		List<Type> values = new ArrayList<Type>();
		for (Type t : actual.getGenericInterfaces()) {
			if (t instanceof Class<?>)
				continue;
			if (((ParameterizedType) t).getRawType().equals(generic)) {
				Collections.addAll(values, ((ParameterizedType) t).getActualTypeArguments());
				break;
			}
		}
		if (values.size() == 0) {
			ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
			if (type.getRawType().equals(generic)) {
				Collections.addAll(values, ((ParameterizedType) type).getActualTypeArguments());
			}
		}

		Map<String, Type> result = new HashMap<String, Type>();
		for (int i = 0; i < names.size(); i++) {
			result.put(names.get(i), values.get(i));
		}
		return result;
	}

}
