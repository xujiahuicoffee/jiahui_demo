package com.coffee.jiahui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.jiahui.domain.StudentScore;
import com.coffee.jiahui.mapper.StudentScoreMapper;
import com.coffee.jiahui.service.StudentScoreService;

@Service
public class StudentScoreServiceImpl implements StudentScoreService{

	@Autowired
	private StudentScoreMapper studentScoreMapper;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertStudentScore() {
		
		StudentScore studentScore1 = new StudentScore();
		studentScore1.setChinese(90000);
		studentScore1.setEnglish(90);
		studentScoreMapper.insert(studentScore1);
		
		StudentScore studentScore2 = new StudentScore();
		studentScore2.setChinese(80);
		studentScore2.setEnglish(80);
		studentScoreMapper.insert(studentScore2);
		
		int a = 1/0;
	}

	
	
}
