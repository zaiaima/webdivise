package com.oracle.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import entity.Emp;

public interface EmpService {
	/*
	 * ��Service��
	 * ��Ҫ�����쳣����־������Ŀ��� �Լ� ���ҵ���߼��Ĵ�����
	 */

	//��ѯ����emp
	public List<Emp> getAll();
	

	/**
	 * ����������ѯemp�б�
	 * @param emp
	 * @return
	 */
	public PageInfo<Emp> empsearch(int PageNum,int PageSize,Emp param);
	
	/**
	 * ��ȡ����ְλ
	 * @return
	 * @throws Exception
	 */
	public List<String> getJobs();

	
	public int add(Emp emp);
	
	/**
	 * ��ҳ��ѯ
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<Emp> getPage(int PageNum,int PageSize);

	public int delemp(int empno);
	public int updateemp(Emp emp);
}
