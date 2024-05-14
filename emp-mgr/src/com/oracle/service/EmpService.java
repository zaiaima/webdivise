package com.oracle.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import entity.Emp;

public interface EmpService {
	/*
	 * 【Service】
	 * 主要处理：异常、日志、事务的控制 以及 相关业务逻辑的处理。。
	 */

	//查询所有emp
	public List<Emp> getAll();
	

	/**
	 * 根据条件查询emp列表
	 * @param emp
	 * @return
	 */
	public PageInfo<Emp> empsearch(int PageNum,int PageSize,Emp param);
	
	/**
	 * 获取所有职位
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs();

	
	public int add(Emp emp);
	
	/**
	 * 分页查询
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<Emp> getPage(int PageNum,int PageSize);

	public int delemp(int empno);
	public int updateemp(Emp emp);
}
