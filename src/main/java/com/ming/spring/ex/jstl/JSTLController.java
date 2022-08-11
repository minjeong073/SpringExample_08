package com.ming.spring.ex.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	@GetMapping("/ex01")
	public String jstlEx01() {
		
		return "jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String jstlEx02(Model model) {
		
		model.addAttribute("weight", 85);
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("apple");
		fruitList.add("orange");
		fruitList.add("watermelon");
		fruitList.add("banana");
		
		model.addAttribute("fruitList", fruitList);
		
		
		// 1. List<Map>
		// 사용자 정보 Map
		List<Map<String, Object>> userList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		map.put("name", "김민정");
		map.put("age", 25);
		map.put("hobby", "댄스");
		
		userList.add(map);
		
		map = new HashMap<>();
		
		map.put("name", "냥냥");
		map.put("age", 2);
		map.put("hobby", "과자먹기");
		
		userList.add(map);
		
		model.addAttribute("userList", userList);
		
		
		return "jstl/ex02";
	}
}
