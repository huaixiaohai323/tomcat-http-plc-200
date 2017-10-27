package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.itheima.domain.Cust;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;

public class UpdateCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl();
		try{
			//1.封装数据校验数据
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.调用Service中修改客户信息的方法
			service.updateCust(cust);
			//3.重定向到客户列表页面
			request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
