package com.ming.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.spring.ex.mybatis.dao.ReviewDAO;
import com.ming.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	// ex01
	// 특정 id 의 Review 얻어와서 리턴
	public Review getReview(int id) {
		Review review = reviewDAO.selectReview(id);
		return review;
	}
	
	// ex02
	// 가게 id, 메뉴, 사용자 이름, 별점, 리뷰 내용 전달 받아서 저장
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReview(storeId, menu, userName, point, review);
	}
	
	// ex02 - 2.
	// 리뷰 정보를 객체로 전달 받아서 저장 
	public int addReviewByObject(Review review) {
		return reviewDAO.insertReviewByObject(review);
	}
	
}
