package com.tockm.entity.po;

import java.io.Serializable;


/**
 *@Description: 
 *@date: 2025/05/28
 */
public class CategoryInfo implements Serializable {
	private Integer id;

	private Integer code;

	private String title;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setCode(Integer code){
		this.code = code;
	}

	public Integer getCode(){
		return this.code;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	@Override
	public String toString() {
		return "id:"+(id== null?"空" : id)+",code:"+(code== null?"空" : code)+",title:"+(title== null?"空" : title);
	}
}