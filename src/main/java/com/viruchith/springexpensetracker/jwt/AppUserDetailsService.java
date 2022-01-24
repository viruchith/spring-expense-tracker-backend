package com.viruchith.springexpensetracker.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viruchith.springexpensetracker.repos.UserRepository;
import com.viruchith.springexpensetracker.services.UserService;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.viruchith.springexpensetracker.models.User user = userRepository.findFirstByUsername(username);
		return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
	
	
}