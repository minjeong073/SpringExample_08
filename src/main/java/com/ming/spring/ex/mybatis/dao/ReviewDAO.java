package com.ming.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ming.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {
	
	// ex01
	// 특정 id 의 Review 테이블 조회 결과 리턴
	// id 기반이기 때문에 1개 -> 객체 그 자체 리턴(List X)
	public Review selectReview(@Param("id") int id);
	
	
	// ex02
	// 가게 id, 메뉴, 사용자 이름, 별점, 리뷰 내용 전달 받아서 테이블에 insert
	public int insertReview(
			@Param("storeId") int storeId
				, @Param("menu") String menu
				, @Param("userName") String userName
				, @Param("point") double point
				, @Param("review") String review);
	
	
	// ex02 - 2.
	// 객체를 전달 받아서 리뷰 내용을 insert
	public int insertReviewByObject(Review review);
	
}
