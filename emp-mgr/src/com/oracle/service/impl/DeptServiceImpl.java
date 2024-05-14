package com.oracle.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.service.DeptService;
import com.orcal.Util.MybatisUtil;
import com.orcal.dao.DeptMapper;

import entity.Dept;

public class DeptServiceImpl implements DeptService {




	@Override
	public List<Dept> getAll() {
		List<Dept> list = null;
		try (SqlSession session = MybatisUtil.getsession()) {
			DeptMapper Mapper = session.getMapper(DeptMapper.class);
			list = Mapper.selectAll();
		 }
		return list;
	}


}
