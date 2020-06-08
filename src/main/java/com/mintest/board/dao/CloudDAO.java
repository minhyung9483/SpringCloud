package com.mintest.board.dao;

import java.util.List;

import com.mintest.board.vo.BoardVo;
import com.mintest.board.vo.CloudVo;



public interface CloudDAO {
	public List<CloudVo> selectAll(int user_id);
	public BoardVo select(int cloud_id);
	public void insert(CloudVo cloud);
	public void delete(int cloud_id);

}
