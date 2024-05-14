package com.orcal.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import entity.Bonus;
import entity.Emp;

public interface BonusMapper {
	@Select("select * from bonus where ename = #{ename}")
	@Results(id = "bonusMap", value = {
			@Result(property = "bonemp", column = "ename", javaType = Emp.class, one = @One(select = "com.orcal.dao.EmpMapper.selectByname"))
			})
	public Bonus selectByname(String ename);
	
	@Select("select * from bonus")
	@ResultMap("bonusMap")
	public List<Bonus> selectAll();
}
