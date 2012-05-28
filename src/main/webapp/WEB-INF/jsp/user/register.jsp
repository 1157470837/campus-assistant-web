<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<header>
	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="image/logo.png">
	</div>
</header>
<div class="list"><b>用户注册</b></div>
  <div id="container" >
    <form name="register" action="user_register.action">
       用户名:<br>
    <input id="username" type="text" placeholder="lizhaoxin" ></input><br>
  密&nbsp;&nbsp;码:<br>
    <input id="password" type="password" ></input><br>
  确认密码 :<br>
    <input id="confirmpwd" type="password"><br>
  E-mail:<br>
        <input id="emailaddress" name="emailaddress" tppe="email" placeholder="Email地址"><br>
  性别:<br>
     <input id="phone" name="sex" type="text" placeholder="性别"><br>
      入学时间:<br>
      <input id="entrance" name="entranceyear" type="text" placeholder="2008"><br>
      电话:<br>
  <input id="phonenumber" name="phone" type="tel" placeholder="13800000000"><br>
 学院‌：‌<br>
<select id="college" width="120">
<option value="volvo">Volvo Opel</option>
</select><br>
专业：<br>
<select id="major" >
<option value="volvo">Volvo Opel</option>
</select><br>
宿舍：<br>
<select id="dormitory" >
<option value="volvo">Volvo Opel</option>
</select><br>
自我简介:<br>
        <textarea id="resume" name="resume" maxLength="200" data-dojo-type="dojox.mobile.TextArea"></textarea><br>
<span>轻轻一点注册按钮，完成注册！</span><br>

<input type="submit" id="register" value="注&nbsp;&nbsp册" class="rb">
</input><br>
</form>
</div>
<div id="bottom"></div>

<div id="footer" ><%=(new java.text.SimpleDateFormat("yyyy-MM-dd"))
									.format(new java.util.Date())%></div>
<div id="footer" >校园助手 <span title="">&#169;</span> 2012</div>
</footer>
</body>
</html>