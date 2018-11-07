package com.tarena.mapperproxy;

import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

import com.tarena.util.MybatisUtil;



public class MapperProxy {
	public static Object getMapper(Class clazz){
		Object proxy_obj=null;
		SqlSession session=MybatisUtil.getSqLSession();
		proxy_obj=Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[]{clazz} , new MapperInvocationHandler(session));
		
		return proxy_obj;
	}
}
