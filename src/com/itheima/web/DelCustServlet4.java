package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl4;

public class DelCustServlet4 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl4 custDaoImpl4 = new CustDaoImpl4();
		//1.获取要删除的客户id
		String id = request.getParameter("id");
		//2.调用Servcie中根据id删除客户的方法
		custDaoImpl4.delCustByID(id);
		//3.请求转发到客户列表页面
		request.getRequestDispatcher("/servlet/ListCustServlet4").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
