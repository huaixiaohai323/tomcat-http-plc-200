package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.domain.Cust;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;

public class CustInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl();
		//1.获取要查询的客户id
		String id = request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Cust cust = service.findCustById(id);
		if(cust == null){
			throw new RuntimeException("找不到该客户!");
		}
		//3.将查找到的客户信息存入request域中,请求转发到updateCust.jsp页面展示
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
