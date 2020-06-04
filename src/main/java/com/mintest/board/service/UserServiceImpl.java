package com.mintest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintest.board.dao.UserDAO;
import com.mintest.board.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserDAO userDAO;

	@Override
	public List<UserVo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo select(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserVo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserVo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVo login(UserVo user) {
		// TODO Auto-generated method stub
		return userDAO.login(user);
	}

}
