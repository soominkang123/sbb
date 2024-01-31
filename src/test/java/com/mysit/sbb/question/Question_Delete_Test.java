package com.mysit.sbb.question;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Question_Delete_Test {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void question_Delete_Test() {
		
		// ID를 끄집어서 삭제
		Optional<Question> op =
		questionRepository.findById(1902);
		
		Question q= op.get();
						
		questionRepository.delete(op.get());
	}
}
