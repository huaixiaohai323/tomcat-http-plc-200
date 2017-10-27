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

public class AddCustServlet extends HttpServlet {
	String xinghao2 = null;
	String pihao2 = null;
	String xingHp2 = null;
	String workerN2 = "6666";
	String Ng2 = null;
	int i=0;
	int ng=0;
	int zongshu;
	String zongshu2=null;
	String id1=null;
	String id2=null;
	String id3=null;
	String id4=null;
	String canshu=null;//校验参数位
	String Id = null;//条码缓冲区
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	//	CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl();
		List<String> names = new ArrayList<String>();
		Enumeration<String> em = request.getParameterNames();
		try{
			//判断产品条码是否存在,如果存在，更新，如果不存在，添加
			while(em.hasMoreElements()){
				String name = em.nextElement();
				//通过id长度判断是否是产品条码，将产品条码添加到集合中
				if(name.length()==12){
					CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
					Cust cust0 = custDaoImpl0.findUserByProductid(name);
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
					return;
				}else if(name.length()==6){//通过条码长度判断员工条码
					workerN2 = name;
					System.out.println(workerN2);
				}else if(name.equals("a")||name.equals("aa")){
					if(Id==null||Id.equals(id2)||Id.equals(id3)||Id.equals(id4)){
						response.getWriter().write("ar");
						return;
					}
					id1 = Id;
					Id = null;
					response.getWriter().write("abbbbb"+id1.substring(id1.length()-3, id1.length())+"r");
					return;
				}else if(name.equals("b")||name.equals("bb")){
					if(Id==null||Id.equals(id1)||Id.equals(id3)||Id.equals(id4)){
						response.getWriter().write("ar");
						return;
					}
					id2 = Id;
					Id = null;
					response.getWriter().write("accccc"+id2.substring(id2.length()-3, id2.length())+"r");
					return;
				}else if(name.equals("c")||name.equals("cc")){
					if(Id==null||Id.equals(id2)||Id.equals(id1)||Id.equals(id4)){
						response.getWriter().write("ar");
						return;
					}
					id3 = Id;
					Id = null;
					response.getWriter().write("addddd"+id3.substring(id3.length()-3, id3.length())+"r");
					return;
				}else if(name.equals("d")||name.equals("dd")){
					if(Id==null||Id.equals(id2)||Id.equals(id3)||Id.equals(id1)){
						response.getWriter().write("ar");
						return;
					}
					id4 = Id;
					Id = null;
					response.getWriter().write("aeeeee"+id4.substring(id4.length()-3, id4.length())+"r");
					return;
				}else if(name.length()<6){
					names.add(name);
				}
			}
			
			//1.封装数据校验数据
	
		    Cust cust = new Cust();
		    if((request.getParameter("3").contains("1"))){
				  cust.setParame1p("合格");
			  }else{
				  cust.setParame1p("不合格");
				  ng++;
			  }
		    
		    //转换plc发过来的数据
		    String value2=null;
		    if(names.contains("2")){
		    value2 = request.getParameter("2");
			  Double d = Double.valueOf(value2);
			  d = d/100;
			  d = d-1;
			  d = Math.round(d*1000)/1000.000;
			   value2 = d.toString();
			  }
		    String value3=null;
		    if(names.contains("1")){
		    value3 = request.getParameter("1");
			  Double d = Double.valueOf(value3);
			  d = d/100;
			  d = d-2;
			  d = Math.round(d*1000)/1000.000;
			  if(d<0.015){
				  cust.setParame2p("合格");
			  }else{
				  cust.setParame2p("不合格");
			  }
			   value3 = d.toString();
			  }
			  /*
			   * 处理重复发来的数据，保证数据的唯一性
			   * 
			   * */
//			  if(names.contains("A")&&id1==null&&i==1){
//				response.getWriter().write("ar");
//				System.out.println("数据重复A");
//				return;
//			  }
//			  if(names.contains("B")&&id2==null&&i==2){
//					response.getWriter().write("ar");
//					System.out.println("数据重复B");
//					return;
//				  }
//			  if(names.contains("C")&&id3==null&&i==3){
//					response.getWriter().write("ar");
//					System.out.println("数据重复C");
//					return;
//				  }
//			  if(names.contains("D")&&id4==null&&i==4){
//					response.getWriter().write("ar");
//					System.out.println("数据重复D");
//					return;
//				  }
			java.util.Date utilDate=new java.util.Date();
		    SimpleDateFormat dimple = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
		    dimple.format(utilDate); 
		    /*
		     * 判断产品ID设置产品ID；
		     * 
		     * */
			 if(names.contains("A")&&id1!=null){
				 cust.setProductid(id1);
				 id1 = null;
			 }
			 if(names.contains("B")&&id2!=null){
				 cust.setProductid(id2);
				 id2 = null;
			 }
			 if(names.contains("C")&&id3!=null){
				 cust.setProductid(id3);
				 id3 = null;
			 }
			 if(names.contains("D")&&id4!=null){
				 cust.setProductid(id4);
				 id4 = null;
			 }
			  cust.setTime(utilDate);
			  cust.setPihao(pihao2);
			  cust.setXinghao(xinghao2);
			  cust.setParame1(value2);
			  cust.setParame2(value3);
			//处理数据重复发送
			  if(cust.getProductid()==null){
				  response.getWriter().write("afffffr");
				  return;
			  }
			//调用service中的方法添加产品信息
			  i = service.addCust(cust);
			ng = ng - i;
			//记录当前生产数量
			zongshu++;
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			pd.update2N(String.valueOf(zongshu),String.valueOf(ng));
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
		xinghao2 = paigongdan.getXinghao();
		pihao2 = paigongdan.getPihao();
		zongshu = 0;
		zongshu2 = paigongdan.getZongshu();
		xingHp2 = paigongdan.getXingHp();
		Ng2 = String.valueOf(ng);
		PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
		if(pd.findById()!=null){
			pd.update2(xinghao2,pihao2,zongshu2,String.valueOf(zongshu),Ng2,workerN2);
			ng = 0;
			i = 0;
		}else{
			pd.addPaigongdan2(xinghao2,pihao2,zongshu2,String.valueOf(zongshu),Ng2,workerN2);
			ng = 0;
			i = 0;
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
