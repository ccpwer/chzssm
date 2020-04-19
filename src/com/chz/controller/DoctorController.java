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

	// ҽ��ע��
	@RequestMapping(value = "/setDoctorRegister")
	public void setDoctorRegister(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Doctor doctor) {
		System.out.println(doctor);
		doctor.setUniacid(1);
		dsi.insertDoctor(doctor);
	}

	// �ж��Ƿ���ڸ�ҽ��
	@RequestMapping(value = "/getDoctorEver")
	@ResponseBody
	public String getDoctorEver(HttpServletRequest request, HttpServletResponse response) {
		String openid = request.getParameter("openid");
		System.out.println(openid);
		Doctor doctor = dsi.queryDoctorByopenid(openid);
		if (doctor == null) {
			// û�и�ҽ����¼�򷵻�0
			return "0";
		} else {
			System.out.println(doctor.getD_checked());
			if (doctor.getD_checked()) {
				// ͨ����˷���1
				return "1";
			} else {
				// û��ͨ����˷���2
				return "2";
			}
		}
	}

	// ��ȡҽ����Ϣ
	@RequestMapping(value = "/getDoctorInfo")
	@ResponseBody
	public Doctor getDoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String openid = request.getParameter("openid");
		System.out.println(openid);
		Doctor doctor = dsi.queryDoctorByopenid(openid);
		return doctor;
	}

	// ��̨��Աҽ�������б�
	@RequestMapping(value = "/getDoctorRequest")
	public String getDoctorRequest(Model model) {
		List<Doctor> allDoctorRequest = dsi.getAllDoctorRequest();
		model.addAttribute("doctorRequestList", allDoctorRequest);
		return "doctorRequest.jsp";
	}

	// ��̨��Աͨ��ҽ������
	@RequestMapping(value = "/passDoctorRequest")
	public String passDoctorRequest(String did) {
		System.out.println(did);
		dsi.doctorCheckByDid(did);
		return "/getDoctorRequest";
	}

	// ��̨��Ա����ҽ������
	@RequestMapping(value = "/deleteDoctorRequest")
	public String deleteDoctorRequest(String did) {
		System.out.println(did);
		dsi.deleteDoctorRequest(did);
		return "/getDoctorRequest";
	}

	// ҽ����Ϣ�޸�
	@RequestMapping(value = "/changeDoctorInfo")
	public void changeDoctorInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody Doctor doctor) {
		System.out.println(doctor);
		dsi.updateDoctorInfo(doctor);
	}

	// ��ȡ����ҽ����������ʾ��ԤԼ�����ҽ��
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
			time = "����";
		} else {
			time = "����";
		}
		System.out.println(kid);
		System.out.println(cur_time);
		System.out.println(date);
		List<Doctor> doctors = dsi.getDoctorDepartment(Integer.parseInt(kid) + 1, date, time);
		return doctors;
	}

	// ͨ��id��ȡҽ����Ϣ
	@RequestMapping(value = "/getDoictorBydid")
	@ResponseBody
	public Doctor getDoictorBydid(HttpServletRequest request, HttpServletResponse response) {
		String did = request.getParameter("did");
		System.out.println(did);
		Doctor doctor = dsi.queryDoctorBydid(Integer.parseInt(did));
		return doctor;
	}

}
