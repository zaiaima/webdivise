package com.oracle.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Emp;
import com.oracle.util.PageInfo;

public interface EmpDao {
	//��ѯ����emp
	public List<Emp> queryAll() throws Exception;

	/**
	 * ��ѯ��ҳ����
	 * @param pageInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param) throws Exception;
	
	/**
	 * ����ɸѡ��ѯ
	 * @param emp ɸѡ����
	 * @return �б�
	 * @throws Exception
	 */
	public List<Emp> queryByCondition(Emp emp) throws Exception;
	
	/**
	 * ��ȡ����ְλ
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs() throws Exception;
}
