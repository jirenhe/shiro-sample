package com.mrj.common.util;

import com.mrj.po.base.BasePo;

public class DaoUtil {

	public static String getMapperNameSpace(Class<? extends BasePo> clazz) {
		try {
			Object obj = clazz.newInstance();
			String mapperNameSpace = "";
			mapperNameSpace = (String) clazz.getMethod("getMapperNameSpace").invoke(obj);
			obj = null;
			return mapperNameSpace;
		} catch (Exception e) {
			throw new IllegalArgumentException("class:"+clazz+" can not be instanced !");
		}
	}
}
