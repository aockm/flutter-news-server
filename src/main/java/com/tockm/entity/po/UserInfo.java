package com.tockm.entity.po;

import java.io.Serializable;


/**
 *@Description: 
 *@date: 2025/05/25
 */
public class UserInfo implements Serializable {
	private Integer userId;

	private String email;

	private String password;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	@Override
	public String toString() {
		return "userId:"+(userId== null?"空" : userId)+",email:"+(email== null?"空" : email)+",password:"+(password== null?"空" : password);
	}
}