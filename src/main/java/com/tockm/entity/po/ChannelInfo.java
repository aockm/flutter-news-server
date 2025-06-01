package com.tockm.entity.po;

import java.io.Serializable;


/**
 *@Description: 
 *@date: 2025/05/31
 */
public class ChannelInfo implements Serializable {
	private Integer id;

	private String code;

	private String channel;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return this.code;
	}

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return this.channel;
	}

	@Override
	public String toString() {
		return "id:"+(id== null?"空" : id)+",code:"+(code== null?"空" : code)+",channel:"+(channel== null?"空" : channel);
	}
}