package com.mysit.sbb;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	
	//Question 테이블의 CRUD 
	
	//객체를 DI (주입) : 객체를 Spring Framework에 등록
	// 객체 생성시 : A a = new A(); 
	// @Autowired  <== Test 코드에서 주로 사용 
	
	@Autowired
	private QuestionRepository questionRepository ; 
	
	
	// Insert Test 
	//@Test
	void jpaInsertTest() {
	
		Question q1 = new Question(); 
		q1.setSubject("JPA 가 무엇인가요?");
		q1.setContent("JPA 가 구체적으로 무엇인지 알고 싶어요");
		q1.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(q1); 		// DB에 저장됨 
		
		Question q2 = new Question(); 
		q2.setSubject("스프링 부트 가 무엇인가요?");
		q2.setContent("스프링 부트 가 구체적으로 무엇인지 알고 싶어요");
		q2.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(q2); 
	}
	
	//@Test
	void jpaSelectListTest() {
		
		// 모든 레코드 
		List<Question> q = this.questionRepository.findAll(); 
		
		Question q1 = q.get(0); 
		Question q2 = q.get(1); 
		System.out.println(q1.getSubject());
		System.out.println(q2.getSubject());
				
		// assertEquals (기대치, 값);     기대치 = 값    같을때 정상 
		assertEquals (2, q.size()); 
		assertEquals ("JPA 가 무엇인가요?", q1.getSubject()); 
	
	}
	
	//@Test
	void jpaSelectTest () {
		
		//question 테이블의 레코드 1개만 가져옴
		// Optional 은 null 처리를 아주 쉽게해줌 
			// isPresent() : 값이 존재하면 true
			// isEmpty () : 값이 존재하지 않으면 true		
		// select * from question where id = 1 ; 
		Optional<Question> op = questionRepository.findById(1); 
		
		if ( op.isPresent()) {
			Question q = op.get();   // Null이 아닐때 Optional 내부의 Question 객체를 끄집어냄. 
			
			System.out.println("글 내용 출력 : " + q.getContent());
			System.out.println("글 제목 출력 : " + q.getSubject());
			assertEquals ("JPA 가 무엇인가요?", q.getSubject()); 
		}
			
	}
	
	//@Test
	void jpaSelectSubject() {
		List<Question> list = questionRepository.findBySubject("JPA 가 무엇인가요?"); 

		if ( list != null) {
			Question q = list.get(0); 		
			System.out.println(q.getSubject());			
			assertEquals ("JPA 가 무엇인가요?", q.getSubject() ) ; 
		}
	}
	
	//@Test
	void jpaSelectContent() {
		
		List<Question> list = 
				questionRepository.findByContent("스프링 부트 가 구체적으로 무엇인지 알고 싶어요");
		
		if ( list != null) {
			Question q = list.get(0); 
			
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			
			assertEquals ("스프링 부트 가 구체적으로 무엇인지 알고 싶어요", q.getContent()); 
			
		}
		
	}
	
	//@Test
	void jpaSelectSubjectLike() {
		
		//select * from question where subject like '%?%'; 
		List<Question> list = 
				questionRepository.findBySubjectLike("%JPA%"); 
		
		if ( list != null) {
			Question q = list.get(0); 
			
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			
			assertEquals ("JPA 가 무엇인가요?", q.getSubject()); 
			
		}
	}
	
	// @Test
	void jpaSelectSubjectAndContent() {
		
		// select * from question where subject = "?" and content = "?" ; 
		List<Question> list = 
		questionRepository.findBySubjectAndContent("JPA 가 무엇인가요?", "JPA 가 구체적으로 무엇인지 알고 싶어요");
	
		if ( list != null) {
			Question q = list.get(0); 
			
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			
			assertEquals ("JPA 가 무엇인가요?", q.getSubject() ); 
			assertEquals ("JPA 가 구체적으로 무엇인지 알고 싶어요", q.getContent()); 
			
		}
	
	}
	
	// 데이터 수정 하기 : save() : insert, update 
	// @Test
	void jpaUpdate() {
		// 1. 기존의 레코드를 가지고 와서 setter로 수정후 save () 
	
		Optional<Question> op = 
				questionRepository.findById(1); 
		
		if (op.isPresent()) {
			Question q = op.get(); 
		
			// question 테이블의 id = 1 값을 가지고옴. 수정 
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			
			q.setSubject("수정되었습니다. - jpa");
			
			questionRepository.save(q); 		// update 
			
			assertEquals ("수정되었습니다. - jpa", q.getSubject()); 
			
		}	
	}
	
	// 데이터 입력 : save() : insert, update 
	//@Test
	void jpaInsert2 () {
		Question q = new Question () ; 
		
		q.setSubject("오늘 날씨는 ?");
		q.setContent("오늘의 구체적인 날씨는 무엇 입니까"); 
		q.setCreateDate(LocalDateTime.now()); 
		
		questionRepository.save(q); 	//insert	
	}
	
	// 테이터 삭제 : delete() 
	@Test
	void jpaDelete() {
		// delete 할 레코드(Question) 를 가져와서 , delete(Question)
		// ID = 52 
		
		Optional <Question> op = questionRepository.findById(52); 
		
		if (op.isPresent()) {
			Question q = op.get(); 
			
			questionRepository.delete(q);   //id=52 레코드 삭제 
		}	
	}
	

}
