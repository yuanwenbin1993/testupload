package com.tarena.entity;



public class User {
   private int id;
   private String name;
   private String password;
   private Group group;
   
public Group getGroup() {
	return group;
}
public void setGroup(Group group) {
	this.group = group;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", group=" + group + "]";
}

}
