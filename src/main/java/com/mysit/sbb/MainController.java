package com.mysit.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller   //spring framework 에 객체화 해서 RAM에 로드 : bean(객체) 등록 
public class MainController {

	// http://localhost:8585
	@GetMapping ("/")
	public String main() {
		
		return "redirect:/question/list"; 
	}
}
