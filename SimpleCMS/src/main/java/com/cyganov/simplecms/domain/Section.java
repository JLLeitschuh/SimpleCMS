package com.cyganov.simplecms.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 09.07.13
 * Time: 11:12
 */
@Entity
@Table(name = "section")
public class Section {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@OneToOne
	@JoinColumn(name = "content_id")
	private Content content;

	@Column(name = "name")
	private String name;

	@Column(name = "published")
	private boolean published;

	@ManyToOne
	@JoinColumn(name="parent_id")
	private Section parent;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="parent_id")
	private List<Section> children;

	public Section(String id, Content content, String name, boolean published, Section parent, List<Section> children) {
		this.id = id;
		this.content = content;
		this.name = name;
		this.published = published;
		this.parent = parent;
		this.children = children;
	}

	public Section() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Section getParent() {
		return parent;
	}

	public void setParent(Section parent) {
		this.parent = parent;
	}

	public List<Section> getChildren() {
		if (children != null){
			return children;
		}
		return new ArrayList<Section>();
	}

	public void setChildren(List<Section> children) {
		this.children = children;
	}

}