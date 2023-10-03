package com.ciq.bean;

public class ResponceBean {

	private Integer statusCode;
	private Object body;

	public ResponceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponceBean(Integer statusCode, Object body) {
		super();
		this.statusCode = statusCode;
		this.body = body;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ResponceBean [statusCode=" + statusCode + ", body=" + body + "]";
	}

}
