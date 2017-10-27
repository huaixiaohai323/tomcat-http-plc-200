package com.itheima.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl;
import com.itheima.dao.CustDaoImpl7;
import com.itheima.dao.PaigongdanDaoImpl;
import com.itheima.domain.Cust;
import com.itheima.domain.Paigongdan;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddCustServlet7 extends HttpServlet {
	String xinghao7 = null;
	String pihao7 = null;
	String xingHp7 = null;
	String workerN7 = "6666";
	String Ng7 = null;
	int ng=0;
	int zongshu;
	int i;
	String zongshu7=null;
	String id1=null;
	String id2=null;
	String id3=null;
	String id4=null;
	String Id = null;//条码缓冲区
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<String> names = new ArrayList<String>();
		Enumeration<String> em = request.getParameterNames();
		try{
			//判断产品条码是否存在,如果存在，更新，如果不存在，添加
			while(em.hasMoreElements()){
				String name = em.nextElement();
				//通过id长度判断是否是产品条码，将产品条码添加到集合中
				if(name.length()==12){
					CustDaoImpl custDaoImpl = new CustDaoImpl();
					Cust cust0 = custDaoImpl.findUserByProductid(name);
					try{
					if(cust0.getParame1p().equals("合格")){
						Id = name;
					}else{
						System.out.println("前道工序不合格");
						return;
					}
					}catch (Exception e) {
						System.out.println("条码查询不到");
						return;
					}
					if(id1==null&&Id != null){
						id1 = Id;
						System.out.println("id1yi");
						Id = null;
					}
					if(id1!=null&&id2==null&&!Id.equals(id1)&&Id != null){
						id2 = Id;
						System.out.println("id2er");
						Id = null;
					}
					if(id1!=null&&id2!=null&&id3==null&&!Id.equals(id1)&&!Id.equals(id2)&&Id != null){
						id3 = Id;
						System.out.println("id3san");
						Id = null;
					}
					if(id1!=null&&id2!=null&&id3!=null&&id4==null&&!Id.equals(id1)&&
							!Id.equals(id2)&&!Id.equals(id3)&&Id != null){
						id4 = Id;
						System.out.println("id4si");
						Id = null;
					}
					return;
				}else if(name.length()==6){//通过条码长度判断员工条码
					workerN7 = name;
					System.out.println(workerN7);
				}else if(name.equals("a")||name.equals("aa")){
					if(id1==null||id2==null||id3==null||id4==null){
						id1=null;
						id2=null;
						id3=null;
						id4=null;
						response.getWriter().write("acccccr");
						return;
					}
					response.getWriter().write("abbbbbr");
					return;
				}else if(name.length()<6){
					names.add(name);
				}
			}
			
			//1.封装数据校验数据
		    Cust cust1 = new Cust();
		    Cust cust2 = new Cust();
		    Cust cust3 = new Cust();
		    Cust cust4 = new Cust();
		    	   	
		    if(names.contains("1")){
				  cust1.setParame1p("合格");
				  cust2.setParame1p("合格");
				  cust3.setParame1p("合格");
				  cust4.setParame1p("合格");
			  } 
		    if(names.contains("0")){
				  cust1.setParame1p("不合格");
				  cust2.setParame1p("不合格");
				  cust3.setParame1p("不合格");
				  cust4.setParame1p("不合格");
				  ng=ng+4;
			  }
		 
			  /*
			   * 处理重复发来的数据，保证数据的唯一性
			   * 
			   * */
		
			  if(id1==null){
				response.getWriter().write("afffffr");
				return;
			  }

			java.util.Date utilDate=new java.util.Date();
		    SimpleDateFormat dimple = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
		    dimple.format(utilDate); 
		/*
		 * 设置参数
		 * */
			  cust1.setTime(utilDate);
			  cust1.setPihao(pihao7);
			  cust1.setXinghao(xinghao7);
			  cust2.setTime(utilDate);
			  cust2.setPihao(pihao7);
			  cust2.setXinghao(xinghao7);
			  cust3.setTime(utilDate);
			  cust3.setPihao(pihao7);
			  cust3.setXinghao(xinghao7);
			  cust4.setTime(utilDate);
			  cust4.setPihao(pihao7);
			  cust4.setXinghao(xinghao7);
			    /*
			     * 判断产品ID设置产品ID；
			     * 
			     * */
				 if(id1!=null&&id2!=null&&id3!=null&&id4!=null){
					 cust1.setProductid(id1);
					 cust2.setProductid(id2);
					 cust3.setProductid(id3);
					 cust4.setProductid(id4);
				 }
			//调用service中的方法添加产品信息
			 CustDaoImpl7 custDaoImpl7 = new CustDaoImpl7();
			 Cust cunzai1 = custDaoImpl7.findUserByProductid(id1);
			 if(cunzai1!=null){
				 custDaoImpl7.updateCust(cust1); 
				 if(cunzai1.getParame1p().equals("不合格")){
					 ng = ng - 1;
				 }
			 }else{
			     custDaoImpl7.addCust(cust1);
			     zongshu++;
			 }
			 id1 = null;
			 Cust cunzai2 = custDaoImpl7.findUserByProductid(id2);
			 if(cunzai2!=null){
				 custDaoImpl7.updateCust(cust2); 
				 if(cunzai2.getParame1p().equals("不合格")){
					 ng = ng - 1;
				 }
			 }else{
			     custDaoImpl7.addCust(cust2);
			     zongshu++;
			 }
			 id2 = null;
			 Cust cunzai3 = custDaoImpl7.findUserByProductid(id3);
			 if(cunzai3!=null){
				 custDaoImpl7.updateCust(cust3); 
				 if(cunzai3.getParame1p().equals("不合格")){
					 ng = ng - 1;
				 }
			 }else{
			     custDaoImpl7.addCust(cust3);
			     zongshu++;
			 }
			 id3 = null;
			 Cust cunzai4 = custDaoImpl7.findUserByProductid(id4);
			 if(cunzai4!=null){
				 custDaoImpl7.updateCust(cust4); 
				 if(cunzai4.getParame1p().equals("不合格")){
					 ng = ng - 1;
				 }
			 }else{
			     custDaoImpl7.addCust(cust4);
			     zongshu++;
			 }
			 id4 = null;
			//记录当前生产数量
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			pd.update7N(String.valueOf(zongshu),String.valueOf(ng));
			response.getWriter().write("afffffr");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Paigongdan paigongdan = new Paigongdan();
		try{
		BeanUtils.populate(paigongdan, request.getParameterMap());
		xinghao7 = paigongdan.getXinghao();
		pihao7 = paigongdan.getPihao();
		zongshu = 0;
		zongshu7 = paigongdan.getZongshu();
		xingHp7 = paigongdan.getXingHp();
		Ng7 = String.valueOf(ng);
		PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
		if(pd.findById()!=null){
			pd.update7(xinghao7,pihao7,zongshu7,String.valueOf(zongshu),Ng7,workerN7);
			ng = 0;
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
