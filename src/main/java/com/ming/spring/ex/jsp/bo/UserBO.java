package com.ming.spring.ex.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.spring.ex.jsp.dao.UserDAO;
import com.ming.spring.ex.jsp.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	// new user 데이터 저장
	// 이름, 생년월일, 자기소개, 이메일
	public int addUser(String name, String birthDay, String introduce, String email) {
		return userDAO.insertUser(name, birthDay, introduce, email);
	}
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	public User getUser() {
		return userDAO.getUser();
	}
	
	
	// insert 후 새로 생성된 id(pk) 가져오기
	public int addUserByObject(User user) {
		return userDAO.insertUserByObject(user);
	}
	
}
