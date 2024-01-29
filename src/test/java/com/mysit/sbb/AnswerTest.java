package com.mysit.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.answer.Answer;
import com.mysit.sbb.answer.AnswerRepository;
import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionRepository;

@SpringBootTest
public class AnswerTest {
	// Answer 테이블 CRUD 
		// Question 테이블 : 부모 , 
		// Answer 테이블 : 자식 , 참조
	
	// DI (의존성 주입) : Spring 프레임워크에서 객체를 생성해서 주입 
	
	@Autowired
	QuestionRepository questionRepository; 
	@Autowired
	AnswerRepository answerRepository; 
	
	
	//값 입력  : question 테이블의 id = 1 번에 대한 답변 3개 등록 
	// @Test
	void jpaInsert () {
		
		// 답변 테이블의 값은 질문 테이블의 ID 을 참조 해서 값을 넣습니다. 
		Optional<Question> op = 
				questionRepository.findById(1); 
		
		Question q1 = null  ;  
		if (op.isPresent()) {
			q1 = op.get(); 
		}
		// 첫번째 답변 		
		Answer a1 = new Answer(); 
		
		a1.setContent("JPA는 ORM 입니다 - SQL 쿼리를 사용하지 않고 자바의 클래스의 메소드를 사용해서 CRUD합니다");
		a1.setCreateDate(LocalDateTime.now());
		
		a1.setQuestion(q1);
		
		answerRepository.save(a1); 
		
		Answer a2 = new Answer(); 
		a2.setContent("JPA는 인터페이스 입니다. jpa 인터페이스를 구현한 구현클래스가 하이버네이트 입니다. ");
		a2.setCreateDate(LocalDateTime.now());
		a2.setQuestion(q1);
		
		answerRepository.save(a2);
		
		Answer a3 = new Answer(); 
		a3.setContent("JPA는 유지 보수를 쉽게 합니다. ");
		a3.setCreateDate(LocalDateTime.now());
		a3.setQuestion(q1);
		
		answerRepository.save(a3);
		
	}
	
	//@Test
	void jpaInsert2() {
		// 1. 답변을 저장할 질문 객체를 불러옴. 
		Optional<Question> op = 
				questionRepository.findById(2);
		
		Question q1 = null ; 
		if (op.isPresent()) {
			q1 = op.get(); 
		}
				
		Answer a1 = new Answer(); 
		a1.setContent("자바를 기반으로한 웹프레임워크 입니다.");
		a1.setCreateDate(LocalDateTime.now());
		
		a1.setQuestion(q1);
		
		answerRepository.save(a1); 
		
		Answer a2 = new Answer(); 
		a2.setContent("유지 보수를 아주 쉽게 합니다. ");
		a2.setCreateDate(LocalDateTime.now());
		
		a2.setQuestion(q1);
		
		answerRepository.save(a2); 
		
		Answer a3 = new Answer(); 
		a3.setContent("코드가 아주 간결해 집니다. ");
		a3.setCreateDate(LocalDateTime.now());
		
		a3.setQuestion(q1);
		
		answerRepository.save(a3); 	
	}
	
	// answer 테이블의 content 컬럼의 검색 : like 
	@Test
	void jpaSelectContentLike() {
		List<Answer> list = answerRepository.findByContentLike("%JPA%"); 
		
		// 콘솔에서 출력 
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i).getContent());
		}
		
		assertEquals(4, list.size()); 
	}
	
	
	

}
