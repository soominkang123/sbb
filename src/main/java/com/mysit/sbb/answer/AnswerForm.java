package com.mysit.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerForm {
	
	@NotEmpty(message= "답변은 필수 사항 입니다. - 빈 값을 넣지 마세요")
	private String content; 
	

}
