package com.itheima.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl0;
import com.itheima.dao.CustDaoImpl1;

public class BatchDelServlet3 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl1 custDaoImpl1 = new CustDaoImpl1();
		//1.获取所有要删除的客户id
		String [] ids = request.getParameterValues("delId");
		//2.调用Service中批量删除客户的方法
		custDaoImpl1.batchDel(ids);
		//3.转发到客户列表页面
		request.getRequestDispatcher("/servlet/ListCustServlet3").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
