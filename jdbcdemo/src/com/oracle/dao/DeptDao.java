package com.oracle.dao;

import com.oracle.entity.Dept;

public interface DeptDao {
	/**
	 * ���ݱ�Ż�ȡDept����
	 * @param deptNo
	 * @return
	 * @throws Exception
	 */
	public Dept queryByNo(int deptNo) throws Exception;
}
