package com.jd.pojo.entity;

import java.io.Serializable;

public class Result implements Serializable {

	private boolean bb;
	private String message;
	public Result(boolean success, String message) {
		super();
		this.bb = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return bb;
	}
	public void setSuccess(boolean success) {
		this.bb = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
