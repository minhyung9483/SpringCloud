package com.mintest.board.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mintest.board.vo.BoardVo;
import com.mintest.board.vo.CloudVo;



public interface CloudService {
	public List<CloudVo> selectAll(int user_id);
	public BoardVo select(int cloud_id);
	public void insert(CloudVo cloud);
	public String getSaveFileName(int i);
	public void writeFile(MultipartFile ori_file, String path, String save_file_name, String ext) throws IOException;
	public void delete(int cloud_id);
}
