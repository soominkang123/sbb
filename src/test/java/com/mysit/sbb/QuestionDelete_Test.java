package com.mysit.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionService;

@SpringBootTest
public class QuestionDelete_Test {
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void QuestionDelete_Test() {
		
		Question q = questionService.getQuestion(1702);
		
		questionService.questionDelete(q);
	}

}
