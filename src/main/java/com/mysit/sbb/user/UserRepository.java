package com.mysit.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	/*
	 	select : findAll(), findById()
	 	insert : save() 
	 	update : save() 
	 	delete : delete()  
	 	
	 */
	
	// 인증 처리를 위한 메소드 생성 
		// select * from Site_User where username = ? : 
	Optional<SiteUser> findByusername(String username); 
	
}
