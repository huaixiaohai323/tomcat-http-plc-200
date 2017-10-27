<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	
  </head>
  <body style="text-align: center;">
  	<h1>分页查询信息</h1><hr>
  	<table border="1" width="100%">
  		<tr>
  			<th>产品条码</th>
  			<th>产品型号</th>
  			<th>产品批号</th>
  			<th>参数1</th>
  			<th>参数1标志位</th>
  			<th>参数2</th>
  			<th>参数2标志位</th>
  			<th>删除</th>
  		</tr>
  		<c:forEach items="${requestScope.page.list}" var="cust">
	  		<tr>
	  			<td><c:out value="${cust.productid}"/></td>
	  			<td><c:out value="${cust.xinghao}"/></td>
	  			<td><c:out value="${cust.pihao}"/></td>
	  			<td><c:out value="${cust.parame1}"/></td>
	  			<td><c:out value="${cust.parame1p}"/></td>
	  			<td><c:out value="${cust.parame2}"/></td>
	  			<td><c:out value="${cust.parame2p}"/></td>
	  			<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet0?id=${cust.id }">删除</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	
  	共${page.countrow }条记录
  	共${page.countpage }页
  	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=${page.firstpage }">首页</a>
  	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=${page.prepage }">上一页</a>
  	
  	<!-- 分页逻辑开始 -->
  	<c:if test="${page.countpage<=100}">
  		<c:set var="begin" value="1" scope="page"></c:set>
  		<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  	</c:if>
  	<c:if test="${page.countpage>100}">
		<c:choose>
			<c:when test="${page.thispage<=3}">
				<c:set var="begin" value="1" scope="page"></c:set>
  				<c:set var="end" value="100" scope="page"></c:set>
			</c:when>
			<c:when test="${page.thispage>=page.countpage-2}">
				<c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
  				<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  			</c:when>
  			<c:otherwise>
  				<c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
  				<c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
  			</c:otherwise>
		</c:choose>
  	</c:if>
  	
  	<c:forEach begin="${begin}" end="${end}" step="1" var="i">
  		<c:if test="${i == page.thispage}">
  			${i }
  		</c:if>
  		<c:if test="${i != page.thispage}">
  			<a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=${i}">${i }</a>
  		</c:if>
  	</c:forEach>
  	
  	<!-- 分页逻辑结束 -->
  	
  	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=${page.nextpage }">下一页</a>
  	<a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=${page.lastpage }">尾页</a>
  	跳到<input type="text" value="${page.thispage }" style="width: 40px" onchange="changePage(this)"/>页
  </body>
</html>
