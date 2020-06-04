package com.mintest.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mintest.board.service.BoardService;
import com.mintest.board.vo.BoardVo;
import com.mintest.board.vo.UserVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/* 메인 게시판 페이지로 이동 */
	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public ModelAndView selectAll() {
		logger.info("BoardList 이동");
		
		List<BoardVo> boardList = boardService.selectAll();
		ModelAndView mav = new ModelAndView("board/board");
		mav.addObject("boardList", boardList);
		
		return mav;
	}
	
	/* 게시글로 이동 */
	@RequestMapping(value = "/boards/detail", method = RequestMethod.GET)
	public ModelAndView select(int board_id) {
		logger.info("BoardDetail 이동");
		
		BoardVo board = boardService.select(board_id);
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);
		
		return mav;
	}
	
	/* 비밀번호 확인으로 이동 */
	@RequestMapping(value = "/boards/checkpwd", method = RequestMethod.GET)
	public ModelAndView checkPwd(int board_id) {
		logger.info("BoardPwd 이동");
		
		BoardVo board = boardService.select(board_id);
		ModelAndView mav = new ModelAndView("board/board_pwd");
		mav.addObject("board", board);
		
		return mav;
	}
	
	/* 게시판 등록 페이지로 이동*/
	@RequestMapping(value = "/boards/write", method = RequestMethod.GET)
	public String goBoardWrite () {
		logger.info("BoardWrite 이동");
		
		return "board/write";
	}
	
	/* 게시글 등록 */
	@RequestMapping(value = "/boards", method = RequestMethod.POST)
	public String insert(BoardVo board,int user_id) {
		logger.info("Board 등록");
		
		UserVo user = new UserVo();
		user.setUser_id(user_id);
		board.setUser(user);
		
		if(board.getSecret()==null) {
			boardService.insert(board);
		}else {
			boardService.insert_secret(board);
		}
		
		return "redirect:/boards";
	}
	
	/* 게시글 수정 */
	@RequestMapping(value = "/boards/update", method = RequestMethod.POST)
	public String update(BoardVo board) {
		logger.info("Board 수정");		
		
		if(board.getSecret()==null) {
			boardService.updateUnSecret(board);		
		}else {
			boardService.updateDoSecret(board);	
		}
		
		return "redirect:/boards";
	}
	
	/* 게시글 삭제 */
	@RequestMapping(value = "/boards/delete", method = RequestMethod.GET)
	public String delete(int board_id) {
		logger.info("Board 삭제");		
		
		boardService.delete(board_id);
		
		return "redirect:/boards";
	}
	
	
}
