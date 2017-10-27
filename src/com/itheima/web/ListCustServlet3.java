package com.itheima.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.CustDaoImpl1;
import com.itheima.domain.Cust;

public class ListCustServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.调用中查询所有的方法,查找到所有
		CustDaoImpl1 custDaoImpl1 = new CustDaoImpl1();
		
//		List<Cust> list = custDaoImpl1.getAllCust();
//		//2.将查找到的信息存入request域,请求转发到listCust.jsp页面进行展示
//		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust3.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
