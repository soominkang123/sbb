package com.mysit.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public void creatAnswer (Integer id , String content, SiteUser author) {
		
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
		
		// 추가된 항목 : 사용자 정보 컬럼을 추가함.
		answer.setAuthor(author);
		
		answerRepository.save(answer); 
	
	}

	// 답변을 수정 메소드 : Answer <== 수정할 Answer 객체가 주입되어야함. <== Controller
	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		
		// update
		answerRepository.save(answer);
	}

	
}
