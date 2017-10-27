<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function checkAll(allC){
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0;i<otherCs.length;i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>新劲车间物联网</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/FindCustByCondServlet5" method="POST">
  		产品条码:<input type="text" name="productid" value="${param.productid}"/>
  		产品型号:<input type="text" name="xinghao" value="${param.xinghao}"/>
  		产品批号:<input type="text" name="pihao" value="${param.pihao}"/>
		<input type="submit" value="条件查询客户"/>
  	</form>
  	<form action="${pageContext.request.contextPath}/servlet/BatchDelServlet5" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			<th>产品条码</th>
  			<th>产品型号</th>
  			<th>产品批号</th>
  			<th>参数1</th>
  			<th>参数1标志位</th>
  			<th>参数2</th>
  			<th>参数2标志位</th>
  			<th>生产日期</th>
  			<th>删除</th>
  		</tr>
  		<c:forEach items="${requestScope.list}" var="cust">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${cust.id}" /></td>
	  			<td><c:out value="${cust.productid}"/></td>
	  			<td><c:out value="${cust.xinghao}"/></td>
	  			<td><c:out value="${cust.pihao}"/></td>
	  			<td><c:out value="${cust.parame1}"/></td>
	  			<td><c:out value="${cust.parame1p}"/></td>
	  			<td><c:out value="${cust.parame2}"/></td>
	  			<td><c:out value="${cust.parame2p}"/></td>
	  			<td><c:out value="${cust.time}"/></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet5?id=${cust.id}">删除</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<input type="submit" value="批量删除"/>
  	</form>
  </body>
</html>
