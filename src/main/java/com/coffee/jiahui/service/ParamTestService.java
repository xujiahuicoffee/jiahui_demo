package com.coffee.jiahui.service;

import com.coffee.jiahui.vo.StudentParam;

/**
 * 测试今天同花顺的面试问题，传参之后的对象跟之前的对象是否是同一个
 * @author xujiahui  
 * @date 2019年4月16日  下午9:18:57
 */
public interface ParamTestService {

	boolean paramTest(StudentParam param);
	
}
