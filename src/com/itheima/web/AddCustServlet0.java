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
import com.itheima.dao.CustDaoImpl0;
import com.itheima.dao.PaigongdanDaoImpl;
import com.itheima.domain.Cust;
import com.itheima.domain.Paigongdan;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddCustServlet0 extends HttpServlet {
	String xinghao1 = null;
	String pihao1 = null;
	String xingHp1 = null;
	String workerN1 = "6666";
	String Ng1 = null;
	int ng=0;
	int zongshu;
	int i;
	String zongshu1=null;
	String id1=null;
	String Id = null;//条码缓冲区
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = new CustServiceImpl();
		List<String> names = new ArrayList<String>();
		Enumeration<String> em = request.getParameterNames();
		try{
			//判断产品条码是否存在,如果存在，更新，如果不存在，添加
			while(em.hasMoreElements()){
				String name = em.nextElement();
				//通过id长度判断是否是产品条码，将产品条码添加到集合中
				if(name.length()==12){
					Id = name;
					return;
				}else if(name.length()==6){//通过条码长度判断员工条码
					workerN1 = name;
					System.out.println(workerN1);
				}else if(name.equals("a")||name.equals("aa")){
					if(Id==null){
						response.getWriter().write("ar");
						return;
					}
					id1 = Id;
					Id = null;
					response.getWriter().write("abbbbb"+id1.substring(id1.length()-3, id1.length())+"r");
					return;
				}else if(name.length()<6){
					names.add(name);
				}
			}
			
			//1.封装数据校验数据
		    Cust cust = new Cust();
		   	if(names.contains("3")){
		    if((request.getParameter("3").contains("1"))){
				  cust.setParame1p("合格");
			  }else if((request.getParameter("3").contains("0"))){
				  cust.setParame1p("不合格");
				  ng++;
			  }
		    }
		    
		    //转换plc发过来的数据
		    String value2 = null;
		    if(names.contains("2")){
		    String value = request.getParameter("2");
			  Double d = Double.valueOf(value);
			  d = d-200;
			  d = Math.round(d*1000)/1000.0000;
			  value2 = d.toString();
			  }
			  /*
			   * 处理重复发来的数据，保证数据的唯一性
			   * 
			   * */

			java.util.Date utilDate=new java.util.Date();
		    SimpleDateFormat dimple = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
		    dimple.format(utilDate); 
		/*
		 * 设置参数
		 * */
		      cust.setParame1(value2);
			  cust.setTime(utilDate);
			  cust.setPihao(pihao1);
			  cust.setXinghao(xinghao1);
			  cust.setParame2(null);
			  cust.setParame2p(null);
			    /*
			     * 判断产品ID设置产品ID；
			     * 
			     * */
//				 if(id1!=null){
//					 cust.setProductid(id1);
//				 }
			  if(names.contains("A")&&id1!=null){
					 cust.setProductid(id1);
					 
				 }else{
					 return;
				 }
			  if(cust.getProductid()==null){
				  response.getWriter().write("afffffr");
				  return;
			  }
			//调用service中的方法添加产品信息
			 CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
			 Cust cunzai = custDaoImpl0.findUserByProductid(id1);
			 if(cunzai!=null){
				 custDaoImpl0.updateCust(cust); 
				 if(cunzai.getParame1p().equals("不合格")){
					 ng = ng-1;
				 }
			 }else{
			     custDaoImpl0.addCust(cust);
			     zongshu++;
			 }
			//记录当前生产数量
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			pd.update1N(String.valueOf(zongshu),String.valueOf(ng));
			id1 = null;
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
		xinghao1 = paigongdan.getXinghao();
		pihao1 = paigongdan.getPihao();
		zongshu = 0;
		zongshu1 = paigongdan.getZongshu();
		xingHp1 = paigongdan.getXingHp();
		Ng1 = String.valueOf(ng);
		PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
		if(pd.findById()!=null){
			pd.update1(xinghao1,pihao1,zongshu1,String.valueOf(zongshu),Ng1,workerN1);
			ng = 0;
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
