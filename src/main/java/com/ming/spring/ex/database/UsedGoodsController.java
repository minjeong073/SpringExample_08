package com.ming.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.spring.ex.database.bo.UsedGoodsBO;
import com.ming.spring.ex.database.model.UsedGoods;

// Controller 역할 : req 전달 받아서 resp 만들어 전송하는 일

@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;

	@RequestMapping("/database/ex01")
	@ResponseBody
	public List<UsedGoods> ex01() {
		// DB 조회 -> controller 가 할 수 없기 때문에 businessLayer(BO) 에게 역할 넘김
		
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList;
	}
	
}
