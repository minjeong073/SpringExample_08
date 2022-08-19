package com.ming.spring.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.spring.ex.ajax.dao.NewUserDAO;
import com.ming.spring.ex.jsp.model.User;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public List<User> getUserList() {
		return newUserDAO.selectUserList();
	}
	
	public int addUser(String name, String birthDay, String email) {
		return newUserDAO.insertUser(name, birthDay, email);
	}
	
	// email 중복 확인
	public boolean isDuplicateEmail(String email) {
		// DAO 는 해당 query 수행만 하고, 중복 여부 판단은 BO 가 하도록
		// count 로 개수 세서 리턴 한 값 : 0 (같은 값 없음)
		
//		int count = newUserDAO.selectCountEmail(email);
//		
//		if (count == 0) {	// 중복 안된 경우 
//			return false;
//		} else {
//			return true;
//		}
//		
		// 위의 코드 간결하게 작성
		return newUserDAO.selectCountEmail(email) != 0;
	}
}
