package com.ming.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/ex02/1")	// 사용자가 접근하기 위한 주소
	// 리턴 타입은 경로이기 때문에 무조건 String
	public String ex02View() {
		
		return "lifecycle/ex02";	// 자바 내부에서 접근하기 위한 jsp 주소 
	}
	
	// 사용자가 /lifecycle/ex02/1 로 접근하게 되면 
	// return 문자열을 jsp 로 인식함 
	// -> prefix, suffix 연결해서 해당 주소로 연결
}
