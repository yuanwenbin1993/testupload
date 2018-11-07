package com.tarena.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tarena.dao.UserDaoImpl;
import com.tarena.dao.UserMapper;
import com.tarena.entity.Group;
import com.tarena.entity.User;
import com.tarena.util.MybatisUtil;
import com.tarena.vo.Page;

public class TestUserMapperClass {
     @Test
     public void testFindUserById(){
    	 SqlSession session=null;
     	try {
     		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
     		session=MybatisUtil.getSqLSession();
     		//userMapper对象是一个jdk代理对象,基于UserMapper接口生成的代理对象
     		UserMapper userMapper=session.getMapper(UserMapper.class);
     		User user=userMapper.findUserById(5);
     		System.out.println(user);
     	
     		session.commit();
 		} catch (Exception e) {
 			e.printStackTrace();
 			session.rollback();
 		}finally{
 			if(session!=null){
 			   session.close();
 			}
 		}
     }
     
     
     @Test
     public void testFindUserByPage(){
    	 SqlSession session=null;
     	try {
     		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
     		session=MybatisUtil.getSqLSession();
     		//userMapper对象是一个jdk代理对象,基于UserMapper接口生成的代理对象
     		//用代理对象调用的目标方法,实际上执行的是InvocationHandler中的invoke方法
     		//在invoke方法中用switch case决定用哪一个原生api
     		UserMapper userMapper=session.getMapper(UserMapper.class);
     		Page page=new Page();
        	page.setPageSize(2);
        	page.setCurrentPage(2);
        	page.setUserNameKeyword("a");
        	page.setUserPasswordKeyword("a");
        	
     		List<User> users=userMapper.findUserByPage(page);
     		for(User user:users){
     			System.out.println(user);
     		}
     	
     		session.commit();
 		} catch (Exception e) {
 			e.printStackTrace();
 			session.rollback();
 		}finally{
 			if(session!=null){
 			   session.close();
 			}
 		}
     }
     
     

     @Test
     public void testFindUserByPage1(){
    	 SqlSession session=null;
     	try {
     		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
     		session=MybatisUtil.getSqLSession();
     		//userMapper对象是一个jdk代理对象,基于UserMapper接口生成的代理对象
     		//用代理对象调用的目标方法,实际上执行的是InvocationHandler中的invoke方法
     		//在invoke方法中用switch case决定用哪一个原生api
     		UserMapper userMapper=session.getMapper(UserMapper.class);
     		Page page=new Page();
        	page.setPageSize(2);
        	page.setCurrentPage(1);
        	page.setUserNameKeyword("a");
        	page.setUserPasswordKeyword("a");
        	
     		Map<String,User> users=userMapper.findUserByPage1(page);
     		for(User user:users.values()){
     			System.out.println(user);
     		}
     	
     		session.commit();
 		} catch (Exception e) {
 			e.printStackTrace();
 			session.rollback();
 		}finally{
 			if(session!=null){
 			   session.close();
 			}
 		}
     }
     
 	@Test
     public void testAddUser(){
 		 SqlSession session=null;
      	try {
      		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
      		session=MybatisUtil.getSqLSession();
      		//userMapper对象是一个jdk代理对象,基于UserMapper接口生成的代理对象
      		//用代理对象调用的目标方法,实际上执行的是InvocationHandler中的invoke方法
      		//在invoke方法中用switch case决定用哪一个原生api
      		UserMapper userMapper=session.getMapper(UserMapper.class);
      		User user=new User();
        	user.setName("周杰伦");
        	user.setPassword("111");
        	
      		int rowAffect=userMapper.addUser(user);
      		System.out.println("受影响的行数:"+rowAffect);
        	System.out.println("id="+user.getId());
      		session.commit();
  		} catch (Exception e) {
  			e.printStackTrace();
  			session.rollback();
  		}finally{
  			if(session!=null){
  			   session.close();
  			}
  		}
     }
 	
 	@Test
 	public void updateUser(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper userMapper=session.getMapper(UserMapper.class);
			User user=new User();
	    	user.setId(1);
	    	user.setName("嘻嘻");
	    	user.setPassword("111");
	    	int rowAffect = userMapper.updateUser(user);
	    	System.out.println("受影响的行数:"+rowAffect);
	    	session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}		
 	}
 	
 	@Test
 	public void testDeleteUser(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			int rowAffect=mapper.deleteUser(3);
			System.out.println("受影响行数:"+rowAffect);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
     
 	/**
 	 * 以下演示的是动态sql
 	 */
 	@Test
 	public void testFindUserBy_if(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user=new User();
			user.setPassword("gf");
			//select * 
			List<User> users=mapper.findUserBy_if(user);
			for(User u:users){
				System.out.println(u);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
     
 	
 	@Test
 	public void testFindUserBy_choose(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user=new User();
			user.setPassword("gf");
		
			List<User> users=mapper.findUserBy_choose(user);
			for(User u:users){
				System.out.println(u);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testFindUserBy_where(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String,String> data=new HashMap<>();
			data.put("uname", "%cb%");
			data.put("upwd", "%gf%");
		
			List<User> users=mapper.findUserBy_where_notag(data);
					
			for(User u:users){
				System.out.println(u);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testFindUserBy_where_havetag(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String,String> data=new HashMap<>();
			//data.put("uname", "%cb%");
			data.put("upwd", "%gf%");  //测试 where 之后紧跟的and 是否会自动去除
		
			List<User> users=mapper.findUserBy_where_havetag(data);
					
			for(User u:users){
				System.out.println(u);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	@Test
 	public void testUpdateUserBySet(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String,Object> data=new HashMap<>();
			data.put("uname", "aabcd");
			data.put("upwd", "aa");  
			data.put("uid", new Integer(4));
		
			int i=mapper.updateUserBy_Set(data);
					
			System.out.println(i);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testFindUserBy_trim(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user=new User();
			user.setName("%a%");
			user.setPassword("%a%");
		
			List<User> users=mapper.findUserBy_trim(user);
					
			for(User u:users){
				System.out.println(u);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testUpdateUserBy_trim(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user=new User();
			user.setName("周杰伦");
			user.setPassword("12");
		    user.setId(5);
			int i=mapper.updateUserBy_trim(user);
			System.out.println(i);		
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	@Test
 	public void testUpdateUserBy_foreach(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<Integer> list=new ArrayList<>();
			list.add(5);
			list.add(6);
			List<User> users=mapper.findUserBy_foreach(list);
			for(User user:users){	
				System.out.println(user);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testUpdateUserBy_association(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user=mapper.findUserBy_assocication(5);
			System.out.println(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
 	
 	
 	@Test
 	public void testUpdateUserBy_collection(){
 		SqlSession session=null;
 		try {
			session=MybatisUtil.getSqLSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			Group group=mapper.findGroupBy_collection(1);
			System.out.println(group);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}
 	}
}
