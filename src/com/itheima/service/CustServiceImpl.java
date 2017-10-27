package com.itheima.service;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import com.itheima.dao.CustDao;
import com.itheima.dao.CustDaoImpl;
import com.itheima.domain.Cust;
import com.itheima.domain.Page;
import com.itheima.util.DaoUtils;


public class CustServiceImpl implements CustService {
//	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	CustDao dao = new CustDaoImpl();
	public int addCust(Cust cust) {
		//1.检查用户名是否已经存在
		Cust cunzai = dao.findUserByProductid(cust.getProductid());
		if(cunzai!=null){
			dao.updateCust(cust);
			if(cunzai.getParame1p().equals("合格")){
				return 0;
			}
			return 1;
		}else{
		dao.addCust(cust);
		return 0;
		}
	}
	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}
	public Cust findCustById(String id) {
		return dao.findUserById(id);
	}
	public void updateCust(Cust cust) {
		dao.updateCust(cust);
	}
	public void delCustByID(String id) {
		dao.delCustByID(id);
	}
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Cust> findCustByCond(Cust cust) {
		return dao.findCustByCond(cust);
	}
	public Page pageCust(int thispage, int rowperpage) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Cust> list = dao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
	public Cust findUserByProductid(String productid) {
		return dao.findUserByProductid(productid);
	}
}
