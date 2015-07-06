package com.khh.User.Domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.khh.security.domain.Role;

public class UserVo implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	String USER_ID;
	String USER_NAME;
	String USER_PASSWORD;
	String USER_EMAIL;
	String USER_AUTH;
	String JOIN_DATE;
	String MOD_DATE;

	private List<Role> authorities;
	private boolean accountNonExpired = true;
	private boolean acccountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	public UserVo() {
		super();
	}

	public UserVo(String uSER_ID, String uSER_NAME, String uSER_PASSWORD,
			String uSER_EMAIL, String uSER_AUTH, String jOIN_DATE,
			String mOD_DATE) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_EMAIL = uSER_EMAIL;
		USER_AUTH = uSER_AUTH;
		JOIN_DATE = jOIN_DATE;
		MOD_DATE = mOD_DATE;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.USER_PASSWORD;
	}
	
	//USER_ID
	@Override
	public String getUsername() {
		return this.USER_ID;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.acccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public boolean isAcccountNonLocked() {
		return acccountNonLocked;
	}

	public void setAcccountNonLocked(boolean acccountNonLocked) {
		this.acccountNonLocked = acccountNonLocked;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public String getUSER_AUTH() {
		return USER_AUTH;
	}

	public void setUSER_AUTH(String uSER_AUTH) {
		USER_AUTH = uSER_AUTH;
	}

	public String getJOIN_DATE() {
		return JOIN_DATE;
	}

	public void setJOIN_DATE(String jOIN_DATE) {
		JOIN_DATE = jOIN_DATE;
	}

	public String getMOD_DATE() {
		return MOD_DATE;
	}

	public void setMOD_DATE(String mOD_DATE) {
		MOD_DATE = mOD_DATE;
	}
}
