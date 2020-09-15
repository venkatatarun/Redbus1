package com.dto;

public class User {
private int id;
private String name;
private String email;
private String password;
private int age;
private String phonennumber;
public User(){
	
}
public User(int id, String name, String email, String password, int age, String phonennumber) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.age = age;
	this.phonennumber = phonennumber;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhonennumber() {
	return phonennumber;
}
public void setPhonennumber(String phonennumber) {
	this.phonennumber = phonennumber;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
			+ ", phonennumber=" + phonennumber + "]";
}




}
