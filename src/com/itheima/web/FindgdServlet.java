package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.PaigongdanDaoImpl;
import com.itheima.domain.PaigongdanS;

public class FindgdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
			response.setHeader("Refresh", "3");
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			//调用Service中条件查询的方法
			PaigongdanS ps = pd.findById();
			//将查到的客户存入request域中带到Main.jsp页面进行展示
			request.setAttribute("ps", ps);
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
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
