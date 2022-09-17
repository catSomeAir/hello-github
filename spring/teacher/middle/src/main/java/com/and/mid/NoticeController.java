package com.and.mid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import notice.NoticeDAO;

@RestController
public class NoticeController {
	
	@Autowired NoticeDAO dao;// new로 생성하면 DAO안에있는 어노테이션(Autowired)가 안됨.
	@RequestMapping(value =  "/test.te" , produces = "text/html;charset=utf-8")
	
	public String test2() {
		return "1";
	}
	
	
	@RequestMapping(value =  "/list.no" , produces = "text/html;charset=utf-8")
	public String test() {
		System.out.println("여기까지 옴.");
		//System.out.println(dao.getList().size());
		
		return new Gson().toJson(dao.getList());
	}
}
