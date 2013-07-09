package com.cyganov.simplecms.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 09.07.13
 * Time: 11:13
 */
public class Content {

	private Section section;
	private String body;

	public Content(Section section, String content) {
		this.section = section;
		this.body = content;
	}

	public String getContent() {
		return body;
	}

	public void setContent(String content) {
		this.body = content;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
