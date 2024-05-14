package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.DeptDao;
import com.oracle.dao.EmpDao;
import com.oracle.dao.impl.DeptDaoImpl;
import com.oracle.dao.impl.EmpDaoImpl;
import com.oracle.entity.Dept;
import com.oracle.entity.Emp;
import com.oracle.service.EmpService;
import com.oracle.util.PageInfo;

public class EmpServiceImpl implements EmpService {
	EmpDao empDao = new EmpDaoImpl();
	DeptDao deptDao = new DeptDaoImpl();

	@Override
	public List<Emp> queryAll() {
		List<Emp> list = null;
		try {
			list = empDao.queryAll();
			Dept dept = null;
			for (Emp emp : list) {
				dept = deptDao.queryByNo(emp.getDeptNo());
				dept = dept == null ? new Dept() : dept;
				emp.setDept(dept);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Emp> search(Emp emp) {
		List<Emp> list = null;
		try {
			list = empDao.queryByCondition(emp);
			Dept dept = null;
			for (Emp e : list) {
				dept = deptDao.queryByNo(e.getDeptNo());
				dept = dept == null ? new Dept() : dept;
				e.setDept(dept);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> getJobs() {		
		List<String> list = null;
		try {
			list = empDao.getJobs();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param) {	
		try {
			pageInfo = empDao.getPage(pageInfo, param);
			Dept dept = null;
			for(Emp emp : pageInfo.getPageData()) {
				dept = deptDao.queryByNo(emp.getDeptNo());
				dept = dept == null ? new Dept() : dept;
				emp.setDept(dept);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

}
