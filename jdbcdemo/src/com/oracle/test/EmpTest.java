package com.oracle.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oracle.dao.EmpDao;
import com.oracle.dao.impl.EmpDaoImpl;
import com.oracle.entity.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;
import com.oracle.util.PageInfo;

public class EmpTest {

	@Test
	public void testQueryAll() throws Exception {
		EmpService empService = new EmpServiceImpl();
		
		System.out.println(empService.queryAll());
		
	}
	

	@Test
	public void testQueryCondition() throws Exception {
		EmpDao empDao = new EmpDaoImpl();
		Emp emp = new Emp();
		emp.seteName("ll");
		
		System.out.println(empDao.queryByCondition(emp));
		
	}
	

	@Test
	public void testGetPage() throws Exception {
		EmpDao empDao = new EmpDaoImpl();
		PageInfo<Emp> pageInfo = new PageInfo<>();
		pageInfo.setPageCnt(4);
//		pageInfo.setCrtPage(3);
		
		Emp param = new Emp();
		param.seteName("ll");
				
		pageInfo = empDao.getPage(pageInfo, param);		
		System.out.println(pageInfo.getPageData());
		System.out.println(pageInfo.getTotalCnt());
	}

}
