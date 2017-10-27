package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;
public class BatchDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl();
		//1.获取所有要删除的客户id
		String [] ids = request.getParameterValues("delId");
		//2.调用Service中批量删除客户的方法
		service.batchDel(ids);
		//3.转发到客户列表页面
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
