package com.chz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chz.pojo.Doctor;
import com.chz.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService dsi;

	// 医生注册
	@RequestMapping(value = "/setDoctorRegister")
	public void setDoctorRegister(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Doctor doctor) {
		System.out.println(doctor);
		doctor.setUniacid(1);
		dsi.insertDoctor(doctor);
	}

	// 判断是否存在该医生
	@RequestMapping(value = "/getDoctorEver")
	@ResponseBody
	public String getDoctorEver(HttpServletRequest request, HttpServletResponse response) {
		String openid = request.getParameter("openid");
		System.out.println(openid);
		Doctor doctor = dsi.queryDoctorByopenid(openid);
		if (doctor == null) {
			// 没有该医生记录则返回0
			return "0";
		} else {
			System.out.println(doctor.getD_checked());
			if (doctor.getD_checked()) {
				// 通过审核返回1
				return "1";
			} else {
				// 没有通过审核返回2
				return "2";
			}
		}
	}

	// 获取医生信息
	@RequestMapping(value = "/getDoctorInfo")
	@ResponseBody
	public Doctor getDoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String openid = request.getParameter("openid");
		System.out.println(openid);
		Doctor doctor = dsi.queryDoctorByopenid(openid);
		return doctor;
	}

	// 后台人员医生申请列表
	@RequestMapping(value = "/getDoctorRequest")
	public String getDoctorRequest(Model model) {
		List<Doctor> allDoctorRequest = dsi.getAllDoctorRequest();
		model.addAttribute("doctorRequestList", allDoctorRequest);
		return "doctorRequest.jsp";
	}

	// 后台人员通过医生申请
	@RequestMapping(value = "/passDoctorRequest")
	public String passDoctorRequest(String did) {
		System.out.println(did);
		dsi.doctorCheckByDid(did);
		return "/getDoctorRequest";
	}

	// 后台人员撤销医生申请
	@RequestMapping(value = "/deleteDoctorRequest")
	public String deleteDoctorRequest(String did) {
		System.out.println(did);
		dsi.deleteDoctorRequest(did);
		return "/getDoctorRequest";
	}

	// 医生信息修改
	@RequestMapping(value = "/changeDoctorInfo")
	public void changeDoctorInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody Doctor doctor) {
		System.out.println(doctor);
		dsi.updateDoctorInfo(doctor);
	}

	// 获取门诊医生，返回显示有预约名额的医生
	@RequestMapping(value = "/getDoctorByKeshi")
	@ResponseBody
	public List<Doctor> getDoctorByKeshi(HttpServletRequest request, HttpServletResponse response) {
		String kid = request.getParameter("kid");
		String cur_time = request.getParameter("cur_time");
		String cur_year = request.getParameter("cur_year");
		String cur_month = request.getParameter("cur_month");
		String cur_day = request.getParameter("cur_day");
		String date = cur_year + "-" + cur_month + "-" + cur_day;
		String time;
		if (cur_time.equals("1")) {
			time = "下午";
		} else {
			time = "上午";
		}
		System.out.println(kid);
		System.out.println(cur_time);
		System.out.println(date);
		List<Doctor> doctors = dsi.getDoctorDepartment(Integer.parseInt(kid) + 1, date, time);
		return doctors;
	}

	// 通过id获取医生信息
	@RequestMapping(value = "/getDoictorBydid")
	@ResponseBody
	public Doctor getDoictorBydid(HttpServletRequest request, HttpServletResponse response) {
		String did = request.getParameter("did");
		System.out.println(did);
		Doctor doctor = dsi.queryDoctorBydid(Integer.parseInt(did));
		return doctor;
	}

}
