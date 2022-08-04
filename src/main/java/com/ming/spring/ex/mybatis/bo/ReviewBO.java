package com.ming.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.spring.ex.mybatis.dao.ReviewDAO;
import com.ming.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	// 특정 id 의 Review 얻어와서 리턴
	public Review getReview(int id) {
		Review review = reviewDAO.selectReview(id);
		return review;
	}
}
