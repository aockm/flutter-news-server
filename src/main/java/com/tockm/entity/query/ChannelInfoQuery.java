package com.tockm.entity.query;



/**
 *@Description: 查询
 *@date: 2025/05/31
 */
public class ChannelInfoQuery extends BaseQuery {
	private Integer id;

	private String code;

	private String codeFuzzy;

	private String channel;

	private String channelFuzzy;


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

	public void setCodeFuzzy(String codeFuzzy){
		this.codeFuzzy = codeFuzzy;
	}

	public String getCodeFuzzy(){
		return this.codeFuzzy;
	}

	public void setChannelFuzzy(String channelFuzzy){
		this.channelFuzzy = channelFuzzy;
	}

	public String getChannelFuzzy(){
		return this.channelFuzzy;
	}

}