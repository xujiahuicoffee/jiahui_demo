package com.coffee.jiahui.mapper;

import java.util.Map;

import com.coffee.jiahui.config.db.BaseMapper;
import com.coffee.jiahui.domain.ZGis;

public interface ZGisMapper extends BaseMapper<ZGis>{

	void insertData(Map<String, Object> map);
}
