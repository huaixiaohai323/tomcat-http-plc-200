package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Cust;

public interface CustDao {

	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 找到的用户,如果找不到返回null
	 */
	Cust findUserByProductid(String name);

	/**
	 * 添加客户
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * 查询所有客户信息组成的集合
	 * @return 封装了所有客户信息的集合,如果没有任何客户,返回的集合中内容为空
	 */
	List<Cust> getAllCust();

	/**
	 * 根据id查找客户
	 * @param id 客户id
	 * @return 客户bean
	 */
	Cust findUserById(String id);

	/**
	 * 修改客户信息
	 * @param cust 最新信息bean
	 */
	void updateCust(Cust cust);

	/**
	 * 根据id删除客户
	 * @param id
	 */
	void delCustByID(String id);

	/**
	 * 根据Id删除客户,并管理事务
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * 根据用户名/性别/客户类型查找客户
	 * @param cust
	 * @return
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * 查询数据库中一共有多少条记录
	 * @return
	 */
	int getCountRow();

	/**
	 * 查询指定记录后多少条记录
	 * @param from 从哪条记录后取
	 * @param count 取多少条
	 * @return
	 */
	List<Cust> getCustByPage(int from, int count);

}
