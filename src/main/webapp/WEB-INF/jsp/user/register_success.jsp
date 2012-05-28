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
  <link rel="stylesheet" href="css/style.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>
<body >

<style type="text/css">
#bottom{padding:5px 4px; border-top:solid 1px #bbb; line-height:150%; margin-top:6px;}
#footer{height:25px;padding-left:7px;background:#cb213c;}
.rb{color:#fff; background:#D32C47; padding:3px 5px; border-left:1px solid #fff; border-top:1px solid #fff; border-right:1px solid #6a6a6a; border-bottom:1px solid #6a6a6a; cursor:pointer;}
.list{padding:5px 4px 5px 4px;border-bottom:solid 1px #ddd;word-wrap:break-word;}
</style>
<!--头部样式-->

	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="image/logo.png" />
	</div>

<div class="list"><b>用户登入</b></div>
<!--身体样式-->
  <div id="container">

  <h1>登入成功！</h1>

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
