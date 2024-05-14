package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String noStr = request.getParameter("empno");
		Map<String, String> msg = new HashMap<>();

		if (noStr != null && !"".equals(noStr)) {
			int empno = Integer.parseInt(noStr);
			int result = empService.delemp(empno);
			if (result > 0) {
				msg.put("code", "1");
			} else {
				msg.put("code", "0");
				msg.put("resultMsg", "此数据有误，请从试~~~~~~~~");
			}
		} else {
			msg.put("code", "0");
			msg.put("resultMsg", "员工编号有误，请从试~~~~~~~~");
		}

		out.write(new ObjectMapper().writeValueAsString(msg));

		out.close();
	}

}