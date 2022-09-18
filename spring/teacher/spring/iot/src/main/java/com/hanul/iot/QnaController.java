package com.hanul.iot;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberServiceImpl;
import qna.QnaAnswerVO;
import qna.QnaPageVO;
import qna.QnaServiceImpl;
import qna.QnaVO;

@Controller
public class QnaController {
	
	private void file_delete(String filepath, HttpServletRequest request) {
		if( filepath!=null ) {
			filepath = filepath.replace( common.appName(request)
									, "d://app/" + request.getContextPath() );
			File attach = new File( filepath );
			if( attach.exists() ) attach.delete();
		}
	}
	
	@RequestMapping("/delete.qna")
	public String qna_delete(int id, Model model, HttpServletRequest request) {
		QnaVO qna = service.qna_detail(id);
		
		if( service.qna_delete(id) == 1) {
			file_delete(qna.getFilepath(), request);
		}
		
		model.addAttribute("page", page);
		model.addAttribute("url", "list.qna");
		return "qna/redirect";
	}
	
	@RequestMapping("/update.qna")
	public String qna_update(QnaVO vo, Model model, HttpServletRequest request
							, MultipartFile file, String filename) {
		QnaVO qna = service.qna_detail(vo.getId());
		String filepath = qna.getFilepath();
		if( file.isEmpty() ) {
			if( !filename.isEmpty() ) {
				vo.setFilepath(filepath);
			}else {
				file_delete(filepath, request);
			}
			
		}else {
			vo.setFilepath( common.fileUpload("qna", file, request) );
			file_delete(filepath, request);
		}
		
		service.qna_update(vo);
		model.addAttribute("page", page);
		model.addAttribute("url", "detail.qna");
		model.addAttribute("id", vo.getId());
		return "qna/redirect";
	}
	
	@RequestMapping("/modify.qna")
	public String qna_modify(int id, Model model, MultipartFile file, String filename) {
		int large_id = 1;
		model.addAttribute("fields", service.qna_filed_list(large_id));
		model.addAttribute("vo", service.qna_detail(id));
		model.addAttribute("page", page);
		return "qna/modify";
	}
	
	
	@RequestMapping("/answer_update.qna")
	public String answer_update(QnaAnswerVO vo, Model model) {
		service.qna_answer_update(vo);
		model.addAttribute("url", "detail.qna");
		model.addAttribute("id", vo.getQna_id());
		model.addAttribute("page", page);
		return "qna/redirect";
	}
	@RequestMapping("/answer_insert.qna")
	public String answer_insert(QnaAnswerVO vo) {
		service.qna_answer_insert(vo);
		return "redirect:list.qna";
	}
			
	
	@RequestMapping("/download.qna")
	public void qna_download(int id, HttpServletRequest request
							, HttpServletResponse response) {
		QnaVO vo = service.qna_detail(id);
		if( vo.getFilepath()!=null )
			common.fileDownload(vo.getFilename(), vo.getFilepath(), response, request);
		
	}
	
	
	@RequestMapping("/detail.qna")
	public String qna_detail(int id, int read, Model model) {
		if( read==1 ) service.qna_read(id);
		model.addAttribute("vo", service.qna_detail(id));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		return "qna/detail";
	}
	
	@RequestMapping("/insert.qna")
	public String qna_insert(QnaVO vo, MultipartFile file, HttpServletRequest request) {
		if( ! file.isEmpty() ) {
			vo.setFilepath(common.fileUpload("qna", file, request));
		}
		service.qna_insert(vo);
		return "redirect:list.qna";
	}
	@RequestMapping("/new.qna")
	public String qna(Model model) {
		int large_id = 1;
		model.addAttribute("fields", service.qna_filed_list(large_id));
		return "qna/new";
	}
	
	@Autowired private MemberServiceImpl member;
	@Autowired private CommonService common;
	
	@RequestMapping("/list.qna")
	public String list(HttpSession session, Model model
						, @RequestParam(defaultValue = "-1") int open
						, @RequestParam(defaultValue = "0") int field
						, String search, String keyword
						, @RequestParam(defaultValue = "1") int curPage) {
/*		
//		String id = "admin", pw = "Manager";
		String id = "park2022", pw = "Park2022";
//		String id = "sim2022", pw = "Sim2022";
//		String id = "test2022", pw = "Test2022";
		String salt = member.member_salt(id);
		pw = common.getEncrypt(salt, pw);
		
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("id", id);
		user.put("pw", pw);
		session.setAttribute("loginInfo",  member.member_login(user) );
		//-------------------------------------------------------------------
*/		
		
		session.setAttribute("category", "qna");
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("open", open);
		map.put("field", field);
//		model.addAttribute("page", service.qna_list(page));
		model.addAttribute("page", service.qna_list(map));
		model.addAttribute("open", open);
		model.addAttribute("field", field);
		
		int large_id = 1;
		model.addAttribute("fields", service.qna_filed_list(large_id));
		
		return "qna/list";
	}
	
	@Autowired private QnaServiceImpl service;
	@Autowired private QnaPageVO page;
	
}
