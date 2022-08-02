package com.ming.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ming.spring.ex.lifecycle.model.Person;

@RestController	// @Controller + @ResponseBody -> 모든 메서드에 @ResponseBody annotation 붙음
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	
	@RequestMapping("/3")
	public String stringResponse() {
		return "RestController test!!";
	}
	
	// 직접 만든 클래스의 객체 return
	@RequestMapping("/4")
	public Person ObjectResponse() {
		Person person = new Person();
		
		person.setName("minjeonog");
		person.setAge(25);
		
		return person;
	}
	
	// entity : http status code 포함해서 전달
	// response 는 있지만 responseEntity 라는 클래스에 전달 데이터 포함시켜서 리턴
	@RequestMapping("/5")
	public ResponseEntity<Person> entityResponse() {
		Person person = new Person();
		
		person.setName("minjeonog");
		person.setAge(25);
		
		// status code : 따로 전달하지 않을 경우 정상 - 기본 200 (OK)
		// 			   : server code 에 에러가 있는 형태 -  500 (INTERNAL_SERVER_ERROR)
		ResponseEntity<Person> entity = new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
	
	
	
}
