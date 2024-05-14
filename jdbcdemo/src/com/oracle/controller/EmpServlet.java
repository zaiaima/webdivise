package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.entity.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;
import com.oracle.util.PageInfo;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();
	/*
	 * 
	 * 【处理请求，响应结果】
	 * 
	 * 
	 */
       
    public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
//		request.setAttribute("empList", empService.queryAll());
		String pageStr = request.getParameter("page");
		PageInfo<Emp> pageInfo = new PageInfo<>();
		pageInfo.setPageCnt(4);
		if (pageStr != null && !"".equals(pageStr)) {
			pageInfo.setCrtPage(Integer.parseInt(pageStr));
		}		
		
		request.setAttribute("pageinfo", empService.getPage(pageInfo, new Emp()));
		
		//请求转发
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获取数据
		List<Emp> list = empService.queryAll();
		
		ObjectMapper mapper = new ObjectMapper();
		
		//转为 json字符串（序列化）
		String listStr = mapper.writeValueAsString(list);
		
		out.write(listStr);
		
		out.close();
	}

}
