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
import com.oracle.entity.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpJobServlet
 */
@WebServlet("/EmpJobServlet")
public class EmpJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();
       
    public EmpJobServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		//获取数据
		List<String> list = empService.getJobs();
		
		ObjectMapper mapper = new ObjectMapper();
		
		//转为 json字符串（序列化）
		String listStr = mapper.writeValueAsString(list);
		
		out.write(listStr);
		
		out.close();
	}

}
