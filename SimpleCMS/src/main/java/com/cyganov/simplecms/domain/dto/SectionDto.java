package com.cyganov.simplecms.domain.dto;

import com.cyganov.simplecms.domain.Content;
import com.google.common.collect.Iterators;

import javax.swing.tree.TreeNode;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 22.08.13
 * Time: 11:18
 */
public class SectionDto implements TreeNode {

	private String id;

	private Content content;

	private String name;

	private boolean published;

	private Date date;

	private SectionDto parent;

	private List<SectionDto> children;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SectionDto getParent() {
		return parent;
	}

	public void setParent(SectionDto parent) {
		this.parent = parent;
	}

	public List<SectionDto> getChildren() {
		return children;
	}

	public void setChildren(List<SectionDto> children) {
		this.children = children;
	}



	@Override
	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	@Override
	public Enumeration children() {
		return Iterators.asEnumeration(children.iterator());
	}


}
