package com.ciq.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ciq.entity.Role;
import com.ciq.entity.User;

public class UserDetailsImpl implements UserDetails{
	
	private User user;
	
	

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
//		return user.getRoles().stream()
//        .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
//        .collect(Collectors.toList());
		
		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		List<Role> roles = user.getRoles();
		
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		
		return authorities;
		
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
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
		// TODO Auto-generated method stub
		return true;
	}

}
