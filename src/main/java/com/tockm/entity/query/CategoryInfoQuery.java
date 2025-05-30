package com.tockm.entity.query;



/**
 *@Description: 查询
 *@date: 2025/05/28
 */
public class CategoryInfoQuery extends BaseQuery {
	private Integer id;

	private Integer code;

	private String title;

	private String titleFuzzy;


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

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

}