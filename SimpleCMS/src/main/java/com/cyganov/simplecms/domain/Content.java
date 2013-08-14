package com.cyganov.simplecms.domain;

import org.hibernate.annotations.GenericGenerator;

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
	@Column(name = "id", length = 40)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "body", length = 255)
	private String body;

	@OneToOne
	@JoinColumn(name = "section_id")
	private Section section;

	public Content(String body) {
		this.body = body;
	}

	public Content() {
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
