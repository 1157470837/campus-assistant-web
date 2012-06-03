<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
  <link  type="text/css" rel="stylesheet" href="<%=path%>/css/main.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>
<body >&nbsp;  


<!--头部样式-->

	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="<%=path%>/image/logo.png" />
	</div>

<div class="list"><b>用户登入</b></div>

 <s:if test="%{msg != null && msg.length() >0}">
 	<div class="tips" style="margin-bottom:0px;" >
 	<s:property value="msg" />
 	</div>
 </s:if>

<!--身体样式-->
  <div id="container">

    <form name="login" action="login_login.action" method="post">
       用户名:<br>
		<input id="username" type="text" name="username"/><br/>
密&nbsp;&nbsp;码:<br>
		<input id="pwd" type="password" name="password"></input><br>
		<div style="margin-top:5px;">
		<input id="login" type="submit" value="登&nbsp;&nbsp;入" class="rb"></input>
		</div>
	</form>

</div>
<div style="display:block">
	<span>如果还没账户，那就赶快<a href="user_register.action">注册</a>一个吧！</span>
</div>
<div id="bottom">
</div>
<br/>

<!--底部样式-->

<footer>
<div id="footer" ><%=(new java.text.SimpleDateFormat("yyyy-MM-dd"))
									.format(new java.util.Date())%></div>
<div id="footer" >校园助手 <span title="">&#169;</span> 2012</div>

<s:debug></s:debug>
</footer>

</body>
</html>
