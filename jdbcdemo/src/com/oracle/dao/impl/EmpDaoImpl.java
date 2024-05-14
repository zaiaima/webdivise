package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.dao.EmpDao;
import com.oracle.entity.Emp;
import com.oracle.util.ConnUtil;
import com.oracle.util.PageInfo;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> queryAll() throws Exception {
		List<Emp> empList = new ArrayList<>();
		
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from emp");
		ResultSet rs = ps.executeQuery();
		Emp e;
		while (rs.next()) {
			e = new Emp(rs.getInt("empno"), rs.getString("ename")
					, rs.getString("job"), rs.getInt("mgr"), rs.getDate("hiredate")
					, rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			empList.add(e);
		}
		ConnUtil.close(ps, rs);
		
		return empList;
	}

	@Override
	public List<Emp> queryByCondition(Emp emp) throws Exception {
		List<Emp> empList = new ArrayList<>();		
		Connection conn = ConnUtil.getConn();
		String sql = "select * from emp where 1=1 ";
		
		if (emp.geteName() != null && !"".equals(emp.geteName())) {
			sql += "and ename like ? ";
		}
		if (emp.getJob() != null && !"".equals(emp.getJob())) {
			sql += "and job=? ";
		}
		
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = 1;
		if (emp.geteName() != null && !"".equals(emp.geteName())) {
			ps.setString(i++, "%" + emp.geteName() + "%");
		}
		if (emp.getJob() != null && !"".equals(emp.getJob())) {
			ps.setString(i++, emp.getJob());
		}
		
		ResultSet rs = ps.executeQuery();
		Emp e;
		while (rs.next()) {
			e = new Emp(rs.getInt("empno"), rs.getString("ename")
					, rs.getString("job"), rs.getInt("mgr"), rs.getDate("hiredate")
					, rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			empList.add(e);
		}
		ConnUtil.close(ps, rs);
		
		return empList;
	}

	@Override
	public List<String> getJobs() throws Exception {
		List<String> jobs = new ArrayList<>();		
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select distinct job from emp");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			jobs.add(rs.getString("job"));
		}
		ConnUtil.close(ps, rs);		
		return jobs;
	}

	@Override
	public PageInfo<Emp> getPage(PageInfo<Emp> pageInfo, Emp param) throws Exception {
		List<Emp> empList = new ArrayList<>();		
		Connection conn = ConnUtil.getConn();
		
		String sql = "select SQL_CALC_FOUND_ROWS * from emp where 1=1 ";
		
		if (param.geteName() != null && !"".equals(param.geteName())) {
			sql += "and ename like ? ";
		}
		if (param.getJob() != null && !"".equals(param.getJob())) {
			sql += "and job=? ";
		}
		
		PreparedStatement ps = conn.prepareStatement(sql + " limit ?,?");
		int i = 1;
		if (param.geteName() != null && !"".equals(param.geteName())) {
			ps.setString(i++, "%" + param.geteName() + "%");
		}
		if (param.getJob() != null && !"".equals(param.getJob())) {
			ps.setString(i++, param.getJob());
		}		
		
		ps.setInt(i++, (pageInfo.getCrtPage() - 1) * pageInfo.getPageCnt());
		ps.setInt(i, pageInfo.getPageCnt());
		ResultSet rs = ps.executeQuery();
		Emp e;
		while (rs.next()) {
			e = new Emp(rs.getInt("empno"), rs.getString("ename")
					, rs.getString("job"), rs.getInt("mgr"), rs.getDate("hiredate")
					, rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			empList.add(e);
		}
		//获取总记录数
		ps = conn.prepareStatement("select FOUND_ROWS()");
		rs = ps.executeQuery();
		if (rs.next()) {
			pageInfo.setTotalCnt(rs.getInt(1));
		}
		pageInfo.setPageData(empList);
		
		ConnUtil.close(ps, rs);
		
		return pageInfo;
	}

}
