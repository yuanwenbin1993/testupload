package com.tarena.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import com.tarena.entity.User;
import com.tarena.util.MybatisUtil;
import com.tarena.vo.Page;

/**
 * 用mybatis的api的增删改查的方法
 * @author Administrator
 *
 */
public class UserDaoImpl {
	/**
	 * 查询一个对象
	 * @param id 主键ID
	 * @return user 对象
	 */
    public User fingUserById(Integer id){
    	User user=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		user=(User)session.selectOne("x.y.z.findUserById",id);
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
    	return  user;
    }
    /**
     * 列名作为key  值作为value
     * @param id
     * @return
     */
    public Map<String,Object> fingUserById1(Integer id){
    	Map<String,Object> user=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		user=(Map<String,Object>)session.selectOne("x.y.z.findUserById1",id);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
			   session.close();
			}
		}
    	return  user;
    }
    
    
    
    
    /**
     * 按分页查询多个对象  按理说查询不需要添加事务
     * @param page 封装分页相关数据   
     * @return List
     */
    public List<User> fingUserByPageUseList(Page page){
    	List<User> userList=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		userList = session.selectList("x.y.z.findUserByPage", page);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return  userList;
    }
    
    /**
     * 
     * @param page
     * @return
     */
    public Map<String,User> fingUserByPageUseMap(Page page){
    	Map<String,User> userMap=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		//id根据结果集中的id
    		userMap=session.selectMap("x.y.z.findUserByPage", page, "id");
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return  userMap;
    }
    
    
    /**
     * 按分页查询多个对象  按理说查询不需要添加事务
     * @param page 封装分页相关数据   
     * @return List
     */
    public List<Map<String,Object>> fingUserByPageUseList1(Page page){
    	List<Map<String,Object>> users=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		users = session.selectList("x.y.z.findUserByPage1", page);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return  users;
    }
    
    
    /**Map里套Map   
     * 
     * @param page
     * @return
     */
    public Map<String,Map<String,Object>> fingUserByPageUseMap1(Page page){
    	Map<String,Map<String,Object>> userMap=null;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		//id根据结果集中的id
    		userMap=session.selectMap("x.y.z.findUserByPage1", page, "id");
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return  userMap;
    }
    
    /*
     * 内部类  [{"id":"***","username":"***","userpassword":"***"},{},{}]
     */
    class JsonResultHandler implements ResultHandler{
        //resultcontext上下文   体现为Java中的一个对象 上文存 下文取
   
    	StringBuilder json=new StringBuilder("[");
		@Override
		public void handleResult(ResultContext resultContext) {
			User user=(User)resultContext.getResultObject();
			json.append("{");
			json.append("\"id\"");
			json.append(":");
			json.append(user.getId());
			
			json.append(",");
			json.append("\"username\"");
			json.append(":");
			json.append("\""+user.getName()+"\"");
			
			json.append(",");
			json.append("\"userpassword\"");
			json.append(":");
			json.append("\""+user.getPassword()+"\"");
			
			json.append("}");
			
			json.append(",");
		}
		
		public String getJson(){
			return json.substring(0,json.length()-1)+"]";
		}
    	
    }
    public String findUserByPage_zidingyi(Page page){
    	String json=null;
    	SqlSession session=null;
    	try {
    		
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		JsonResultHandler jrh=new JsonResultHandler();
    		//方法里参数是接口 策略设计模式
    		session.select("x.y.z.findUserByPage", page,jrh);
    	    json=jrh.getJson();
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return json;
    }
    
    
    public int addUser(User user){
    	int rowAffect=0;
    	SqlSession session=null;
    	try {
    		
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		rowAffect=session.insert("x.y.z.addUser", user);
    		
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return rowAffect;
    }
    
    public int updateUser(User user){
    	int rowAffect=0;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		rowAffect=session.update("x.y.z.updateUser", user);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return rowAffect;
    }
    
    public int deleteUser(Integer id){
    	int rowAffect=0;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		rowAffect=session.delete("x.y.z.deleteUser", id);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return rowAffect;
    }
    
    public int deleteUser_bujianyi(Integer id){
    	int rowAffect=0;
    	SqlSession session=null;
    	try {
    		//获取mybatis的连接对象 获取连接的时候事务就已经开启了
    		session=MybatisUtil.getSqLSession();
    		session.selectOne("x.y.z.deleteUser", id);
    		session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}	
		}
    	return rowAffect;
    }
    
    
    
    
    
    
    
    
    
    
    
}
