package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustDaoImpl0;
import com.itheima.domain.Cust;
import com.itheima.domain.Page;


public class CustServiceImpl0 {
//	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	CustDaoImpl0 dao = new CustDaoImpl0();
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
}
