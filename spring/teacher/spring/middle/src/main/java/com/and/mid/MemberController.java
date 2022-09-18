package com.and.mid;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;

@RestController
public class MemberController {
	@Autowired MemberDAO dao;
	Gson gson = new Gson();
	@RequestMapping(value =  "/login" , produces = "text/html;charset=utf-8")
	public String login(String userid , String userpw) {
		MemberVO vo = new MemberVO();
		if(userid == null || userpw==null) {
			return gson.toJson(null);
		}
		//로직 자체에서 자바코드에서 프로그램흐름을 제어함.↓
		// #{param , jdbcType=VARCHAR}
		vo.setUserid(userid);
		vo.setUserpw(userpw);
		vo = dao.login(vo);
		return gson.toJson(vo);
	}
	
}
