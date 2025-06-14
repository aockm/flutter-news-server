package com.tockm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tockm.enums.DateTimePatternEnum;
import com.tockm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 *@Description: 
 *@date: 2025/05/31
 */
public class NewsInfo implements Serializable {
	private String id;

	private String title;

	private String category;

	private Integer recommend;

	private String thumbnail;

	private String author;

	@JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addTime;

	private String url;


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

	@Override
	public String toString() {
		return "id:"+(id== null?"空" : id)+",title:"+(title== null?"空" : title)+",category:"+(category== null?"空" : category)+",recommend:"+(recommend== null?"空" : recommend)+",thumbnail:"+(thumbnail== null?"空" : thumbnail)+",author:"+(author== null?"空" : author)+",addTime:"+(addTime== null?"空" : DateUtils.format(addTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+",url:"+(url== null?"空" : url);
	}
}