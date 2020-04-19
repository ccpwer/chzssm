package com.chz.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chz.pojo.Test;
import com.chz.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService tsi;
	
	@RequestMapping(value="/test")
	public String test(Model model) {
		List<Test> querytest = tsi.querytest();
		model.addAttribute("itemList", querytest);
		return "/WEB-INF/jsp/itemList.jsp";
	}
	
	@RequestMapping(value="/logintest")
	public String logintest(Model model) {
		return "/login.jsp";
	}
	
	@RequestMapping(value="/websockettest")
	public String websockettest(Model model) {
		
		return "/WEB-INF/jsp/websocket.jsp";
	}
	
	@RequestMapping("/updateItem")
	@ResponseBody
	public String updateItemById(MultipartFile pictureFile) throws Exception {
		// ͼƬ�ϴ�
		// ����ͼƬ���ƣ������ظ�������ʹ��uuid
		System.out.println("ͼƬ"+pictureFile);
		String picName = UUID.randomUUID().toString();

		// ��ȡ�ļ���
		String oriName = pictureFile.getOriginalFilename();
		// ��ȡͼƬ��׺
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// ��ʼ�ϴ�
		pictureFile.transferTo(new File("G:/Xiandiao/image/chz/" + picName + extName));


		return "http://192.168.2.115:8080/pic/image/chz/"+picName + extName;
	}

}
