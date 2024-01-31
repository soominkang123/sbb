package com.mysit.sbb.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Question_Select_Test1 {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void question_Select_Test() {
		// select : 검색 (findById(10)
		// 레코드 1개만 검색  : findById(?)
		
		Optional<Question> op=
				  questionRepository.findById(1852);
		
		Question q =op.get();
		
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		
		// 기대치 ,값 <== 일치 할때 성공
		assertEquals(1852,q.getId());
	}
}
