package com.hanul.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberVO;

@Controller
public class TestController {
	
	//로그인처리 요청
	@RequestMapping("/login_result")
	public String login(String id, String pw) {
		//아이디/비번이 일치하여 로그인 성공시
		if( id.equals("admin") && pw.equals("123") ) {
			return "redirect:/"; //redirect방식
			//return "home";//forward방식
		}else{
			//실패시
			return "redirect:login";//redirect방식
			//return "member/login";//forward방식
		}
	}
	
	//로그인화면 요청
	@RequestMapping("/login")
	public String login() {
		//응답화면 연결
		return "member/login";
	}
	
	//회원가입처리 요청:@PathVariable
	@RequestMapping("/joinPath/{name}/{g}/{email}")
	public String join(Model model, @PathVariable("g") String gender
						, @PathVariable String name
						, @PathVariable String email) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("method", "@PathVariable 방식");
		return "member/info";
	}
	
	//회원가입처리 요청:데이터객체
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("method", "데이터객체 방식");
		return "member/info";
	}
	
	//회원가입처리 요청:@RequestParam
	@RequestMapping(value="/joinParam")
	public String join(String name, Model model
						, @RequestParam String gender
						, @RequestParam("email") String mail) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", mail);
		model.addAttribute("method", "@RequestParam 방식");
		//응답화면연결
		return "member/info";
	}
	
	//회원가입처리 요청:HttpServletRequest
	@RequestMapping("/joinRequest")
	public String join(Model model, HttpServletRequest request) {
		//화면에서 입력한 정보를 HttpServletRequest 타입의 메소드로 접근.
		//info 화면에 데이터를 출력할 수 있도록 Model에 attribute로 담는다
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("method", "HttpServletRequest 방식");
		//응답화면연결
		return "member/info";
	}
	
	//회원가입화면 요청
	@RequestMapping("/member")
	public String member() {
		//응답화면연결
		return "member/join";
	}
	
	@RequestMapping("/second")
	public ModelAndView view() {
		ModelAndView model = new ModelAndView();
		String now = new SimpleDateFormat("a hh시 mm분 ss초").format(new Date());
		model.addObject("now", now);
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping("/first")
	public String view(Model model) {
		//화면에 출력할 데이터는 
		//Dynamic Web Project: HttpServletRequest 에 attribute 로 데이터를 담는다
		//                     setAttribute("명", 데이터)
		//Spring: Model 에 attribute 로 데이터를 담는다
		//                addAttribute("명", 데이터)
		String today = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		model.addAttribute("today", today);
		return "index";
	}
	
}
