package com.and.mid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import hr.HrDAO;

@RestController
public class EmpController {
	@Autowired HrDAO dao;
	// 새로 패키지를 했으면 rootContext꼭 확인.
	//@AutoWired사용할때는 어노테이션이 있는지확인.
	@RequestMapping(value =  "/test.hr" , produces = "text/html;charset=utf-8")
	public void test() {
		dao.test();
	}
	@RequestMapping(value =  "/list.hr" , produces = "text/html;charset=utf-8")
	public String list(String keyword) { 
		// String 
		return new Gson().toJson( dao.getList(keyword) );
	}

}
