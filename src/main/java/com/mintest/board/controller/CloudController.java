package com.mintest.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CloudController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CloudController.class);

	/* 메인 클라우드 페이지로 이동 */
	@RequestMapping(value = "/clouds", method = RequestMethod.GET)
	public String goCloud() {
		logger.info("메인 페이지로 이동");
		return "cloud/cloud";
	}
	
	
}
