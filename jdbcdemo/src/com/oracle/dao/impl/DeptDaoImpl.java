package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oracle.dao.DeptDao;
import com.oracle.entity.Dept;
import com.oracle.entity.Emp;
import com.oracle.util.ConnUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public Dept queryByNo(int deptNo) throws Exception {
		
		Connection conn = ConnUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from dept where deptno=?");
		ps.setInt(1, deptNo);		
		ResultSet rs = ps.executeQuery();
		Dept dept = null;
		while (rs.next()) {
			dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			
		}
		ConnUtil.close(ps, rs);
		
		return dept;
	}

}
