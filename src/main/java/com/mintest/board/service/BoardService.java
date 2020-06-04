package com.mintest.board.service;

import java.util.List;

import com.mintest.board.vo.BoardVo;



public interface BoardService {
	public List<BoardVo> selectAll();
	public BoardVo select(int board_id);
	public void insert(BoardVo board);
	public void insert_secret(BoardVo board);
	public void delete(int board_id);
	public void updateDoSecret(BoardVo board);
	public void updateUnSecret(BoardVo board);
}
