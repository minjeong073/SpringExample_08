package com.ming.spring.ex.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ming.spring.ex.jsp.model.User;

@Repository
public interface NewUserDAO {

	public List<User> selectUserList();
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthDay") String birthDay
			, @Param("email") String email);
	
	// email 중복 확인
	// 같은 값이 없으면 0 리턴 
	public int selectCountEmail(@Param("email") String email);
}
