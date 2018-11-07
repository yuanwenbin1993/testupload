package com.tarena.entity;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {
   private int id;
   private String name;
   private String loc;
   
   private List<User> users;
   
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
@Override
public String toString() {
	return "Group [id=" + id + ", name=" + name + ", loc=" + loc + ", users=" + users + "]";
}

   
}
