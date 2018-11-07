package com.tarena.mapperproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.ibatis.session.SqlSession;

public class MapperInvocationHandler implements InvocationHandler {
    private SqlSession session;
	public MapperInvocationHandler(SqlSession session){
    	this.session=session;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj=null;
		
		String methodName=method.getName();
		//用switch case决定用selectOne,selectList,selectMap,insert,update,delete
		obj=session.selectOne("com.tarena.dao.UserMapper."+methodName, args[0]);
		
		return obj;
	}

}
