package com.practicas.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practicas.dao.UserDao;
import com.practicas.model.UserProfile;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/*
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
String encodedPassword = encoder.encode("UserPassword");
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.practicas.model.User u = userDao.findByEmail(username);

		List<GrantedAuthority> authorities = buildUserAuthority(u.getUserProfiles());

		return buildUserForAuthentication(u, authorities);
	}

	// Converts com.practicas.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.practicas.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserProfile> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserProfile userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getType()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
