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
import com.oracle.service.EmpService;
import com.oracle.service.impl.EmpServiceImpl;

import entity.Emp;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpService empService = new EmpServiceImpl();
	/*
	 * 
	 * ������������Ӧ�����
	 * 
	 * 
	 */
       
    public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//��ȡ����
		List<Emp> list = empService.getAll();
		
		ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		
		//תΪ json�ַ��������л���
		String listStr = mapper.writeValueAsString(list);
		
		out.write(listStr);
		
		out.close();
	}

}
