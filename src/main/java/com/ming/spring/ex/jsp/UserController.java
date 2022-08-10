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
	
	// 데이터 저장하고 가져올 수 있는 model 사용
	@RequestMapping("/lastUser")
	public String lastUser(Model model) {
		User lastUser = userBO.getLastUser();
		model.addAttribute("user", lastUser);
		model.addAttribute("title", "최근 등록 사용자 정보");
		
		return "jsp/userGet";
	}

	
		
	// insert 하는 과정에서(insert 되기 전) 직접 다룰 수 없는 것 
	// : pk(primary key)
	
	// insert 후 새로 생성된 id(pk) 가져오기
	@PostMapping("/add/view")
	public String addUserView(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthDay
			, @RequestParam("introduce") String introduce
			, @RequestParam("email") String email
			, Model model
			) {
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthDay);
		user.setIntroduce(introduce);
		user.setEmail(email);
		
		int count = userBO.addUserByObject(user);
		
		model.addAttribute("user", user);

		// 전달한 결과에 대한 pk 가 객체 자체에다가 넣어짐
		return "jsp/userGet";
	}

}

