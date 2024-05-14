package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;

import entity.Emp;

/**
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();

	public EmpAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 获取参数
		String empStr = request.getParameter("empStr");
		String action=request.getParameter("action");
		
		ObjectMapper mapper = new ObjectMapper();
		Emp emp = mapper.readValue(empStr, Emp.class);
		
		System.out.println("=============="+emp);
		Map<String, String> msg=new HashMap<>();
		if ("add".equals(action)) {
			int result = empService.add(emp);
			if (result > 0) {
				msg.put("code","1");
			} else {
				msg.put("code","0");
				msg.put("resultMsg","员工编号已存在");
			}
		} else {
			int result=empService.updateemp(emp);
			if (result > 0) {
				msg.put("code","1");
			} else {
				msg.put("code","0");
				msg.put("resultMsg","员工数据有误");
			}
		}
		
		out.write(mapper.writeValueAsString(msg));

		out.close();
	}

}