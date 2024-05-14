package com.oracle.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.service.EmpService;
import com.orcal.Util.MybatisUtil;
import com.orcal.dao.EmpMapper;

import entity.Emp;

public class EmpServiceImpl implements EmpService {


	@Override
	public List<String> getJobs() {
		List<String> jobs = null;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper Mapper = session.getMapper(EmpMapper.class);
			jobs = Mapper.selectJobsAll();
		 }
		return jobs;
	}

	@Override
	public int delemp(int empno) {
		int result = 0;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper = session.getMapper(EmpMapper.class);
			try {
				result = empMapper.delete(empno);
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 } 
		return result;
	}
	
	@Override
	public int updateemp(Emp emp) {
		int result = 0;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper = session.getMapper(EmpMapper.class);
			try {
				result = empMapper.update(emp);
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 } 
		return result;
	}

	@Override
	public PageInfo<Emp> getPage(int PageNum,int PageSize) {
		PageInfo<Emp> pageInfo=null;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper = session.getMapper(EmpMapper.class);
			try {
				pageInfo = PageHelper.startPage(PageNum, PageSize)
				.doSelectPageInfo(() -> empMapper.selectAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//
		return pageInfo;
	}


	@Override
	public PageInfo<Emp> empsearch(int PageNum, int PageSize, Emp param) {
		PageInfo<Emp> pageInfo=null;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper = session.getMapper(EmpMapper.class);
			try {
				pageInfo = PageHelper.startPage(PageNum, PageSize).doSelectPageInfo(() -> empMapper.search(param));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pageInfo;
	}

	@Override
	public int add(Emp emp) {
		int result = 0;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper empMapper = session.getMapper(EmpMapper.class);
			try {
				result = empMapper.add(emp);
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 } 
		return result;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> list = null;
		try (SqlSession session = MybatisUtil.getsession()) {
			EmpMapper Mapper = session.getMapper(EmpMapper.class);
			list = Mapper.selectAll();
		 }
		return list;
	}

}
