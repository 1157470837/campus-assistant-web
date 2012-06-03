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
  <link type="text/css"  rel="stylesheet" href="<%=path%>/css/main.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="js/libs/modernizr-2.0.6.min.js"></script>

</head>
<body >

<!--头部样式-->

	<div style="height:25px;padding-left:7px;background:#cb213c;">
        <img src="<%=path%>/image/logo.png" />
	</div>

<div class="list"><b>用户信息修改</b></div>

 <s:if test="%{msg != null && msg.length() >0}">
 	<div class="tips" style="margin-bottom:0px;" ></div>
 	<s:property value="msg" />
 </s:if>
 
  <div id="container" >
    <form name="register" action="user_updateProcess.action" method="post">
       用户名:<br>
    <input name="username" type="text" value="<s:property  value="reg.username"/>" disabled="disabled" /><br/>
  旧密码:<br>
    <input id="password" name="password" type="password" ></input><br>
   新密码:<br>
    <input id="password" name="newpassword" type="password" ></input><br>
  确认密码 :<br>
    <input id="confirmpwd" name="confirmpwd" type="password"><br>
  E-mail:<br>
        <input id="email" name="email" type="email"  value="<s:property value="reg.email"/>"><br>
  性别:<br/>
      <s:radio list="{'男','女'}" id="sex" name="sex" ></s:radio><br/>
  出生日期:<br>
      <input id="birthday" name="birthday" type="text" value="<s:property value="reg.birthday"/>"><br>
      入学时间:<br>
      <input id="entrance" name="entrance" type="text" value="<s:property value="reg.entrance"/>"><br>
      电话:<br/>
  <input id="phonenumber" name="phone" type="tel" value="<s:property value="reg.phone"/>"><br>
 专业：<br/>
<s:select name="majorname" list="#{'1':'山东科技大学'}">
	<s:iterator value="collegeMap">
		<s:optgroup label="%{key}" list="%{value}"></s:optgroup>
	</s:iterator>
</s:select><br/>
宿舍：<br/>
<s:select list="dormitories" name="dormitory" listKey="key" listValue="value"></s:select><br/>
自我简介:<br>
        <textarea id="description" name="description" maxLength="200" value="<s:property value="reg.description"/>"></textarea><br>
        
<input type="submit" id="register" value="确&nbsp;&nbsp认" class="rb" />
</form>

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