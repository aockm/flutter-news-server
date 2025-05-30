package com.tockm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tockm.enums.DateTimePatternEnum;
import com.tockm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 *@Description: 
 *@date: 2025/05/25
 */
public class UserInfo implements Serializable {
	private Integer userId;

	private String email;

	private String password;
	private String username;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

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

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	@Override
	public String toString() {
		return "userId:"+(userId== null?"空" : userId)+",username:"+(username== null?"空" : username)+",email:"+(email== null?"空" : email)+",password:"+(password== null?"空" : password)+",createTime:"+(createTime== null?"空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD.getPattern()));
	}
}