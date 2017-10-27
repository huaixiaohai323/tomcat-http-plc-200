package com.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.dao.CustDaoImpl7;
import com.itheima.domain.Cust;

public class FindCustByCondServlet7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			CustDaoImpl7 custDaoImpl7 = new CustDaoImpl7();
			//1.获取查询条件封装到bean中
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.调用Service中条件查询客户的方法,查出符合条件的客户
			List<Cust> list = custDaoImpl7.findCustByCond(cust);
			//3.将查到的客户存入request域中带到listCust.jsp页面进行展示
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listCust7.jsp").forward(request, response);
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
