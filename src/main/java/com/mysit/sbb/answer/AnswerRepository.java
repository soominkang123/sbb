package com.mysit.sbb.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	/*
	 * 
	 Repository  : DB의 테이블을 CRUD 메소드 
	 
	 	findAll(); 		<== select * from answer 
	 		List<Answer> list = answerRepository.findAll(); 
	 	findById(); 	<== select * from answer where id = ? ; 
	 		Optional<Answer> op = answerRepository.findById(1); 
	 		
	 	save(a1) : insert, update 
	 	delete(a1) : delete 
	 	
	 */
	
	// content 컬럼의 내용을 검색 : like 
	// select * from Answer where content like '%?%' ; 
	List<Answer> findByContentLike(String content); 
	
	

}
