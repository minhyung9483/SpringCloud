package com.mintest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintest.board.dao.BoardDAO;
import com.mintest.board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVo> selectAll() {
		// TODO Auto-generated method stub
		return boardDAO.selectAll();
	}

	@Override
	public BoardVo select(int board_id) {
		// TODO Auto-generated method stub
		return boardDAO.select(board_id);
	}

	@Override
	public void insert(BoardVo board) {
		// TODO Auto-generated method stub
		boardDAO.insert(board);
	}

	@Override
	public void insert_secret(BoardVo board) {
		// TODO Auto-generated method stub
		boardDAO.insert_secret(board);
	}
	
	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		boardDAO.delete(board_id);
	}

	@Override
	public void updateDoSecret(BoardVo board) {
		// TODO Auto-generated method stub
		boardDAO.updateDoSecret(board);
	}

	@Override
	public void updateUnSecret(BoardVo board) {
		// TODO Auto-generated method stub
		boardDAO.updateUnSecret(board);		
	}



}
