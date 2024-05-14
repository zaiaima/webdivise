package com.oracle.service;

import java.util.List;

import com.oracle.entity.Emp;
import com.oracle.util.PageInfo;

public interface EmpService {
	/*
	 * ��Service��
	 * ��Ҫ�����쳣����־������Ŀ��� �Լ� ���ҵ���߼��Ĵ�����
	 */

	//��ѯ����emp
	public List<Emp> queryAll();
	

	/**
	 * ����������ѯemp�б�
	 * @param emp
	 * @return
	 */
	public List<Emp> search(Emp emp);
	
	/**
	 * ��ȡ����ְλ
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs();
	
	/**
	 * ��ҳ��ѯ
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param);
}
