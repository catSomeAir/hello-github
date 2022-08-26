package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CommonService {
	public String fileUpload(String category, MultipartFile file, HttpServletRequest request) {
		//업로드할 물리적 위치
		// D:\Study_Spring\Workspace\.metadata\.plugins\org...er.core\tmp1\wtpwebapps\iot\resources
		//String path = request.getSession().getServletContext().getRealPath("resources");
		// d://app/iot
		String path = "d://app" + request.getContextPath(); 
		
		// upload/profile/2022/08/23
		String upload = "/upload/" + category 
					+  new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		//D:\Study_Spring\Wo....\iot\resources/upload/profile/2022/08/23
		path += upload;
		
		//해당 경로 폴더가 없으면 만든다
		File folder = new File( path );
		if( ! folder.exists() )	folder.mkdirs();
		
		//파일 업로드
		//파일명에 고유id를 붙인다
		//dafqer32-g38fgfa_abc.png
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		try {
			file.transferTo( new File(path, uuid) );
		}catch(Exception e) {}
		
		// /upload/profile/2022/08/23/dafqer32-g38fgfa_abc.png
		return upload + "/" + uuid;
	}
	
}
