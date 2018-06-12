package com.infosys.irs.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.infosys.irs.model.User;

@SuppressWarnings("serial")
public class InfyGoUserDetails implements UserDetails {
	private List<String> userRoles;
	private User user;

	public InfyGoUserDetails(List<String> userRoles, User user) {
		this.userRoles = userRoles;
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(this.userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
