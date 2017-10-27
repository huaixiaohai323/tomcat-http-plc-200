<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>新劲车间物联网</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/AddCustServlet0" method="GET">
  		<table border="1" align="center">
  			<tr>
  				<td>产品条码:</td>
  				<td><input type="text" name="productid" /></td>
  			</tr>
  			<tr>
  				<td>产品型号:</td>
  				<td>
  					<input type="text" name="xinghao"/> 					
  				</td>
  			</tr>
  	
  			<tr>
  				<td>产品批号:</td>
  				<td><input type="text" name="pihao" /></td>
  			</tr>
  			<tr>
  				<td>参数1:</td>
  				<td><input type="text" name="parame1" /></td>
  			</tr>
  			<tr>
  				<td>参数1标志位:</td>
  				<td>
  				<input type="text" name="parame1p" />	
  				</td>
  			</tr>
  			<tr>
  				<td>参数2:</td>
  				<td>
				<input type="text" name="parame2" />
				</td>
  			</tr>
  			<tr>
  				<td>参数2标志位:</td>
  				<td><input type="text" name="parame2p"/></td>
  			</tr>
  					<tr>
  				<td>生产日期:</td>
  				<td><input type="text" name="time" /></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="添加信息"/>
  				</td>
  			</tr>
  			
  		</table>
  	</form>
  </body>
</html>
