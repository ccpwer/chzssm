package com.chz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chz.pojo.Doctor;
import com.chz.pojo.Keshi;

public interface KeshiMapper {
	
	List<Keshi> queryAllKeshi();
	
	List<Doctor> getDoctorByKid(@Param("kid") Integer kid);

}
