package com.mintest.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mintest.board.service.CloudService;
import com.mintest.board.vo.CloudVo;
import com.mintest.board.vo.UserVo;

@Controller
public class CloudController {	
	@Autowired
	CloudService cloudService;
	
	private static final Logger logger = LoggerFactory.getLogger(CloudController.class);

	/* 메인 클라우드 페이지로 이동 */
	@RequestMapping(value = "/clouds", method = RequestMethod.GET)
	public ModelAndView selectAll(HttpSession session) {
		logger.info("CloudList 이동");
		UserVo user = (UserVo)session.getAttribute("user"); 
		ModelAndView mav = null;
		if(user!=null) {
			
			List<CloudVo> cloudList = cloudService.selectAll(user.getUser_id());
			mav = new ModelAndView("cloud/cloud");
			mav.addObject("cloudList", cloudList);
		}else {
			mav = new ModelAndView("redirect:reLogin");
		}
		return mav;
	}
	
	/* 사진 등록 */
	@RequestMapping(value = "/clouds", method = RequestMethod.POST)
	public String insert(HttpServletRequest req, HttpServletResponse rep,@RequestParam(required=false) List<MultipartFile> files, int user_id) {
		logger.info("Cloud 등록");
		
		String file_path = req.getSession().getServletContext().getRealPath("/resources/cloud/"+ user_id+"/"); //저장할 경로
		logger.info("저장 경로 : {}", file_path);
		
		CloudVo cloud = new CloudVo();
		UserVo user = new UserVo();
		user.setUser_id(user_id);
		cloud.setUser(user); //사용자 등록 한번만
		
		MultipartFile file = null;
		String file_name = null;
		String ori_file_name = null;
		String file_ext = null;
		String save_file_name = null;
		Long file_size = null;
		
		for(int i=0;i<files.size();i++) {
			file = files.get(i);
			file_name=file.getOriginalFilename(); //파일 이름 + ext
			ori_file_name = file_name.substring(0,file_name.lastIndexOf(".")); //기존 파일 이름
			file_ext = file_name.substring(file_name.lastIndexOf("."), file_name.length()); //확장자
			save_file_name = cloudService.getSaveFileName(i); //저장할 파일 이름
			file_size = file.getSize(); //크기
			
			//파일 클라우드에 저장
			try {
				cloudService.writeFile(file, file_path, save_file_name, file_ext);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cloud.setFile_path(file_path);
			cloud.setOri_file_name(ori_file_name);
			cloud.setFile_ext(file_ext);
			cloud.setSave_file_name(save_file_name);
			cloud.setFile_size(file_size);
			
			cloudService.insert(cloud);
		}

		return "redirect:/clouds";
	}
	
	
}
