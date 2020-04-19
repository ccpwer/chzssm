package com.chz.service;

import java.util.List;

import com.chz.pojo.YuyueOrder;

public interface YuyueOrderService {
	Boolean insertYuyueOrder(YuyueOrder yuyueOrder);

	List<YuyueOrder> queryUserYuyueOrderlist(String openid);

	List<YuyueOrder> queryUserYuyueOrderlistUnfinish(String openid);

	List<YuyueOrder> queryUserYuyueOrderlistFinish(String openid);

	YuyueOrder queryUserYuyueOrderByid(Integer id);
	
	List<YuyueOrder> queryAllYuyueOrderlist();
	
	Integer userCancelYuyue(Integer yo_id);
}
