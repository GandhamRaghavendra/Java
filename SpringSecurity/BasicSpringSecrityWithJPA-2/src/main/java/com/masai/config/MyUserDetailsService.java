package com.masai.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Employee;
import com.masai.model.MyUserDetails;
import com.masai.repo.EmployeeRepo;

import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeRepo eRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<Employee> user = eRepo.findByUserName(username);
		
		if(user.isPresent()) {
			return new MyUserDetails(user.get());
		}
		
		throw new UsernameNotFoundException("UserName not Found");
	}


}
