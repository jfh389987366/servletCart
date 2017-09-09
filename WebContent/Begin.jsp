<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.j1702.model.Goods"%>
<%@ page import="com.j1702.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
			body{
				min-width: 1300px;
			}
			
			span{
				font-family: "宋体", Arial, Helvetica, sans-serif;
				margin-top: 0px;
				padding: 6px 10px;
				float: right;
				color: black;
			}
			p{
				font-family: "宋体", Arial, Helvetica, sans-serif;
				margin-top: 0px;
				padding: 8px;
				float: right;
				color: black;
			}
			#login{
				display: none;
			}
			.un{
				display: block;
			}
		</style>
</head>
<body style="margin: 0px;border: 0px;">
<%
	String name=(String)session.getAttribute("username");
%>
		<div class="body" >
			<div class="header" style="width: 100%;height: 55px;background: #E99632;">
				<span class="un" style="margin-top: 6px;<%if(name==null){%>display: none;<%}%>">
					<form action="Eixt" method="get">
						<input type="submit" value="退出登录"/>
					</form>
				</span>
				<span class="un" style="margin-top: 6px;<%if(name==null){%>display: none;<%}%>">
					<form action="Cart" method="get">
						<input type="submit" value="进入购物车"/>
					</form>
				</span>
				<span class="un" style="margin-top: 6px;<%if(name==null){%>display: none;<%}%>">
					<span>欢迎回来！<%=name %></span>
				</span>
				<span id="login" style="margin-top: 10px;<%if(name==null){%>display: block;<%}%>">
					<form action="Login.jsp" method="get">
						<input type="submit" value="登录/注册"/>
					</form>
				</span>
			</div>
			<div id="content" style="width: auto; height: auto; background: #fff; padding-top: 0px;">
				<div style="width: auto; padding: 10px; margin: 0px auto; border: 20px cyan solid;text-align: center; ">
					<table border="0px" cellspacing="15px" cellpadding="1px" style="margin: 0 auto;">
				<%List<Goods> list = (List<Goods>)request.getAttribute("list");
					if (list == null || list.size() < 1) {
						out.print("<tr><td colspan='5'>没有任何商品信息！</td></tr>");
					} else {
					int i=0;
						for (Goods goods : list) {
						i++;
						if(i==1 | i==5 | i==9 | i==13 | i==17){%>
						<tr>
						<%}%>
							<th>
								<a href="Goods?url=<%=goods.getUrl()%>&
												name=<%=goods.getName()%>&
												intro=<%=goods.getIntro()%>&
												price=<%=goods.getPrice()%>&
												number=<%=goods.getNumber()%>&">
									<img src="<%=goods.getUrl()%>" style="width: 285px;height: 285px;"/>
									<div id="goodsname">
										<p id="" style="font: 12px '微软雅黑';float: right;">
										<%=goods.getName()%>:<br/>
										<%=goods.getIntro() %>
										</p>
									</div>
									<div id="goodsprice">
										<p id="" style="font: 15px bolder;color: red;float: left;">
										￥：<%=goods.getPrice() %>
										</p>
									</div>
								</a>
							</th>
						<%if(i==4 | i==8 | i==12 | i==16){ %>
						</tr>
						<%}%>
					<%}
				}%>
						
					</table>
				</div>
			</div>
			<div id="footer" style="width: 100%; height: 55px; background: #E99632; text-align: center; padding-top: 5px;">
				<%=request.getAttribute("bar")%>
			</div>
		</div>
</body>
<script type='text/javascript'>
	<%=request.getAttribute("alert") %>
</script>
</html>