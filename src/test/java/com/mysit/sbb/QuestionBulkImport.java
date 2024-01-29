package com.mysit.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionRepository;

@SpringBootTest
public class QuestionBulkImport {
	
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Test
	void bulkInsert() {
		Question q = null ; 
		
		for (int i = 1 ; i <=1000 ; i++ ) {
			q = new Question();
			q.setSubject("제목 : " + i);
			q.setContent("상세내용 : " + i);
			q.setCreateDate(LocalDateTime.now());	
			questionRepository.save(q); 	
		}	
		
	}

}
