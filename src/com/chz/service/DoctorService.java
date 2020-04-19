package com.chz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chz.pojo.Doctor;

public interface DoctorService {

	Doctor queryDoctorByopenid(@Param("openid") String openid);

	Doctor queryDoctorBydid(@Param("did") Integer did);
	
	Integer insertDoctor(Doctor doctor);

	//获取全部医生申请
	List<Doctor> getAllDoctorRequest();

	//管理员通过医生申请
	Integer doctorCheckByDid(@Param("did") String did);

	//管理员删除医生申请
	Integer deleteDoctorRequest(@Param("did") String did);
	
	//医生更改医生信息
	Integer updateDoctorInfo(Doctor doctor);
	
	//获取门诊医生
	List<Doctor> getDoctorDepartment(Integer kid, String date, String time);
}
