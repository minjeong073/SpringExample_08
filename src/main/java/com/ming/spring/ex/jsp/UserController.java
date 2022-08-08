package com.ming.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.spring.ex.jsp.bo.UserBO;
import com.ming.spring.ex.jsp.model.User;

// User import 하는 페이지

@Controller
@RequestMapping("/jsp/user")
public class UserController {

	@Autowired
	private UserBO userBO;
	
	// new user 데이터 저장
	// 이름, 생년월일, 자기소개, 이메일
	// @RequestMapping(path="/add", method = RequestMethod.POST)
	@PostMapping("/add")
	@ResponseBody
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthDay
			, @RequestParam("introduce") String introduce
			, @RequestParam("email") String email
			) {
		
		int count = userBO.addUser(name, birthDay, introduce, email);
		
		return "삽입 결과 : " + count;
		
	}
	
	// jsp 경로 리턴
	// @RequestMapping("/input")
	@GetMapping("/input")
	public String userInput() {
		return "jsp/userInput";
	}
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	// select query 로 가져옴
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		return userBO.getUser();
	}

	@RequestMapping("/getUserView")
	public String getUserView(Model model) {
		User newUser = userBO.getUser();
		model.addAttribute("user", newUser);
		
		return "jsp/userGet";
	}
}
