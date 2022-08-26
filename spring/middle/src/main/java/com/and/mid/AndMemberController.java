package com.and.mid;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.AndMemberDAO;
import member.AndMemberVO;
import member.MemberDAO;
import member.MemberVO;

@RestController
public class AndMemberController {
	@Autowired AndMemberDAO dao;
	Gson gson = new Gson();
	@RequestMapping(value =  "/andlogin" , produces = "text/html;charset=utf-8")
	public String login(String email , String pw , String social) {
		AndMemberVO vo = new AndMemberVO();
		System.out.println(social);
		if(email == null) {
			return gson.toJson(null);
		}
		vo.setEmail(email);
		vo.setPw(pw);
		
		vo = dao.login(vo , social);
		
		return gson.toJson(vo);
	}
	
	@RequestMapping(value =  "/join" , produces = "text/html;charset=utf-8")
	public String join(String vo ) {
		AndMemberVO joinInfo = new Gson().fromJson(vo, AndMemberVO.class);
		dao.join(joinInfo);
		return gson.toJson(vo);
	}
	
}
