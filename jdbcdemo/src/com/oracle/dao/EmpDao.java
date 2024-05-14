package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Emp;
import com.oracle.util.PageInfo;

public interface EmpDao {
	//查询所有emp
	public List<Emp> queryAll() throws Exception;

	/**
	 * 查询分页数据
	 * @param pageInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param) throws Exception;
	
	/**
	 * 条件筛选查询
	 * @param emp 筛选条件
	 * @return 列表
	 * @throws Exception
	 */
	public List<Emp> queryByCondition(Emp emp) throws Exception;
	
	/**
	 * 获取所有职位
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs() throws Exception;
}
