package com.mysit.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.answer.Answer;
import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class QuestionCRUD_Test {
	
	// Question 테이블의 CRUD 
	
	//Question 테이블을 CRUD 하는 레파지토리를 객체 주입 : @Autowired  <== Test
	//QuestionRepository questionRepository = new QuestionRepository();    <== 개발자가 객체생성
	
	@Autowired
	QuestionRepository questionRepository;
	
	// Insert 테스트 
	//@Test
	void jpaInsert() {
		
		Question q1 = new Question(); 
		
		q1.setSubject("백엔드가 무엇인가요?");
		q1.setContent("백엔드가 구체적으로 무엇인가요?");
		q1.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(q1); 	//insert 
		
	}
	
	// Update 테스트 : 기존의 레코드를 가지고 오고 setter를 통해서 수정후 저장 
	//@Test
	void jpaUpdate() {
		Optional<Question> op = 
				questionRepository.findById(102); 
		
		Question q = null ; 
		if ( op.isPresent()) {	// op 의 Question 객체를 끄집어 낼때 존재할때 (null 이아닐때) 
			 q = op.get(); 		
		}
		
		// setter를 사용해서 수정할 내용을 필드에 입력 
		q.setSubject("수정된 제목입니다" );
		
		questionRepository.save(q); 			// Update
			
	}
	
	//Delete 테스트 : delete() , delete할 레코드를 가지고 와서 
	//@Test
	void jpaDelete() {
		Optional<Question> op = 
				questionRepository.findById(102); 
		
		Question q = null ; 
		if ( op.isPresent()) {	// op 의 Question 객체를 끄집어 낼때 존재할때 (null 이 아닐때) 
			 q = op.get(); 		
		}
		
		questionRepository.delete(q);
	}
	
	//@Test
	void jpaSelect() {
		List<Question> list = 
				questionRepository.findAll(); 
		
		// for 문을 사용해서 list의 question 객체를 끄집어내서 출력 
		for ( int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i).getSubject());
		}
		
		assertEquals ( 2 , list.size()); 
		
	}
	
	// 질문에 대한 모든 답변을 가지고 오기 
	// @Transactional : Test 코드에서 세션이 끊기지 않도록 설정
	//   메소드 블락의 쿼리를 하나의 트랜잭션으로 작동 
	@Transactional
	@Test
	void jpaQuestionAnswerList() {
		Optional<Question> op = questionRepository.findById(2); 
		
		Question q = null; 
		if ( op.isPresent()) {
			q = op.get(); 
		}		
		// 1번 질문에 대한 모든 답변 리스트가 저장되어 있음. 
		List<Answer> answerList = q.getAnswerList(); 
		
		for ( int i = 0 ; i < answerList.size(); i++) {
			System.out.println(answerList.get(i).getContent());
		}	
		assertEquals ( 3, answerList.size()) ; 	
	}
	

}
