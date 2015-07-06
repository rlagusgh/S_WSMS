package com.khh.security.domain;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	private String USER_AUTH;
	private List<Privilege> privileges;
	
	public void setUSER_AUTH(String uSER_AUTH) {
		USER_AUTH = uSER_AUTH;
	}
	
	@Override
	public String getAuthority() {
		return this.USER_AUTH;
	}
	
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
}
