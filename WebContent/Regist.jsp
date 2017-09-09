<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页</title>
</head>
<body style="margin: 0px;padding: 0px;">
		<div class="body" >
			<div class="header" style="width: 100%;height: 100px;float: left;background: #ffc;">
				<div style="width: 100%;height: 80px;">
					<div style="width: 150px;height: 80px;float: left;">
						<h2 style="padding-left: 10px;">天天购物</h2>
					</div>
					<div style="width: 150px;height: 80px;float: right;">
						<a href="Login.jsp" style="padding-right: 10px;margin-top: 20px; float: right;text-decoration: none;">前往登录</a>
					</div>
				</div>
				<hr/>
			</div>
			<div class="content" style="width: 100%;height: 448px;float: left;background: #ffc;">
				<div class="tab" style="margin: 0 auto;width: 500px;height: 465px;padding: 65px;background: #ffa;">
					<table border="0px" cellspacing="30px" cellpadding="1px" style="margin: 0 auto;">
						<form action="Regist" method="get">
							<tr>
								<th>输入姓名:<input type="text" name="username" placeholder="请输入你的姓名" /></th>
							</tr>
							<tr>
								<th>输入密码:<input type="password" name="password" placeholder="请输入你的密码"/></th>
							</tr>
							<tr>
								<th>确认密码:<input type="password" name="repassword" placeholder="请确认你的密码"/></th>
							</tr>
							<tr>
								<th><input type="submit" value="注册" style="margin-left: 15px; width: 150px;"/></th>
							</tr>
						</form>
					</table>
				</div>
			</div>
			<div id="footer" style="width: 100%;height: 83px;float: left;background: #ffc;">
				<hr />
			</div>
		</div>
		<script type='text/javascript'>
			<%=request.getAttribute("alert") %>
		</script>
	</body>
</html>