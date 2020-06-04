package com.mintest.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mintest.board.service.UserService;
import com.mintest.board.vo.UserVo;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/* 초기화면 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("초기 화면");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/* 비동기 방식 현재시간 새로고침 */
	/*ajax의 한글 깨짐 현상 해결 방법 : produces = "application/text; charset=utf8" ,
	  json 이면 produces = "application/sjon; charset=utf8" */
	@ResponseBody
	@RequestMapping(value = "/curTime", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public String curTime(Locale locale) {
		logger.info("현재시간 비동기방식 새로고침");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
	}
	
	/* 로그인 페이지로 이동 */
	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public String goLogin() {
		logger.info("로그인 페이지로 이동"); 
		return "login/login";
	}
	
	/* 로그인 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(UserVo user) {
		logger.info("로그인 시도");
		ModelAndView mav = new ModelAndView();
		UserVo check = null;
		check = userService.login(user);
		if(check!=null) {
			mav.setViewName("login/doLogin");
			mav.addObject("user", check);
			logger.info("'{}'으로 접속했습니다.",check.getName());
		}else {
			mav.setViewName("error/login_error");
			logger.info("로그인 오류");
		}

		return mav;
	}
	
	/* 로그아웃 */
	@RequestMapping(value = "/doLogout", method = RequestMethod.GET)
	public String doLogout() {
		logger.info("로그아웃"); 
		return "login/doLogout";
	}
	
	/* 회원가입 페이지로 이동 */
	@RequestMapping(value = "/goSign", method = RequestMethod.GET)
	public String goSign() {
		logger.info("회원가입 페이지로 이동");
		return "login/sign";
	}
	
	/* 비밀번호 찾기 페이지로 이동 */
	@RequestMapping(value = "/goFindPwd", method = RequestMethod.GET)
	public String goFindPwd() {
		logger.info("비밀번호 찾기 페이지로 이동");
		return "login/findpwd";
	}
	
	/* 세션 만료 */
	@RequestMapping(value = "/reLogin", method = RequestMethod.GET)
	public String reLogin() {
		logger.info("세션 만료");
		return "error/session_error";
	}
	
	
}
