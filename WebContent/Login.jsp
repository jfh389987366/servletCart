<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="com.j1702.model.User"%>
<%@ page import="com.j1702.action.UserAction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<%String name=(String)session.getAttribute("username");
	UserAction ua=new UserAction();
	User user=ua.showUser(name);
%>
<style type="text/css">
	.recharge{
	<% if(name==null){%>
	display:none;
	<%}else{%>
	display:block;
	<%}%>
	}
	.loginbox{
	<% if(name==null){%>
	display:block;
	<%}else{%>
	display:none;
	<%}%>
	}
</style>
</head>
<% request.getAttribute("user"); %>
<body style="margin: 0px;padding: 0px;background: #D995A4;">
		<div class="div0" style="">
			<div id="header" style="width: 100%;height: 70px;">
				<div style="width: 100%;height: 32px;">
					<div style="width:150px;height:40px;float:left;"><a href="Begin" style="text-decoration: none;">
					<h2 style="line-height: 0px; margin-left: 10px;">天天购物</h2></a></div>
					<div class="recharge" style="width:100px;height:20px;margin-top: 10px; float: right;">
					<a href="Recharge.jsp" style="text-decoration: none;">前去充值</a></div>
					<div class="recharge" style="width:100px;height:20px;margin-top: 10px; float: right;">
					<a href="Cart" style="text-decoration: none;">去购物车</a></div>
					<div class="recharge" style="width:100px;height:20px;margin-top: 10px; float: right;">
					<a href="Eixt" style="text-decoration: none;">退出登录</a></div>
				</div>
				<hr />
			</div>
			<div class="content" style="width: 100%;height: 574px;margin-top: -28px;
				background-image: url(https://img.alicdn.com/tfs/TB1Q0dYSpXXXXXMaFXXXXXXXXXX-2500-600.jpg);height:600px;">
				<div class="loginbox" style="width: 270px;height: 190px;padding: 20px; margin-left: 200px;
					margin-top: 160px;background:#d86f8e;float: left;">
					<form action="Login" method="get">
						<div id="ac" style="margin-top: 20px;">
							&nbsp;&nbsp;账号:<input type="text" name="username" placeholder="请输入账号" style="width: 210px;"/>
						</div>
						<div id="pw" style="margin-top: 40px;">
							&nbsp;&nbsp;密码:<input type="password" name="password" placeholder="请输入密码" style="width: 210px;"/>
						</div>
						<div id="sub" style="margin-top: 40px;">
							<input type="submit" value="登录" style="width: 50px;"/>
							<a href="Regist.jsp" style="float: right;">免费注册</a>
						</div>
					</form>
				</div>
			</div>
			<div id="footer" style="width: 100%;height: 20px;">
				<hr style="margin-top: 0px;" />
			</div>
		</div>
	</body>
	<script type='text/javascript'>
		<%=request.getAttribute("alert") %>
	</script>
</html>