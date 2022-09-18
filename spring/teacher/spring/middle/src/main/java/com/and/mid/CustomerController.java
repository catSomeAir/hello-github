package com.and.mid;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import customer.CustomerDAO;
import customer.CustomerVO;

@RestController
public class CustomerController {
	@Autowired CustomerDAO dao ;
	
// 미들웨어 : 중간에서 DB에 접속을 하고 어떤 결과를 String이나 다른 데이터 형태로 return을 주기위한것
// Android => Database에 직접 접근이 안됨 , 막아놨음.
// C<- Ojdbc나 여러가지 lib를 사용할수없는 저급 언어에서 DB데이터가 필요할때.
// 공공데이터 : DB접속을 바로하는거 아님(보안) 사용자가(개발자)필요한 정보를 어떠한 키에 의해서 return해줌
// @RestController <- 응답을 주기위한 콘트롤러
// @ResponseBody <- 회원가입,로그인 등의 Ajax통신을 이용한 화면 비동기 처리를 위한 어노테이션
// 요청 , 응답 : 기본 형태 String 
// ListCollection , String Object 등 json형태를 편하게 사용하기 위한 Lib
// Gson
	
	// produces <- 응답 헤더에 contenttype과 charset을 변경 해줌.
	@RequestMapping(value =  "/list.cu" , produces = "text/html;charset=utf-8")
	public String getList(HttpServletResponse res) {
		List<CustomerVO> list = dao.customer_list();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	
	@RequestMapping(value =  "/detail.cu" , produces = "text/html;charset=utf-8")
	public String detail(int id) {
		CustomerVO vo = dao.customer_detail(id);
		Gson gson = new Gson();
		return gson.toJson(vo);
	}
	// 서버<->클라이언트(안드)
	// 통신을할때 데이터 이동을 String으로 함 
	@RequestMapping(value =  "/update.cu" , produces = "text/html;charset=utf-8")
	public String update(String data) {
		
		System.out.println(data);
		CustomerVO vo 
		= new Gson().fromJson(data, CustomerVO.class);
		//자바로 더미데이터를 강제로 만들고 테스트 해보기 
		/*
		 * CustomerVO vo = new CustomerVO(); vo.setId(63); vo.setEmail("수정함");
		 * vo.setGender("여"); vo.setPhone("00");
		 */
		
		int result = dao.update(vo);
		System.out.println(result);
		
		return "";
		
	}

	@RequestMapping(value =  "/delete.cu" , produces = "text/html;charset=utf-8")
	public void delete(int id) {// <= 파라메터로보낼때 String ?
								// 기본형 데이터타입 : String , double , int ..
								// DTO,VO 구조는 바로 파라메터로 넘길방법이 없음. => Json : key , value
		dao.delete(id);
	}




}
