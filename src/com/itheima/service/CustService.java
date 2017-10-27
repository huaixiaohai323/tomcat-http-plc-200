package com.itheima.service;

import java.util.List;

import com.itheima.domain.Cust;
import com.itheima.domain.Page;

public interface CustService {

	/**
	 * 添加客户
	 * @param cust 封装了用户信息的bean
	 * @return 
	 */
	int addCust(Cust cust);

	/**
	 * 查询所有客户信息
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * 根据id查找客户信息
	 * @param id 客户id
	 * @return 查找到的客户信息,如果找不到返回null
	 */
	Cust findCustById(String id);
	
	Cust findUserByProductid(String productid);

	/**
	 * 修改客户信息的方法
	 * @param cust 封装了最新客户信息的bean
	 */
	void updateCust(Cust cust);

	/**
	 * 根据id删除客户
	 * @param id
	 */
	void delCustByID(String id);

	/**
	 * 批量伤处客户 其中会进行事务管理
	 * @param ids 所有要删除的id组成的数组
	 */
	void batchDel(String[] ids);

	/**
	 * 根据条件查询客户信息
	 * @param cust 封装了查询条件的bean,其中可以有用户名/性别/客户类型
	 * @return 符合条件的客户组成的集合
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pageCust(int thispage, int rowperpage);

}
