package com.ming.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ming.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	// 특정 id 의 Review 테이블 조회 결과 리턴
	// id 기반이기 때문에 1개 -> 객체 그 자체 리턴(List X)
	public Review selectReview(@Param("id") int id);
	
}
