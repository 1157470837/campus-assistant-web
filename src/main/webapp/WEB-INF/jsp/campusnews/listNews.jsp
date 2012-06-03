<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <!-- Mobile viewport optimization h5bp.com/ad -->
  <meta name="HandheldFriendly" content="True">
  <meta name="MobileOptimized" content="320">
  <meta name="viewport" content="width=device-width">


<title></title>

  <!-- Main Stylesheet -->
  <link type="text/css"  rel="stylesheet" href="css/main.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>

<body >

<!--头部样式-->
<header>
	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="<%=path %>/image/logo.png">
	</div>
</header>

<div class="list"><b>校园信息</b></div>
<div class="list">
	<form action="campusnews_searchInfo.action" method="post">
	<input id="searchtext" name="search" type="text" placeholder="毕业"/>
	<input id="search" name="btn_search" type="submit" value="搜搜" class="rb"/>
	</form>
</div>


  <div id="container" >
  <div class="list">
  <a href="campusnews_listNews.action" class="rb">校园新闻</a>
  <a href="campusnews_listcampusNotif.action" class="rb">校园公告</a>
  <a href="campusnews_listcollegeNotif.action" class="rb">学院公告</a>
  </div>
	<label>校园新闻</label>
	<div id="bottom"></div>
		<s:iterator value="campusnewsList">
		<s:property value="content" /><br />
		<div id="bottom"></div>
		</s:iterator>
</div>

<div id="footer" >5月27日 07:20</div>
<div id="footer" >校园助手 <span title="">&#169;</span> 2012</div>
</footer>
</body>
</html>