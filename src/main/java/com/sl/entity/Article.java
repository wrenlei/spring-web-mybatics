package com.sl.entity;

import com.core.web.response.Result;

public class Article extends Result {

	private Integer id;
	private String title;
	private String classify;
	private String content;
	
	public Article() {}
	
	public Article(String title,String classify,String content) {
		this.title = title;
		this.classify = classify;
		this.content = content;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
