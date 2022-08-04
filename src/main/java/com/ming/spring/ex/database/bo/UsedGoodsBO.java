package com.ming.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ming.spring.ex.database.dao.UsedGoodsDAO;
import com.ming.spring.ex.database.model.UsedGoods;

// business layer 처리하는 class
// 전달 받은 데이터를 조작하거나 처리
// & 리턴 받은 데이터 조작 처리하는 과정 (= 로직)
@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	// usedGoods 테이블의 모든 행 정보 가져오는 메서드
	public List<UsedGoods> getUsedGoodsList() {
		
		// mybatis 에서 객체 형태로 전달해줘서 DAO 가 가져옴
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList(); 
		
		// BO 하는 일 : DAO 의 method 로 원하는 값 얻어옴 -> 원하는 값 controller 가 쓸 수 있도록 리턴하면 됨
		return usedGoodsList;
	}
	
	
}
