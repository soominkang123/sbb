package com.mysit.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUtil {
       // CommonUtil : 빈(Bean) 객체 등록 
	      // @Controller      : 컨트롤러
	      // @Service         : 서비스
	      // @Configuration   : 설정
	      // @Componont       : 그 외 객체화
	      // @Repository      : 레파지토리 , 생략해도 됨.
	
	public String markdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
	
	
}  
