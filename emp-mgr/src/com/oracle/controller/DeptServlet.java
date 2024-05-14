package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.oracle.service.DeptService;
import com.oracle.service.impl.DeptServiceImpl;

import entity.Dept;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptService deptService = new DeptServiceImpl();
	/*
	 * 
	 * 【处理请求，响应结果】
	 * 
	 * 
	 */
       
    public DeptServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获取数据
		List<Dept> list = deptService.getAll();
		
		ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		
		//转为 json字符串（序列化）
		String listStr = mapper.writeValueAsString(list);
		
		out.write(listStr);
		
		out.close();
	}

}
