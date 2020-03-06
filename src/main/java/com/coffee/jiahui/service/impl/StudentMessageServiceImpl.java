package com.coffee.jiahui.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.coffee.jiahui.domain.StudentMessage;
import com.coffee.jiahui.mapper.StudentMessageMapper;
import com.coffee.jiahui.service.StudentMessageService;
import com.coffee.jiahui.service.StudentScoreService;
import com.coffee.jiahui.util.SpringContextUtil;


@Service
public class StudentMessageServiceImpl implements StudentMessageService{
	
	@Autowired
	private StudentMessageMapper studentMessageMapper;
	
	@Autowired
	private StudentScoreService studentScoreService;
	
	@Override
//	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertStudentMessage1(String name) {

//		StudentMessage studentMessage1 = new StudentMessage();
//		studentMessage1.setName("aa");
//		studentMessage1.setAge(1);
//		studentMessageMapper.insert(studentMessage1);	
//		
//		StudentMessage studentMessage2 = new StudentMessage();
//		studentMessage2.setName("aaaaa");
//		studentMessage2.setAge(1);
//		studentMessageMapper.insert(studentMessage2);
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "aa");
		map1.put("age", "1");
		studentMessageMapper.insertStudentMessage(map1);
		
//		studentScoreService.insertStudentScore();
		SpringContextUtil.getBean(StudentMessageService.class).insertStudentMessage2("");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", name);
		map2.put("age", "1");
		studentMessageMapper.insertStudentMessage(map2);
		
		
	}

	
	@Override
	@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
	public void insertStudentMessage2(String name) {
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "bb");
		map1.put("age", "2");
		studentMessageMapper.insertStudentMessage(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", "bbbbbbbbbbbbbbbb");
		map2.put("age", "2");
		studentMessageMapper.insertStudentMessage(map2);
			
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private void insertStudentMessage3(String name) {
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "bb");
		map1.put("age", "2");
		studentMessageMapper.insertStudentMessage(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", "bbbb");
		map2.put("age", "2");
		studentMessageMapper.insertStudentMessage(map2);
		
	
		int a = 1/0;
		
	}

}
