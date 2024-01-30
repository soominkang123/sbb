package com.mysit.sbb;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.answer.AnswerService;
import com.mysit.sbb.user.SiteUser;
import com.mysit.sbb.user.UserRepository;
import com.mysit.sbb.user.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CreatAnswer_Test {
	
	@Autowired
	private AnswerService answerService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository; 
	
	// AnswerService 의 createAnswer(Integer id , String content, SiteUser author) 
	// answer 테이블의 값이 잘 들어가는지 테스트
	@Transactional
	@Test
	public void createAnswerTest() {
		
		// 첫 번째 인자 : id      : question 테이블의 id
		// 두 번째 인자 : content : 답변 내용
		// 세 번째 인자 : author  : SiteUser 객체가  
		Optional<SiteUser> _author = 
				userRepository.findByusername("user1") ; 
		
		SiteUser author = _author.get();		
		     
		
		answerService.creatAnswer(1605, "1605 질문에 대한 답변 입니다.", author );
	}

}
