package com.ming.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.spring.ex.mybatis.bo.ReviewBO;
import com.ming.spring.ex.mybatis.model.Review;

@Controller
@RequestMapping("mybatis")
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 특정 id 의 Review 데이터 가져오기
	@RequestMapping("/ex01")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		Review review = reviewBO.getReview(id);
		return review;
	}
	
	// +
	// 위의 축약 형태
	// @RequestParam(value="id", required = true) int id
	// -> http status = 400 (code error)
	
	// 필수 항목이 아닌 파라미터 설정
	// @RequestParam(value="id", required = false) int id
	// -> http status = 500 (server error)
	
	// required 줄 때에는 primitive type 올 수 없음 -> reference(wrapper class) type 가능
	// @RequestParam(value="id", required = false) Integer id
	
	// id 전달 안되면 default 값을 전달 -> null X
	// @RequestParam(value="id", defaultValue = 3) int id
	// @RequestParam("test") String test
	
	// String, int 등으로 잡으면 spring 이 알아서 잡아줌

	
	
	// 가게 id, 메뉴, 사용자 이름, 별점, 리뷰 내용
	@RequestMapping("/ex02")
	@ResponseBody
	public String addReview() {
		
		// 1. 각각을 parameter 로 전달
		// int count = reviewBO.addReview(4, "콤비네이션피자", "김바다", 4.5, "할인도 많이 받고 잘 먹었습니다!");
		
		
		// 2.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김민정");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다!");
		
		int count = reviewBO.addReviewByObject(review);
		
		return "삽입 결과 : " + count;
		
	}
	
	
	
}
