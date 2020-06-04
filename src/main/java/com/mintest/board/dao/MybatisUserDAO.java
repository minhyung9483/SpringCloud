package com.mintest.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintest.board.vo.UserVo;

@Repository
public class MybatisUserDAO implements UserDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate;

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
		return sessionTemplate.selectOne("User.login", user);
	}

}
