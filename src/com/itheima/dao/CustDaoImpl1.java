package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.itheima.domain.Cust;
import com.itheima.util.DaoUtils;

public class CustDaoImpl1 {
	public void addCust(Cust cust) {
		String sql = "insert into haijian values (null,?,?,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,cust.getProductid(),cust.getXinghao(),cust.getPihao(),cust.getParame1(),cust.getParame1p(),cust.getParame2(),cust.getParame2p(),cust.getTime());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public Cust findUserByProductid(String productid) {
		String sql = "select * from haijian where productid = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class),productid);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public List<Cust> getAllCust() {
		String sql = "select * from haijian";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Cust findUserById(String id) {
		String sql = "select * from haijian where id = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void updateCust(Cust cust) {
		String sql = "update haijian set xinghao=?,pihao=?,parame1=?,parame1p=?,parame2=?,parame2p=?,time=? where productid=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,cust.getXinghao(),cust.getPihao(),cust.getParame1(),cust.getParame1p(),cust.getParame2(),cust.getParame2p(),cust.getTime(),cust.getProductid());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delCustByID(String id) {
		String sql = "delete from haijian where id = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		String sql = "delete from haijian where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
			delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Cust> findCustByCond(Cust cust) {
		String sql = "select * from haijian where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(cust.getProductid()!=null && !"".equals(cust.getProductid())){
			sql += " and productid like ? ";
			list.add("%"+cust.getProductid()+"%");
		}
		if(cust.getXinghao()!=null && !"".equals(cust.getXinghao())){
			sql += " and xinghao = ? ";
			list.add(cust.getXinghao());
		}
		if(cust.getPihao()!=null && !"".equals(cust.getPihao())){
			sql += " and pihao = ? ";
			list.add(cust.getPihao());
		}
		
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
			}else{
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from haijian";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Cust> getCustByPage(int from, int count) {
		String sql = "select * from haijian limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
