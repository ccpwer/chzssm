package com.chz.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadImage {

	@RequestMapping(value = "/uploadimg")
	@ResponseBody
	public String uploadimg(MultipartFile pictureFile) throws IllegalStateException, IOException {
		// ͼƬ�ϴ�
		System.out.println(pictureFile);
		// ����ͼƬ���ƣ������ظ�������ʹ��uuid
		String picname = UUID.randomUUID().toString();
		
		// ��ȡ�ļ���
		String originalFilename = pictureFile.getOriginalFilename();
		// ��ȡͼƬ��׺
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		pictureFile.transferTo(new File("G:/Xiandiao/image/chz/" + picname + extName));

		return "http://192.168.2.115:8080/pic/image/chz/" + picname + extName;
	}
	
	@RequestMapping(value = "/uploaddoctorimg")
	@ResponseBody
	public String uploaddoctorimg(MultipartFile pictureFile) throws IllegalStateException, IOException {
		// ͼƬ�ϴ�
		System.out.println(pictureFile);
		// ����ͼƬ���ƣ������ظ�������ʹ��uuid
		String picname = UUID.randomUUID().toString();
		
		// ��ȡ�ļ���
		String originalFilename = pictureFile.getOriginalFilename();
		// ��ȡͼƬ��׺
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		pictureFile.transferTo(new File("G:/Xiandiao/image/chz/doctor/" + picname + extName));

		return "http://192.168.2.115:8080/pic/image/chz/doctor/" + picname + extName;
	}

}
