package com.cyganov.simplecms.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 15.08.13
 * Time: 14:17
 */
@Embeddable
public class Authorities {

	@Column(name = "authority")
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
