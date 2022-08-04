package com.ming.spring.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ming.spring.ex.database.model.UsedGoods;

// persistence layer 에서 db 연동되는 클래스
// -> spring bean 으로 만듦

// db 관련된 설정

@Repository
public interface UsedGoodsDAO {
	
	// DB 의 usedGoods 의 모든 행을 조회하는 기능
	public List<UsedGoods> selectUsedGoodsList();	// 이 리턴 타입에 맞춰서 조회됨
	
	// 해당 메서드를 실행될 코드 : xml로(class 아님)  = src/main/resources/mappers/usedGoodsMapper.xml
	
}

