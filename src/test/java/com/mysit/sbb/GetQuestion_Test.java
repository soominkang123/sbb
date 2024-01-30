package com.mysit.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionService;

@SpringBootTest
public class GetQuestion_Test {

	@Autowired
	private QuestionService questionService;
	
	@Test
	public void GetQuestion_Test() {
		
		Question q=
		  questionService.getQuestion(1604);
		
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
	}
}
