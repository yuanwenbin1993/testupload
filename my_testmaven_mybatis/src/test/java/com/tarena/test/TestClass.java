package com.tarena.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.tarena.dao.UserDaoImpl;
import com.tarena.entity.User;
import com.tarena.vo.Page;

public class TestClass {
	@Test
    public void testFindUserById(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	userDao.fingUserById(5);
    	
    }
	
	@Test
    public void testFindUserById1(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Map<String,Object> user=userDao.fingUserById1(5);
    	
    	System.out.print("id="+user.get("id"));
    	System.out.print("  username="+user.get("name"));
    	System.out.println("  userpassword="+user.get("password"));
    }
	
	@Test
    public void testFindUserByPageUseList(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Page page=new Page();
    	page.setPageSize(2);
    	page.setCurrentPage(2);
    	page.setUserNameKeyword("a");
    	page.setUserPasswordKeyword("a");
    	List<User> userList=userDao.fingUserByPageUseList(page);
    	for(User user:userList){
    		System.out.println(user);
    	}	
    	//下面的代码是为了模拟
    	page.setData(userList);
    	page.setPreviousPage(1);
    	page.setNextPage(3);
    }
	
	@Test
    public void testFindUserByPageUseMap(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Page page=new Page();
    	page.setPageSize(2);
    	page.setCurrentPage(2);
    	page.setUserNameKeyword("a");
    	page.setUserPasswordKeyword("a");
    	Map<String, User> userMap = userDao.fingUserByPageUseMap(page);
    	//利用键来获取值
//    	Set<Object> keys = userMap.keySet();
//    	for(Object key:keys){
//    		System.out.println(userMap.get(key));
//    	}
    	//利用Entry对象来获取值
    	for(Map.Entry<String, User> entrySet:userMap.entrySet()){
    		System.out.println(entrySet.getValue());
    	}  	
    }
	
	@Test
    public void testFindUserByPageUseList1(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Page page=new Page();
    	page.setPageSize(2);
    	page.setCurrentPage(2);
    	page.setUserNameKeyword("a");
    	page.setUserPasswordKeyword("a");
    	List<Map<String,Object>> userList=userDao.fingUserByPageUseList1(page);
    	for(Map<String,Object> user:userList){
    		System.out.print("id="+user.get("id"));
        	System.out.print("  username="+user.get("name"));
        	System.out.println("  userpassword="+user.get("password"));
    	}	
    	//下面的代码是为了模拟
    	page.setData(userList);
    	page.setPreviousPage(1);
    	page.setNextPage(3);
    }
	
	
	@Test
    public void testFindUserByPageUseMap1(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Page page=new Page();
    	page.setPageSize(1);
    	page.setCurrentPage(1);
    	page.setUserNameKeyword("a");
    	page.setUserPasswordKeyword("a");
    	Map<String,Map<String,Object>> userMap = userDao.fingUserByPageUseMap1(page);
    	
 
    	for(Map<String,Object> user:userMap.values()){
    		System.out.print("id="+user.get("id"));
        	System.out.print("  username="+user.get("name"));
        	System.out.println("  userpassword="+user.get("password"));
    	}  	
    }
	
	
	@Test
    public void testFindUserByPagezidingyi(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	Page page=new Page();
    	page.setPageSize(2);
    	page.setCurrentPage(2);
    	page.setUserNameKeyword("a");
    	page.setUserPasswordKeyword("a");
    	System.out.println(userDao.findUserByPage_zidingyi(page));
    }
	
	
	@Test
    public void testAddUser(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	User user=new User();
    	user.setName("asdf");
    	user.setPassword("111");
    	int rowAffect = userDao.addUser(user);
    	System.out.println("受影响的行数:"+rowAffect);
    	System.out.println("id="+user.getId());
    }
	
	@Test
    public void testUpdateUser(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	User user=new User();
    	user.setId(1);
    	user.setName("哈哈");
    	user.setPassword("222");
    	int rowAffect = userDao.updateUser(user);
    	System.out.println("受影响的行数:"+rowAffect);
    	
    }
	@Test
    public void testdeleteUser(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	
    	int rowAffect = userDao.deleteUser(2);
    	System.out.println("受影响的行数:"+rowAffect);
    	
    }
	
	
	@Test
    public void testdeleteUser_bujianyi(){
    	UserDaoImpl userDao=new UserDaoImpl();
    	
    	int rowAffect = userDao.deleteUser(3);
    	System.out.println("受影响的行数:"+rowAffect);
    	
    }
}
