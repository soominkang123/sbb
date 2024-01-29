package com.mysit.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	//상위 인터페이스의 모든 메소드가 상속 되어 내려옴
	/* JpaRepository 에서 선언된 메소드가 상속되어 내려옴 
	 
	   findAll()  : select * from question  
	   		List<Question> q = questionRepository.findAll() ; 
	   		 
	   findById(1) : select * from question where id = 1 ; 
	   		Optional<Question> op = questionRepository.findById(1) ; 
	   
	   save()     : insert,  update 
	   delete()   : delete 
	 */
	
	// 제목으로 검색 메소드 생성  : 
		//테이블의 Primary Key 컬럼외의 컬럼은 조건으로 검색할 경우 메소드를 만들어야함.  
	//select * from question where subject = "?" ;  
	List<Question> findBySubject(String subject); 
	
	
	// 내용으로 검색 
	// select * from question where content = "?" ; 
	List<Question> findByContent(String content); 
	
	//제목으로 검색 : like
	// select * from question where subject like %?% ; 
	List<Question> findBySubjectLike(String subject); 
		// List<Question> list = questionRepository.findBySubjectLike("%JPA%");
	
	
	//내용으로 검색 : like
	// select * from content where subject like %?% ; 
	List<Question> findByContentLike(String content); 
	
	//제목 과 내용으로 검색 
	//select * from question where subject = "?" and content = "?"
	List<Question> findBySubjectAndContent(String subject, String content); 
	
	// 페이징 처리 : Page <Question>  findAll(Pageable pageable)
	// Page : 페이징을 처리하기 위한 클래스 
	// Pageable : 페이징 처리하는 인터페이스 
	Page<Question> findAll(Pageable pageable); 
	
	
}
