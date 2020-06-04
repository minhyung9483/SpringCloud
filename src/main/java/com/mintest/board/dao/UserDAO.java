package com.mintest.board.dao;

import java.util.List;

import com.mintest.board.vo.UserVo;



public interface UserDAO {
	public List<UserVo> selectAll();
	public UserVo select(int user_id);
	public void insert(UserVo user);
	public void delete(int user_id);
	public void update(UserVo user);
	public UserVo login(UserVo user);
}
