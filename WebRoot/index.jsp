<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script type="text/javascript">   
function toggleFullScreen() {
if (!document.fullscreenElement && // alternative standard method
!document.mozFullScreenElement && !document.webkitFullscreenElement) { // current working methods
if (document.documentElement.requestFullscreen) {
document.documentElement.requestFullscreen();
} else if (document.documentElement.mozRequestFullScreen) {
document.documentElement.mozRequestFullScreen();
} else if (document.documentElement.webkitRequestFullscreen) {
document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
}
} else {
if (document.cancelFullScreen) {
document.cancelFullScreen();
} else if (document.mozCancelFullScreen) {
document.mozCancelFullScreen();
} else if (document.webkitCancelFullScreen) {
document.webkitCancelFullScreen();
}
}
}
</script> 
  </head>
  <body background = "changqi.jpg">
  	<h1 align="center">新劲车间管理系统</h1><hr>
  	<div align="center" onclick='toggleFullScreen();'>全屏</div>
  	<p align="center"><a href="${pageContext.request.contextPath }/Main.jsp">主界面</a></p><br>
  	<div style="float:left;width:200px"><h1 align="center">派工单区</h1>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan0.jsp">拧紧派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan.jsp">性能测试派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan3.jsp">氦检派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan4.jsp">MOP1派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan5.jsp">MOP2派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan6.jsp">性能复测派工单</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/Paigongdan7.jsp">低压水检派工单</a></p>
  	</div>
  	<div style="float:right"><h1 align="center">单一机台分页查询区</h1>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet0?thispage=1">拧紧台分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=1">性能测试分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet3?thispage=1">氦检分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet4?thispage=1">MOP1分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet5?thispage=1">MOP2分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet6?thispage=1">性能复测分页查询</a>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/PageCustServlet7?thispage=1">低压水检分页查询</a>
  	</div>
  	<div style="float:center"><h1 align="center">单一机台查询区</h1>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet0">拧紧信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet">性能测试信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet3">氦检信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet4">MOP1信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet5">MOP2信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet6">性能复测信息列表</a></p>
  	<p align="center"><a href="${pageContext.request.contextPath }/servlet/ListCustServlet7">低压水检信息列表</a></p>
  	</div>

  </body>
</html>
