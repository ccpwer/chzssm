package com.chz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chz.pojo.Doctor;

public interface DoctorService {

	Doctor queryDoctorByopenid(@Param("openid") String openid);

	Doctor queryDoctorBydid(@Param("did") Integer did);
	
	Integer insertDoctor(Doctor doctor);

	//��ȡȫ��ҽ������
	List<Doctor> getAllDoctorRequest();

	//����Աͨ��ҽ������
	Integer doctorCheckByDid(@Param("did") String did);

	//����Աɾ��ҽ������
	Integer deleteDoctorRequest(@Param("did") String did);
	
	//ҽ������ҽ����Ϣ
	Integer updateDoctorInfo(Doctor doctor);
	
	//��ȡ����ҽ��
	List<Doctor> getDoctorDepartment(Integer kid, String date, String time);
}
