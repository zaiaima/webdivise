package com.oracle.dao;

import com.oracle.entity.Dept;

public interface DeptDao {
	/**
	 * 根据编号获取Dept对象
	 * @param deptNo
	 * @return
	 * @throws Exception
	 */
	public Dept queryByNo(int deptNo) throws Exception;
}
