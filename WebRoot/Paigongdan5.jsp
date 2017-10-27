<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>新劲车间物联网</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/AddCustServlet5" method="POST">
  		<table border="1" align="center">
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
  				<td>生产总数:</td>
  				<td><input type="text" name="zongshu" /></td>
  			</tr>
  			<tr>
  				<td>是否验证产品型号1/0:</td>
  				<td><input type="text" name="xingHp"/></td>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="MOP2派工单"/>
  				</td>
  			</tr>
  			
  		</table>
  	</form>
  </body>
</html>
