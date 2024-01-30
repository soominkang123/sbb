package com.mysit.sbb;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.answer.Answer;
import com.mysit.sbb.answer.AnswerRepository;
import com.mysit.sbb.answer.AnswerService;

@SpringBootTest
public class AnswerModify_Test {
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Test
	void AnswerModify_Test() {
		
		Optional<Answer> op=
		answerRepository.findById(952);
		
		Answer answer = op.get();
		
		answerService.modify(answer, "답변 수정됨---");
	}

}
