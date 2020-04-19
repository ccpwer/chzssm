package com.chz.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chz.pojo.YuyueOrder;


public interface YuyueMapper {
	Integer insertYuyueOrder(YuyueOrder yuyueOrder);
	
	Integer getDoctorNowNum(@Param("did") Integer did, @Param("date") String date,
			@Param("time") String time);
	
	Integer updateDoctorNowNum(@Param("did") Integer did, @Param("date") String date,
			@Param("time") String time);
	
	List<YuyueOrder> queryUserYuyueOrderlist(@Param("openid") String openid);
	
	List<YuyueOrder> queryUserYuyueOrderlistUnfinish(@Param("openid") String openid);
	
	List<YuyueOrder> queryUserYuyueOrderlistFinish(@Param("openid") String openid);
	
	YuyueOrder queryUserYuyueOrderByid(@Param("id") Integer id);
	
	List<YuyueOrder> queryAllYuyueOrderlist();
	
	Integer userCancelYuyue(@Param("id") Integer id);
}
