package com.cyganov.simplecms.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 09.07.13
 * Time: 11:13
 */
public class Content {

	private String body;

	public Content(String body) {
		this.body = body;
	}

	public Content() {
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
