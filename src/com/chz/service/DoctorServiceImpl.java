package com.chz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chz.dao.DoctorMapper;
import com.chz.pojo.Doctor;
import com.chz.util.SendEmail;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorMapper dm;
	
	@Autowired
	private KeshiService ksi;

	@Override
	public Doctor queryDoctorByopenid(String openid) {
		// TODO Auto-generated method stub
		Doctor doctor = dm.queryDoctorByopenid(openid);
		return doctor;
	}

	@Override
	public Integer insertDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		Integer insertDoctor = dm.insertDoctor(doctor);
		return insertDoctor;
	}

	@Override
	public List<Doctor> getAllDoctorRequest() {
		// TODO Auto-generated method stub
		List<Doctor> allDoctorRequest = dm.getAllDoctorRequest();
		return allDoctorRequest;
	}

	@Override
	@Transactional
	public Integer doctorCheckByDid(String did) {
		// TODO Auto-generated method stub
		String email = dm.queryEmailBydid(did);
		Integer doctorCheckByDid = dm.doctorCheckByDid(did);
		String str = "您已经通过审核";
		sendMailVerification(email, str);
		return doctorCheckByDid;
	}

	@Override
	@Transactional
	public Integer deleteDoctorRequest(String did) {
		// TODO Auto-generated method stub
		String email = dm.queryEmailBydid(did);
		Integer deleteDoctorRequest = dm.deleteDoctorRequest(did);
//		if (email != null) {
		String str = "抱歉，您的信息审核不通过，请重新完善后提交";
			sendMailVerification(email, str);
//		}
		return deleteDoctorRequest;
	}

	public void sendMailVerification(String email, String info) {
		System.out.println(email);

		if (email != null) {
			SendEmail sendEmail = new SendEmail();
			// 设置要发送的邮箱
			sendEmail.setReceiveMailAccount(email);
			// 创建10位发验证码

			
			sendEmail.setInfo(info);
			try {
				sendEmail.Send();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer updateDoctorInfo(Doctor doctor) {
		// TODO Auto-generated method stub
		Integer updateDoctorInfo = dm.updateDoctorInfo(doctor);
		return updateDoctorInfo;
	}

	@Override
	@Transactional
	public List<Doctor> getDoctorDepartment(Integer kid, String date, String time) {
		List<Doctor> doctors = ksi.getDoctorByKid(kid);
		if(doctors.size()>0) {		
			for (Doctor doctor : doctors) {
				Doctor doctorFromDepartment = dm.getDoctorFromDepartment(doctor.getDid(), date, time);
				if(doctorFromDepartment==null) {
					dm.initDoctorFromDepartment(doctor.getDid(), doctor.getOpenid(), date, time);
				}
			}
			List<Doctor> doctorsDepartment = dm.getDoctorFromDepartmentFinal(kid, date, time);
			return doctorsDepartment;
		}else {
			return null;			
		}
	}

	@Override
	public Doctor queryDoctorBydid(Integer did) {
		// TODO Auto-generated method stub
		Doctor doctor = dm.queryDoctorBydid(did);
		return doctor;
	}

}
