<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

  <!-- Mobile viewport optimization h5bp.com/ad -->
  <meta name="HandheldFriendly" content="True">
  <meta name="MobileOptimized" content="320">
  <meta name="viewport" content="width=device-width">


<title></title>

  <!-- Main Stylesheet -->
  <link type="text/css" rel="stylesheet" href="<%=path%>/css/main.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>
<body >

<!--头部样式-->

	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="image/logo.png" />
	</div>

<div class="list"><b>注册成功</b></div>
<!--身体样式-->
  <div id="container">

  <h1>注册成功！</h1>
<a href="user_profile.action">个人主页</a>
<a href="campusnews_listNews.action">校园信息场</a>

</div>
<div id="bottom">
</div>
<br/>

<!--底部样式-->
<footer>
<div id="footer" ><%=(new java.text.SimpleDateFormat("yyyy-MM-dd"))
									.format(new java.util.Date())%></div>
<div id="footer" >校园助手 <span title="">&#169;</span> 2012</div>
</footer>

</body>
</html>
