package com.mysit.sbb.question;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Question_Select_Test2 {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void question_Select_Test2() {
		// 모든 레코드 출력
		List<Question> list =
		  questionRepository.findAll();
		
		// for 문을 사용해서 list 의 담긴 Question 객체를 끄집어 내서 출력
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getSubject());
			System.out.println(list.get(i).getContent());
			System.out.println();
		}
		
		System.out.println("==========향상된 FOR 문 : 방 번호가 없는 경우 : Set, Map, Page===============");
		
		for (Question q : list) {
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println();
		}
		
		System.out.println("===Iterator 출력 : 순회자 , Set, Map, Page");
		
		// Iterator 선언 : 
		Iterator<Question> iterator = list.iterator();
		
		// while 문으로 출력 : iterator.hasNext() <== 다음의 값이 존재하면 true 
		//                  iterator.next() <== 다음 위치로 이동
		while (iterator.hasNext()) {
			
			Question q = iterator.next();
			
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println();
		}
		
		
	}
}
