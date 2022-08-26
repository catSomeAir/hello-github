package com.and.mid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import common.CommonService;
import member.MemberDAO;
import member.MemberVO;

@RestController
public class FileController {
	Gson gson = new Gson();
	@Autowired CommonService service;
	@RequestMapping(value =  "/file.f" , produces = "text/html;charset=utf-8")
	public String file(MultipartRequest mReq,HttpServletRequest req ) {
		//파일 여러개 전송 시 mReq.getFileMap().get("")
		
		
		MultipartFile file =mReq.getFile("file");
		if(file != null) {

			String imgpath = service.fileUpload("and", file, req);
			String server_save = "http://" + req.getLocalAddr() + ":"
					+ req.getLocalPort() + req.getContextPath() + "/resources/";
			
			System.out.println(server_save + imgpath);
		}
		return "";
	}
	
}
