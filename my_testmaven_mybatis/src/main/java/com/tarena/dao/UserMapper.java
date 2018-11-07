package com.tarena.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.tarena.entity.Group;
import com.tarena.entity.User;
import com.tarena.vo.Page;

public interface UserMapper {
	 /*
	  * User findUserById(Integer id) 方法名对应的id ="findUserById" 
		方法的参数Integer id 对应的parameterType="java.lang.Integer" 
		方法的返回值User类型 对应 resultType="com.tarena.entity.User"
	  */
     public User findUserById(Integer id);
     
     public List<User> findUserByPage(Page page);
     
     
     //指定用id作为map中key的值
     @MapKey("id")
     public Map<String,User> findUserByPage1(Page page); 
     
     public int addUser(User user);
     
     public int updateUser(User user);
     
     public int deleteUser(Integer id);
     
     
     public List<User> findUserBy_if(User user);
     
     public List<User> findUserBy_choose(User user);
     
     public List<User> findUserBy_where_notag(Map<String,String> user);
     
     public List<User> findUserBy_where_havetag(Map<String,String> user);
     
     
     public int updateUserBy_Set(Map  data);
     
     public List<User> findUserBy_trim(User user);
     
     public int updateUserBy_trim(User user);
     
     public List<User>  findUserBy_foreach(List<Integer> list);
     //查询用户信息 一个用户信息中包含一个组的对象,group对象中有group的信息
     public User findUserBy_assocication(Integer id);
     //	//查询group信息,一个group对象中包含一个List<User>集合
     public Group findGroupBy_collection(Integer id);
     
}
