package com.core.web.response;

import java.util.List;

public class Result {

	private String code = "200";
	private String message;
	private List<Object> list;
	
	public Result() {
		
	}
	
	public Result(String message) {
		this.message = message;
	}
	
	public Result(String code,String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	
}
