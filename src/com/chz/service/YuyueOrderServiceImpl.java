package com.chz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chz.dao.YuyueMapper;
import com.chz.pojo.YuyueOrder;

@Service
public class YuyueOrderServiceImpl implements YuyueOrderService {

	@Autowired
	private YuyueMapper yuyuemapper;
	
	@Override
	@Transactional
	public Boolean insertYuyueOrder(YuyueOrder yuyueOrder) {
		// TODO Auto-generated method stub
		Integer doctorNowNum = yuyuemapper.getDoctorNowNum(yuyueOrder.getYo_did(), 
				yuyueOrder.getYo_date(), yuyueOrder.getYo_time());
		System.out.println("怎么可能是空"+doctorNowNum);
		if(doctorNowNum<10) {
			yuyueOrder.setYo_number(String.valueOf(doctorNowNum+1));
			yuyuemapper.insertYuyueOrder(yuyueOrder);
			yuyuemapper.updateDoctorNowNum(yuyueOrder.getYo_did(), 
					yuyueOrder.getYo_date(), yuyueOrder.getYo_time());
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public List<YuyueOrder> queryUserYuyueOrderlist(String openid) {
		// TODO Auto-generated method stub
		List<YuyueOrder> orderlist = yuyuemapper.queryUserYuyueOrderlist(openid);
		return orderlist;
	}

	@Override
	public YuyueOrder queryUserYuyueOrderByid(Integer id) {
		// TODO Auto-generated method stub
		YuyueOrder userYuyueOrder = yuyuemapper.queryUserYuyueOrderByid(id);
		return userYuyueOrder;
	}

	@Override
	public List<YuyueOrder> queryUserYuyueOrderlistUnfinish(String openid) {
		// TODO Auto-generated method stub
		List<YuyueOrder> orderlist = yuyuemapper.queryUserYuyueOrderlistUnfinish(openid);
		return orderlist;
	}

	@Override
	public List<YuyueOrder> queryUserYuyueOrderlistFinish(String openid) {
		// TODO Auto-generated method stub
		List<YuyueOrder> orderlist = yuyuemapper.queryUserYuyueOrderlistFinish(openid);
		return orderlist;
	}

	@Override
	public List<YuyueOrder> queryAllYuyueOrderlist() {
		// TODO Auto-generated method stub
		List<YuyueOrder> orderlist = yuyuemapper.queryAllYuyueOrderlist();
		return orderlist;
	}

	@Override
	public Integer userCancelYuyue(Integer yo_id) {
		// TODO Auto-generated method stub
		Integer userCancelYuyue = yuyuemapper.userCancelYuyue(yo_id);
		return userCancelYuyue;
	}

}
