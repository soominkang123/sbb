package com.mysit.sbb.question;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.internal.creation.bytebuddy.MockMethodInterceptor.ForEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Add_Record_100 {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void add_Record_100() {
				
		for (int i = 0 ;i< 100 ; i++ ) {
			Question q = new Question();
			
			q.setSubject("스프링 제목 : " + i);
			q.setContent("스프링 내용 : " + i);
			q.setCreateDate(LocalDateTime.now());
			
			questionRepository.save(q);
		}
	}
	

}
