package com.itheima.dao;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.itheima.domain.PaigongdanS;
import com.itheima.util.DaoUtils;

public class PaigongdanDaoImpl {

	public void addPaigongdan2(String xinghao2,String pihao2,String zongshu2,String shenchanshu2,String ng2, String workerN2) {
		String sql = "insert into paigongdan values (null,'0','0','0','0','0','0',?,?,?,?,?,?,'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0')";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao2,pihao2,zongshu2,shenchanshu2, ng2,workerN2);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public PaigongdanS findById() {
		String sql = "select * from paigongdan where id = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<PaigongdanS>(PaigongdanS.class),"1");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<PaigongdanS> getGongdan() {
		String sql = "select * from paigongdan";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<PaigongdanS>(PaigongdanS.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update2(String xinghao2,String pihao2,String zongshu2,String shenchanshu2,String ng2,String workerN2) {
		String sql = "update paigongdan set xinghao2=?,pihao2=?,zongshu2=?,shenchanshu2=?,ng2=?,workerN2=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao2,pihao2,zongshu2,shenchanshu2,ng2,workerN2);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update2N(String shenchanshu2,String ng2) {
		String sql = "update paigongdan set shenchanshu2=?,ng2=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu2,ng2);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update1(String xinghao1,String pihao1,String zongshu1,String shenchanshu1,String ng1,String workerN1) {
		String sql = "update paigongdan set xinghao1=?,pihao1=?,zongshu1=?,shenchanshu1=?,ng1=?,workerN1=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao1,pihao1,zongshu1,shenchanshu1,ng1,workerN1);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update1N(String shenchanshu1,String ng1) {
		String sql = "update paigongdan set shenchanshu1=?,ng1=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu1,ng1);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update3(String xinghao3,String pihao3,String zongshu3,String shenchanshu3,String ng3,String workerN3) {
		String sql = "update paigongdan set xinghao3=?,pihao3=?,zongshu3=?,shenchanshu3=?,ng3=?,workerN3=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao3,pihao3,zongshu3,shenchanshu3,ng3,workerN3);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update3N(String shenchanshu3,String ng3) {
		String sql = "update paigongdan set shenchanshu3=?,ng3=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu3,ng3);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update4(String xinghao4,String pihao4,String zongshu4,String shenchanshu4,String ng4,String workerN4) {
		String sql = "update paigongdan set xinghao4=?,pihao4=?,zongshu4=?,shenchanshu4=?,ng4=?,workerN4=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao4,pihao4,zongshu4,shenchanshu4,ng4,workerN4);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update4N(String shenchanshu4,String ng4) {
		String sql = "update paigongdan set shenchanshu4=?,ng4=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu4,ng4);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update5(String xinghao5,String pihao5,String zongshu5,String shenchanshu5,String ng5,String workerN5) {
		String sql = "update paigongdan set xinghao5=?,pihao5=?,zongshu5=?,shenchanshu5=?,ng5=?,workerN5=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao5,pihao5,zongshu5,shenchanshu5,ng5,workerN5);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update5N(String shenchanshu5,String ng5) {
		String sql = "update paigongdan set shenchanshu5=?,ng5=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu5,ng5);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update6(String xinghao6,String pihao6,String zongshu6,String shenchanshu6,String ng6,String workerN6) {
		String sql = "update paigongdan set xinghao6=?,pihao6=?,zongshu6=?,shenchanshu6=?,ng6=?,workerN6=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao6,pihao6,zongshu6,shenchanshu6,ng6,workerN6);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update6N(String shenchanshu6,String ng6) {
		String sql = "update paigongdan set shenchanshu6=?,ng6=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu6,ng6);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update7(String xinghao7,String pihao7,String zongshu7,String shenchanshu7,String ng7,String workerN7) {
		String sql = "update paigongdan set xinghao7=?,pihao7=?,zongshu7=?,shenchanshu7=?,ng7=?,workerN7=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,xinghao7,pihao7,zongshu7,shenchanshu7,ng7,workerN7);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public void update7N(String shenchanshu7,String ng7) {
		String sql = "update paigongdan set shenchanshu7=?,ng7=? where id=1";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,shenchanshu7,ng7);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
