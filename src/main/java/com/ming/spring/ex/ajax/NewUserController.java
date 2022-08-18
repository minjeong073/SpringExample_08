package com.ming.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.spring.ex.ajax.bo.NewUserBO;
import com.ming.spring.ex.jsp.model.User;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	// 정보
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = newUserBO.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "ajax/userList";
	}
	
	// 입력
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	// 입력받은 값 저장
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthDay
			, @RequestParam("email") String email) {
		int count = newUserBO.addUser(name, birthDay, email);
		
		// ajax 를 사용할 경우 data 를 담는 resp 를 만들어야 = API
		// api 만드는 쪽에서 주소값, 데이터 형태, 등등 설정 
		// 데이터 json 형태로 보내도록 설정
		
		// 입력 성공할 경우 {"result":"success"}
		// 실패할 경우 {"result":"fail"}
		// -> result 값이 success 인지, fail 인지 확인
		
		// httpmessageconverter, jacksonlibrary 가 알아서 json 으로 바꿔줌
		// -> @ResponseBody 붙여주고, 
		// return type 을 Map<String, String> 으로 바꿔 만든 map 을 return 하도록
		Map<String, String> map = new HashMap<>();
		
		if (count == 1) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		// return type : json 문자열
		// (항상 return type 은 문자열!)
		return map;
	}
	
}
