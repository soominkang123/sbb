package com.mysit.sbb.question;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Question_Update_Test {
    
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void question_Update_Test() {
		
		Optional<Question> op =
		questionRepository.findById(1852);
		
		Question question = op.get();
		
		question.setSubject("수정된 제목 - JUnit");
		question.setContent("수정된 내용 - JUnit");
		question.setModifyDate(LocalDateTime.now());
		
		questionRepository.save(question);
	}
	
}
