<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
  <link type="text/css"  rel="stylesheet" href="<%=path%>/css/main.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>

<body >
<!--头部样式-->
<header>
	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="<%=path%>image/logo.png">
	</div>
</header>
<div class="list"><b>个人主页</b><em>|</em>
<a href="user_updateInfo.action">修改个人信息</a><em>|</em>
<a href="campusnews_listNews.action">校园信息场</a></div>
  <div id="container" >
	<label>基本信息</label><br />
		用户名：<s:property value="personInfo.username" /><br/>
		性别：<s:property value="personInfo.sex" /><br />
		生日：<s:property value="personInfo.birthday" /><br />
		学院：<s:property value="personInfo.collegename" /><br />
		专业：<s:property value="personInfo.majorname" /><br />
		入学时间：<s:property value="personInfo.entrance" /><br />
		联系方式：<s:property value="personInfo.phone" /><br />
	<div id="bottom"></div>
	<label>个人简介</label><br />
		<s:property value="personInfo.description" /><br />
</div>
<div id="bottom"></div>

<div id="footer" >5月27日 07:20</div>
<div id="footer" >校园助手 <span title="">&#169;</span> 2012</div>
</footer>
</body>
</html>