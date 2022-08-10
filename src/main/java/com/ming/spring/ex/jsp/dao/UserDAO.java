package com.ming.spring.ex.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ming.spring.ex.jsp.model.User;

@Repository
public interface UserDAO {

	// new user 데이터 쿼리로 추가
	public int insertUser(
			@Param("name") String name
			,@Param("birthDay") String birthDay
			,@Param("introduce") String introduce
			,@Param("email") String email);
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	public User getUser();
	
	// insert 후 새로 생성된 id(pk) 가져오기
	// - insert 는 return 으로 항상 int type (삽입된 행 개수)
	// -> Object 형태로 전달받아야함
	public int insertUserByObject(User user);
}
