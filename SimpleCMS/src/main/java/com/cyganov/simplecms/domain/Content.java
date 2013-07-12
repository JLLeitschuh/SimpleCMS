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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Content content = (Content) o;

		if (body != null ? !body.equals(content.body) : content.body != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return body != null ? body.hashCode() : 0;
	}
}
