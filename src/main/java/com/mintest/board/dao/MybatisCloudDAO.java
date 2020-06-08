package com.mintest.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintest.board.vo.BoardVo;
import com.mintest.board.vo.CloudVo;

@Repository
public class MybatisCloudDAO implements CloudDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<CloudVo> selectAll(int user_id) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("Cloud.selectAll", user_id);
	}

	@Override
	public BoardVo select(int cloud_id) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("Cloud.select", cloud_id);
	}

	@Override
	public void insert(CloudVo cloud) {
		// TODO Auto-generated method stub
		sessionTemplate.insert("Cloud.insert",cloud);
	}

	@Override
	public void delete(int cloud_id) {
		// TODO Auto-generated method stub
		sessionTemplate.update("Cloud.delete", cloud_id);
	}
	
	


}
