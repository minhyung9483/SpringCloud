package com.mintest.board.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mintest.board.dao.CloudDAO;
import com.mintest.board.vo.BoardVo;
import com.mintest.board.vo.CloudVo;

@Service
public class CloudServiceImpl implements CloudService{
	@Autowired
	private CloudDAO cloudDAO;

	@Override
	public List<CloudVo> selectAll(int user_id) {
		// TODO Auto-generated method stub
		return cloudDAO.selectAll(user_id);
	}

	@Override
	public BoardVo select(int cloud_id) {
		// TODO Auto-generated method stub
		return cloudDAO.select(cloud_id);
	}

	@Override
	public void insert(CloudVo cloud) {
		// TODO Auto-generated method stub
		cloudDAO.insert(cloud);
	}
	
	// 현재 시간을 기준으로 파일 이름 생성
	@Override
	public String getSaveFileName(int i) {
		// TODO Auto-generated method stub
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += i; //이름 중복 방지
		
		return fileName;
	}

	// 파일을 실제로 write 하는 메서드
	@Override
	public void writeFile(MultipartFile ori_file, String file_path, String save_file_name, String file_ext) throws IOException {
		// TODO Auto-generated method stub
		File destdir = new File(file_path); //디렉토리 가져오기
        
        if(!destdir.exists()){
            destdir.mkdirs(); //디렉토리가 존재하지 않는다면 생성
        }

		ori_file.transferTo(new File(file_path+save_file_name+file_ext));			

	}

	@Override
	public void delete(int cloud_id) {
		// TODO Auto-generated method stub
		cloudDAO.delete(cloud_id);
	}

	



}
