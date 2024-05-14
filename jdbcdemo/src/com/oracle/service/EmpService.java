package com.oracle.service;

import java.util.List;

import com.oracle.entity.Emp;
import com.oracle.util.PageInfo;

public interface EmpService {
	/*
	 * 【Service】
	 * 主要处理：异常、日志、事务的控制 以及 相关业务逻辑的处理。。
	 */

	//查询所有emp
	public List<Emp> queryAll();
	

	/**
	 * 根据条件查询emp列表
	 * @param emp
	 * @return
	 */
	public List<Emp> search(Emp emp);
	
	/**
	 * 获取所有职位
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs();
	
	/**
	 * 分页查询
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param);
}
