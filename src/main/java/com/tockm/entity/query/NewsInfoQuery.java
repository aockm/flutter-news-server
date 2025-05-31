package com.tockm.entity.query;

import java.util.Date;


/**
 *@Description: 查询
 *@date: 2025/05/31
 */
public class NewsInfoQuery extends BaseQuery {
	private String id;

	private String idFuzzy;

	private String title;

	private String titleFuzzy;

	private String category;

	private String categoryFuzzy;

	private Integer recommend;

	private String thumbnail;

	private String thumbnailFuzzy;

	private String author;

	private String authorFuzzy;

	private Date addTime;

	private String addTimeStart;

	private String addTimeEnd;

	private String url;

	private String urlFuzzy;


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return this.category;
	}

	public void setRecommend(Integer recommend){
		this.recommend = recommend;
	}

	public Integer getRecommend(){
		return this.recommend;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return this.thumbnail;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}

	public Date getAddTime(){
		return this.addTime;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setIdFuzzy(String idFuzzy){
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy(){
		return this.idFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setCategoryFuzzy(String categoryFuzzy){
		this.categoryFuzzy = categoryFuzzy;
	}

	public String getCategoryFuzzy(){
		return this.categoryFuzzy;
	}

	public void setThumbnailFuzzy(String thumbnailFuzzy){
		this.thumbnailFuzzy = thumbnailFuzzy;
	}

	public String getThumbnailFuzzy(){
		return this.thumbnailFuzzy;
	}

	public void setAuthorFuzzy(String authorFuzzy){
		this.authorFuzzy = authorFuzzy;
	}

	public String getAuthorFuzzy(){
		return this.authorFuzzy;
	}

	public void setUrlFuzzy(String urlFuzzy){
		this.urlFuzzy = urlFuzzy;
	}

	public String getUrlFuzzy(){
		return this.urlFuzzy;
	}

}