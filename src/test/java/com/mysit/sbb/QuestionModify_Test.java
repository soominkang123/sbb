package com.mysit.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionService;

@SpringBootTest
public class QuestionModify_Test {

	@Autowired
	private QuestionService questionService;
	
	@Test
	void questionModify_Test() {
		
		// 1. 수정할 question 객체를 주입
		// 2. 수정할 제목
		// 3. 수정할 내용 
		Question q=
		questionService.getQuestion(1702);
		
		questionService.modify(q, "수정된제목- test", "수정된 내용 - test");
	}
}
