package com.mysit.sbb.question;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.user.SiteUser;
import com.mysit.sbb.user.UserRepository;

@SpringBootTest
public class Question_Insert_Test {
	
	//
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void question_Insert_Test() {
		
		Question q = new Question();
		
		q.setSubject("JUnit 테스트에서 제목 -11 ");
		q.setContent("JUnit 테스트에서 내용 -22");
		q.setCreateDate(LocalDateTime.now());
	
		
//		Optional<SiteUser> op=
//		        userRepository.findById(1L);
		//DB의 Username을 끄집어옴
		Optional<SiteUser> op =
		        userRepository.findByusername("user9");
		
		SiteUser user = op.get();
		
		q.setAuthor(user);
		
		
		questionRepository.save(q);
	}

}
