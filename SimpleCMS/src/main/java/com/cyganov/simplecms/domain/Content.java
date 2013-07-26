package com.cyganov.simplecms.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 09.07.13
 * Time: 11:13
 */
@Entity
@Table(name = "content")
public class Content {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "body")
	private String body;

	public Content(String body) {
		this.body = body;
	}

	public Content() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
