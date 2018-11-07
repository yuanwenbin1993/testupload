package com.tarena.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
    static{//只加载一次
		try {
			String resource = "conf/conf.xml";
			InputStream  inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    /**
     * SqlSession 对象表示服务器和数据库的一次会话，非线程安全，
     * 不能定义在类中，可能会出现多个线程公用这个对象，只能定义在方法中。
     * @return
     */
    public static SqlSession getSqLSession(){
    	//开链接SqlSession类似Connnection
    	SqlSession session=sqlSessionFactory.openSession();
    	return session;
    }
    
}
