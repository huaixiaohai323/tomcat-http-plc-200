<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>新劲车间物联网管理系统_修改信息</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/UpdateCustServlet" method="POST">
  		<input type="hidden" name="id" value="${cust.id }">
  		<table border="1" align="center" bgcolor="#fffff">
  			<tr>
  				<td>产品条码:</td>
  				<td><input type="text" name="name" /></td>
  			</tr>
  			<tr>
  				<td>产品型号:</td>
  				<td>
  					<input type="text" name="gender"/> 					
  				</td>
  			</tr>
  			<tr>
  				<td>生产日期:</td>
  				<td><input type="text" name="birthday" /></td>
  			</tr>
  			<tr>
  				<td>产品批号:</td>
  				<td><input type="text" name="cellphone" /></td>
  			</tr>
  			<tr>
  				<td>参数1:</td>
  				<td><input type="text" name="email" /></td>
  			</tr>
  			<tr>
  				<td>参数1标志位:</td>
  				<td>
  				<input type="text" name="preference" />	
  				</td>
  			</tr>
  			<tr>
  				<td>参数2:</td>
  				<td>
				<input type="text" name="type" />
				</td>
  			</tr>
  			<tr>
  				<td>参数2标志位:</td>
  				<td><textarea name="description" rows="1" cols="15" ></textarea></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="修改信息"/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
