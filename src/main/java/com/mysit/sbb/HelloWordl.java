package com.mysit.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordl {
	
	String a; 
	
	//http://localhost:8585/hello 
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World - Spring Boot"; 
	}
	
	//http://localhost:8585/my
	@GetMapping("/my")
	@ResponseBody
	public String myPage() {
		return "첫 번재 페이지 입니다. - 수정된 내용 입니다.  "; 
	}
	
	//http://localhost:8585/abcd
	@GetMapping ("/abcd")
	@ResponseBody
	public String myPage2() {
		return "abcd 요청에 대한 답입니다. ";
	}
	
	// 요청에 대한 뷰 페이지를 크라이언트로 전송 
	// abc.html 을 전송 : templates 폴더에 존재해야함. 
	// http://localhost:8585/abc 
	@GetMapping("/abcdef")
	//@ResponseBody
	public String view() {
		
		return "abc"; 
	}
	
	//Thymeleaf 라이브러리 설치후 요청시 뷰 페이지 전송 
	// http://localhost:8585/defg
	@GetMapping("/defghijk")
	public String view2() {
		
		//클라이언트 요청에 대해서 비즈니스 로직을 처리 
		
		// 마지막 으로 view 페이지를 전송 
		return "def";
	}
	
	
}
