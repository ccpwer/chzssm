package com.chz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chz.pojo.Doctor;
import com.chz.pojo.Keshi;
import com.chz.pojo.YuyueOrder;
import com.chz.service.KeshiService;
import com.chz.service.YuyueOrderService;

@Controller
public class DepartmentController {

	@Autowired
	private KeshiService ksi;

	@Autowired
	private YuyueOrderService yosi;

	// ��ȡ�����б�
	@RequestMapping(value = "/getKeshi")
	@ResponseBody
	public List<Keshi> getKeshi(HttpServletRequest request, HttpServletResponse response) {
		List<Keshi> queryAllKeshi = ksi.queryAllKeshi();
		return queryAllKeshi;
	}

	// ��ȡ��Ӧ���ҵ�ҽ��
	@RequestMapping(value = "/getDoctorByKid")
	@ResponseBody
	public List<Doctor> getDoctorByKid(HttpServletRequest request, HttpServletResponse response, Integer kid) {

		List<Doctor> doctorlist = ksi.getDoctorByKid(kid);
		return doctorlist;
	}

	// �ύԤԼ�ҺŶ���
	@RequestMapping(value = "/sumbitYuyueOrder")
	@ResponseBody
	public String sumbitYuyueOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestBody YuyueOrder yuyueOrder) {
		System.out.println(yuyueOrder);
		Boolean insertYuyueOrder = yosi.insertYuyueOrder(yuyueOrder);
		if (insertYuyueOrder) {
			return "{\"status\":\"1\"}";
		} else {
			return "{\"status\":\"0\"}";
		}
	}

	// �û���ȡ�ҺŶ����б�
	@RequestMapping(value = "/getUserYuyueList")
	@ResponseBody
	public List<YuyueOrder> getUserYuyueList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String openid) {
		System.out.println(openid);
		List<YuyueOrder> orderlist = yosi.queryUserYuyueOrderlist(openid);
		return orderlist;
	}

	// �û���ȡδ��ɵĹҺŶ����б�
	@RequestMapping(value = "/getUserYuyueListUnfinish")
	@ResponseBody
	public List<YuyueOrder> getUserYuyueListUnfinish(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String openid) {
		System.out.println(openid);
		List<YuyueOrder> orderlist = yosi.queryUserYuyueOrderlistUnfinish(openid);
		return orderlist;
	}

	// �û���ȡ����ɹҺŶ����б�
	@RequestMapping(value = "/getUserYuyueListFinish")
	@ResponseBody
	public List<YuyueOrder> getUserYuyueListFinish(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String openid) {
		System.out.println(openid);
		List<YuyueOrder> orderlist = yosi.queryUserYuyueOrderlistFinish(openid);
		return orderlist;
	}

	// �û�ͨ��id��ȡ�ҺŶ���
	@RequestMapping(value = "/getUserYuyueByid")
	@ResponseBody
	public YuyueOrder getUserYuyueByid(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer id) {
		System.out.println(id);
		YuyueOrder order = yosi.queryUserYuyueOrderByid(id);
		return order;
	}

	// �û�ȡ���ҺŶ���
	@RequestMapping(value = "/delYuyueOrder")
	@ResponseBody
	public void delYuyueOrder(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer yo_id) {
		System.out.println(yo_id);
		yosi.userCancelYuyue(yo_id);
	}

	// ����Ա��ȡ�ҺŶ����б�
	@RequestMapping(value = "/getYuyueList")
	public String getYuyueList(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		List<YuyueOrder> orderlist = yosi.queryAllYuyueOrderlist();
		List<Keshi> queryAllKeshi = ksi.queryAllKeshi();
		model.addAttribute("PageInfoList", orderlist);
		model.addAttribute("keshi", queryAllKeshi);
		return "allOreder.jsp";		//allOreder.jsp?pageNum=1&pageSize=3
	}

}
