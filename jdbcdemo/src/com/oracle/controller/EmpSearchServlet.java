package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.entity.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;
import com.oracle.util.PageInfo;

/**
 * Servlet implementation class EmpSearchServlet
 */
@WebServlet("/EmpSearchServlet")
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();

	public EmpSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		PageInfo<Emp> pageInfo = new PageInfo<>();
		// ��ȡ����
		String name = request.getParameter("name");
		String job = request.getParameter("job");

		// ��ǰҳ
		String pageStr = request.getParameter("page");

		if (pageStr != null && !"".equals(pageStr)) {
			pageInfo.setCrtPage(Integer.parseInt(pageStr));
		}

		Emp param = new Emp();
		param.seteName(name);
		param.setJob(job);

		// ��ȡ����
		pageInfo = empService.getPage(pageInfo, param);

		ObjectMapper mapper = new ObjectMapper();

		// תΪ json�ַ��������л���
		String listStr = mapper.writeValueAsString(pageInfo);

		out.write(listStr);

		out.close();

	}

}
