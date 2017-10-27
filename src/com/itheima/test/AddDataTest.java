package com.itheima.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.itheima.domain.Cust;
import com.itheima.form.baobiao;
import com.itheima.util.DaoUtils;

public class AddDataTest {
	@Test
	public void add() throws SQLException{
//		 String productid = "xinghao1099992";
//		String sql1 = "select * from mopyi where productid = 10000000";
		 String sql1 = "select productid from mopyi where productid = 900000";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			 runner.query(sql1, new BeanHandler<Cust>(Cust.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
//		java.util.Date utilDate=new java.util.Date();
//	    SimpleDateFormat dimple = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
//	    dimple.format(utilDate); 
//		String sql = "insert into mopyi values (null,?,?,?,?,?,?,?,?)";
//		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
//		for(int i=1;i<=1000000;i++)
//			runner.update(sql,"xinghao"+i,"dd","d","10","a","44","5",utilDate);
//		baobiao form = new baobiao();
//		form.m();
	}
}
