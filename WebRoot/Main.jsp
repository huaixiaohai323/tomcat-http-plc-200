<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<font color = "#ff0000"><h1>新劲车间物联网</h1></font><hr>
  	<form action="${pageContext.request.contextPath}/servlet/FindgdServlet" method="POST">
  	  	<input type="submit" value="查询"/>
    </form>
  	<table border="1" width="100%" height="100%" bordercolordark="red" bordercolorlight="green" bgcolor="#000000">
  		<tr>
  			<th></th>
  			<th><font color = "#ff0000">动力头装配及推杆测试</font></th>
  			<th><font color = "#ff0000">性能调试</font></th>
  			<th><font color = "#ff0000">氦检</font></th>
  			<th><font color = "#ff0000">MOP1</font></th>
  			<th><font color = "#ff0000">MOP2</font></th>
  			<th><font color = "#ff0000">性能复测</font></th>
  			<th><font color = "#ff0000">低压水检</font></th>
  		</tr>
	  		<tr>
	  			<th><font color = "#ff0000">生产总数</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu7}"/></font></td>
	  			
	  		</tr>
	  		<tr>
	  			<th><font color = "#ff0000">不合格数</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.ng7}"/></font></td>
	  		</tr>
	  			<tr>
	  			<th><font color = "#ff0000">员工条码</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.workerN7}"/></font></td>
	  		</tr>
	  				<tr>
	  			<th><font color = "#ff0000">流程卡号</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.pihao7}"/></font></td>
	  		</tr>
	  					<tr>
	  			<th><font color = "#ff0000">产品型号</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.xinghao7}"/></font></td>
	  		</tr>
	  						<tr>
	  			<th><font color = "#ff0000">计划产量</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.zongshu7}"/></font></td>
	  		</tr>
	  							<tr>
	  			<th><font color = "#ff0000">剩余完成数量</font></th>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu1}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu2}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu3}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu4}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu5}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu6}"/></font></td>
	  			<td align="center"><font color = "#ff0000"><c:out value="${ps.shenchanshu7}"/></font></td>
	  		</tr>
	  		
  	</table>

  </body>
</html>
