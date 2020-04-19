package com.chz.service;

import java.util.List;


import com.chz.pojo.Doctor;
import com.chz.pojo.Keshi;

public interface KeshiService {

	List<Keshi> queryAllKeshi();
	
	List<Doctor> getDoctorByKid(Integer kid);
}
