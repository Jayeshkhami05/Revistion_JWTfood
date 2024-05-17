package com.Jayesh.Security_Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Jayesh.Security_Service.Repositry.Repo;
import com.Jayesh.Security_Service.entity.MyUser;

@Service
public class MyUserSerivees implements UserDetailsService{

	@Autowired
	private Repo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<MyUser> optional=repo.findByName(username);
			if(optional.isPresent()) {
				return optional.map(MyUserDetails::new).get();
			}
		return null;
	}

	public String resgiter(MyUser myUser) {
		// TODO Auto-generated method stub
		myUser.setPasscode(passwordEncoder.encode(myUser.getPasscode()));
		repo.save(myUser);
		return "User Suceesfully Resgister ........";
	}

	
}
