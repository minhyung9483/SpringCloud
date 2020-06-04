package com.mintest.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintest.board.vo.BoardVo;

@Repository
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<BoardVo> selectAll() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public BoardVo select(int board_id) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("Board.select",board_id);
	}

	@Override
	public void insert(BoardVo board) {
		// TODO Auto-generated method stub
		sessionTemplate.insert("Board.insert",board);
	}

	@Override
	public void insert_secret(BoardVo board) {
		// TODO Auto-generated method stub
		
		sessionTemplate.insert("Board.insert_secret",board);
	}
	
	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		sessionTemplate.update("Board.delete", board_id);
	}

	@Override
	public void updateDoSecret(BoardVo board) {
		// TODO Auto-generated method stub
		sessionTemplate.update("Board.update_dosecret", board);
	}

	@Override
	public void updateUnSecret(BoardVo board) {
		// TODO Auto-generated method stub
		sessionTemplate.update("Board.update_unsecret", board);		
	}


}
