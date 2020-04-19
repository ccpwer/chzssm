package com.chz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chz.pojo.Doctor;

public interface DoctorMapper {
	Doctor queryDoctorByopenid(@Param("openid") String openid);
	
	Doctor queryDoctorBydid(@Param("did") Integer did);
	
	Integer insertDoctor(Doctor doctor);
	
	List<Doctor> getAllDoctorRequest();
	
	Integer doctorCheckByDid(@Param("did") String did);
	
	Integer deleteDoctorRequest(@Param("did") String did);
	
	String queryEmailBydid(@Param("did") String did);
	
	Integer updateDoctorInfo(Doctor doctor);
	
	Doctor getDoctorFromDepartment(@Param("did") Integer did, @Param("date") String date,
			@Param("time") String time);
	
	Integer initDoctorFromDepartment(@Param("did") Integer did, @Param("openid") String openid,
			@Param("date") String date, @Param("time") String time);
	
	List<Doctor> getDoctorFromDepartmentFinal(@Param("kid") Integer kid, @Param("date") String date,
			@Param("time") String time);
}
