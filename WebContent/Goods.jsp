<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.j1702.action.UserAction" %>
<%@ page import="com.j1702.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
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
	#login{
	<% if(name==null){%>
	display:block;
	<%}else{%>
	display:none;
	<%}%>
	}
</style>
</head>
<body style="margin: 0px;padding: 0px;">
		<div id="divo" style="min-width: 1300px;height: auto;background: yellowgreen;">
			<div class="header" style="width: 100%;height: 73px;float: left;background: chocolate;">
				<div style="width: 100%;height: 63px;">
					<div style="width:150px;height:40px;margin-top: 15px;float:left;"><a href="Begin" style="text-decoration: none;">
					<h2 style="line-height: 0px; margin-left: 10px;">天天购物</h2></a></div>
					<div class="recharge" style="width:100px;height:20px;margin-top: 25px; float: right;">
					<a href="Eixt" style="text-decoration: none;">退出登录</a></div>
					<div class="recharge" style="width:100px;height:20px;margin-top: 25px; float: right;">
					<a href="Recharge.jsp" style="text-decoration: none;">前去充值</a></div>
					<div id="login" style="width:100px;height:20px;margin-top: 25px; float: right;">
						<form action="Login.jsp" method="get">
							<input type="submit" value="登录/注册"/>
						</form>
					</div>
				</div>
				<hr />
			</div>
			<div id="content" style="width: 100%;height: auto;float: left;background: cyan;">
				<div id="content" style="width: 1300px;min-height: 462px;margin: 10px auto;padding: 10px; background: white;">
					<div id="goods" style="width: 1150;height: 300px;margin-top: 80px;">
						
						<div id="img" style="padding: 5px;float: left;">
							<img src="<%=request.getAttribute("url") %>" style="width: 285px;height: 285px;"/>
						</div>
						<div id="date" style="width: 300px;height: 250px;padding: 25px;float: left;">
							<span style="font: 10px;"><%=request.getAttribute("name") %></span><br/>
							<span style="font: 10px;"><%=request.getAttribute("intro") %></span>
						</div>
						<div id="price" style="width: 100px;height: 150px;padding: 140px 30px 10px;float: left;">
							<span style="font: 15px bold;color: red;">价格:￥<%=request.getAttribute("price") %></span>
						</div>
						<div id="number" style="width: 100px;height: 150px;padding: 140px 30px 10px;float: left;">
							<span style="font: 12px bold;color: black;">库存量:<%=request.getAttribute("number") %></span>
						</div>
						<div class="recharge" style="width: 170px;height: 300px;float: left;">
							<a style="text-decoration: none;" href="AddCart?goodsurl=<%=request.getAttribute("url")%>&
							goodsintro=<%=request.getAttribute("intro")%>&goodsname=<%=request.getAttribute("name")%>&
							goodsprice=<%=request.getAttribute("price")%>&goodsnumber=<%=request.getAttribute("number")%>&
							username=<%=request.getAttribute("username")%>">
							<div style="width:90px;height:23px; margin-top: 275px;margin-left: 80px;
							text-align: center;background:#f1f1f1;border:1px solid #000">加入购物车</div></a>
						</div>
					</div>
				</div>
			</div>
			<div id="footer" style="width: 100%;height: 73px;background: chocolate;float: left;">
				<div class="recharge" style="width:100%;height:73px">
				<form action="Cart" method="get">
					<input type="submit" value="进入购物车" style="margin-top: 25px;margin-left: 1100px;"/>
				</form>
				</div>	
			</div>
		</div>
</body>
<script type='text/javascript'>
	<%=request.getAttribute("alert") %>
</script>
</html>