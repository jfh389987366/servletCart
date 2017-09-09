<%@page import="com.j1702.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.j1702.action.*" %>
<%@ page import="com.j1702.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
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
</style>
</head>
<body style="margin: 0px;padding: 0px;">
		<div id="divo" style="min-width: 1300px;">
			<form action="Account" method="get">
				<div id="header" style="width: 100%;height: 80px;background: #e3dc89;">
					<div id="cart" style="width: 100%;height: 80px;padding-left: 10px;">
						<div style="float: left;">
							<a href="Begin" style="text-decoration: none;"><h2>天天购物</h2></a>
						</div>
						<div style="float: left;margin: 27px 45px;">
							<input type="checkbox" name="selectall" id="selectAll" value="1"/><label for="">全选</label>
						</div>
						<div class="recharge" style="width:100px;height:20px;margin-top: 25px; float: right;">
						<a href="Eixt" style="text-decoration: none;">退出登录</a></div>
						<div class="recharge" style="width:100px;height:20px;margin-top: 25px; float: right;">
						<a href="Recharge.jsp" style="text-decoration: none;">前去充值</a></div>
					</div>	
				</div>
				<div id="content" style="width: 100%;min-height: 487px;background: #ffc;">
					<table cellspacing="0" cellpadding="10px" style="margin: 0 auto;">
						<hr style="margin-top: 0px;"/>
						<% List<Cart> list=(List<Cart>)request.getAttribute("list");
						if(list==null || list.size()<1){
							out.print("<tr><td colspan='5'>购物车里什么也没有耶！快去添加点商品吧！</td></tr>");
						}else{
						int i=0;
						for(Cart cart:list){%>
						<tr id="goods<%=i++%>" style="border-bottom: 1px;">
							<th>
								<div class="select" style="width: 60px;height: 200px;margin-left: 85px;">
									<input type="checkbox" name="checked" value="1" />
								</div>
							</th>
							<th>
								<div id="" style="width: 240px;height: 245px;">
									<img src="<%=cart.getGoodsUrl() %>" 
									style="width:237px;height:245px;"/>
								</div>
							</th>
							<th>
								<div id="" style="width: 200px;height: 250px;">
									<input style="text-align: center"type="text" name="goodsname<%=i %>" placeholder="<%=cart.getGoodsName() %>" readonly="readonly"/><br/>
									<span style="font: 10px;"><%=cart.getGoodsIntro() %></span>
								</div>
							</th>
							<th>
								<div class="RMB" style="width: 200px;height: 50px;margin-top: 200px;">
									<div style="width:100%;height:25px;">
										<span id="tot<%=i %>" style="font: 15px;color: red;"></span>
									</div>
									<div id="price" style="width:100%;height:25px;">
										<span class="￥" style="font: 15px;color: red;">￥</span>
										<input style="text-align: center;width:100px;height:21px"type="text" name="money" placeholder="<%=cart.getGoodsPrice() %>" readonly="readonly"/>
									</div>
								</div>
							</th>
							<th>
								<div id="" style="width: 200px;height: 120px;margin-bottom: 100px;">
									<select id="sel" name="sel">
									<%GoodsAction ga=new GoodsAction();
									Goods goods=new Goods();
									goods=ga.queryGoods(cart.getGoodsName());
									for(int j=1;j<=goods.getNumber();j++){ %>
										<option value="<%=j %>" 
										<%if(j==cart.getGoodsNumber()){%>
											selected="selected";
										<%} %>
										>
										<%=j %>
										</option>
									<%}%>
									</select>
								</div>
							</th>
							<th>
								<div id="delete<%=i%>" style="width: 200px;height: 120px;margin-bottom: 100px;">
									<a href="DelCart?goodsname=<%=cart.getGoodsName()%>"><input type="button" class="delete" value="删除" /></a>
								</div>
							</th>
						</tr>
						<%}} %>
					</table>
				</div>
				<div id="footer" style="width: 100%;height: 80px;background: #e3dc89;">
					<hr  style="margin-top: 0px;"/>
					<div id="button" style="margin-left: 1000px;margin-top: 20px;">
						<span class="￥" style="font: 15px;color: red;">总共：</span>
						<span class="total" style="font: 15px;color: red;">0</span>
						<span class="￥" style="font: 15px;color: red;">元</span>
						<input type="submit" value="结账" style="width: 80px;height: 30px;"/>
						<a hrey="Cart"><span id="showMoney" style="width: 100px;height: 30px;border:1px solid #00f;">查看账户余额</span></a>
					</div>
				</div>
			</form>
		</div>
</body>
	<script type="text/javascript">
	$("#sel").change(function (e){
		var number=$(this).find("option:selected").text();
		var money =$(this).parent().parent().prev().find("#money").text();
		var tota=number*money;
		$(this).parent().parent().prev().find("#tot").text(tota);
		});
	
	//获取当前用户账户余额
	$("#showMoney").click(function(){
		alert("你的账户当前余额为：￥<%=user.getMoney()%>元 ")
	})
	//全选
	$("#selectAll").click(function(){   
    	if(this.checked){   
     	   $(".select :checkbox").prop("checked", true);  
    	}else{   
			$(".select :checkbox").prop("checked", false);
    	}   
	});
	//删除
	$(".delete").click(function(){
		$(this).parent().parent().parent().remove();
		
	})
	<%=request.getAttribute("alert")%>
	</script>
</html>