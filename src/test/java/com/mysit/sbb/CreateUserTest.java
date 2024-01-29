package com.mysit.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.user.SiteUser;
import com.mysit.sbb.user.UserService;


@SpringBootTest
public class CreateUserTest {
	
	@Autowired
	private UserService userService; 

	@Test
	public void createUser() {
		SiteUser user = 
				userService.create("user1", "1234", "aaa@aaa.com"); 
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		
	}
}
