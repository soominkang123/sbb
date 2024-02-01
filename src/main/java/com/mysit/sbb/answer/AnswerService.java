package com.mysit.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysit.sbb.DataNotFoundException;
import com.mysit.sbb.question.Question;
import com.mysit.sbb.question.QuestionRepository;
import com.mysit.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	//생성자를 통한 객체 주입 : @RequiredArgsConstructor
	private final AnswerRepository answerRepository; 
	private final QuestionRepository questionRepository; 
	
	// Insert , update, delete는 리턴 타입이 없다. void 
	// Select 는 리턴 : List<Answer>, Answer 
	
	// 질문 등록 : question_id, content, author  
	public Answer creatAnswer (Integer id , String content, SiteUser author) {
		
		Answer answer = new Answer(); 
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		
		Optional<Question> op = 
				questionRepository.findById(id); 
		Question  question = null ; 
		if (op.isPresent()) {
			question = op.get(); 
		}
		answer.setQuestion(question);
		
		// 추가된 항목 : 사용자 정보 컬럼을 추가함 
		answer.setAuthor(author);
		
		answerRepository.save(answer); 
		
		return answer ; 
	
	}
	
	//답변을 수정 메소드 : Answer <== 수정할 Answer 객체가 주입되어야함. <== Controller 
	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		
		//update 
		answerRepository.save(answer); 
		
	}
	
	// answer 의 ID를 input 받아서 answer 객체를 리턴 
	public Answer getAnswer(Integer id) {
		Optional<Answer> op = 
				answerRepository.findById(id); 
		
		// op 가 null아닐까 끄집어 낸다. 
		if (op.isPresent()) {		// null 아닐때 
			return op.get(); 
		}else {						// null 일때
			// 예외를 강제로 발생시킴 
			throw new DataNotFoundException("해당 내용은 Answer에 존재하지 않습니다"); 
		}	
	}
	
	//삭제 
	public void delete(Answer answer) {
		// 삭제 
		answerRepository.delete(answer);
	}
	
	// 추천을 DB에 저장 하는 로직 
	public void vote(Answer answer, SiteUser siteUser) {
		
		// answer 
		answer.getVoter().add(siteUser); 
		
		answerRepository.save(answer); 
		
	}
	
	

}