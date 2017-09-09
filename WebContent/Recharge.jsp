<%@page import="com.j1702.model.User"%>
<%@page import="com.j1702.action.UserAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值页</title>
</head>
<body style="margin: 0px;padding: 0px;">
		<div class="body" >
			<div class="header" style="width: 100%;height: 100px;float: left;background: #ffc;">
				<div style="width: 100%;height: 65px;">
				<div style="width:1000px;height: 55px;float:left"><a href="Begin" style="text-decoration: none;"><h2 style="padding:0px 10px;">天天购物</h2></a></div>
				<div style="width:100px;height: 55px;float:right"><a href="Eixt" style="text-decoration: none;"><h4 style="margin-top:25px">退出登录</h4></a></div>
				</div>
				<hr />
			</div>
			<div class="content" style="width: 100%;height: 448px;float: left;background: #ffc;">
				<div class="tab" style="margin: 0 auto;width: 500px;height: 350px;padding: 50px;background: #ffa;">
					<table border="0px" cellspacing="30px" cellpadding="1px" style="margin: 0 auto;">
						<%String name=(String)session.getAttribute("username");
							UserAction ua=new UserAction();
							User user=ua.showUser(name);
						%>
						<form action="Recharge" method="get">
							<tr>
								<th><div style="width: 242px;height: 50px;text-align: center;">当前账户余额：￥<%=user.getMoney() %></div></th>
							</tr>
							<tr>
								<th>充值金额:<input type="text" name="usermoney" placeholder="请输入你要存入的金额" /></th>
							</tr>
							<tr>
								<th><div style="width: 150px;height: 150px;"></div>
								<input type="submit" value="充值" style="margin-left: 15px; width: 150px;"/></th>
							</tr>
						</form>
					</table>
				</div>
			</div>
			<div id="footer" style="width: 100%;height: 83px;float: left;background: #ffc;">
				<hr />
			</div>
		</div>
	</body>
</html>