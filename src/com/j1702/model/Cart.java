package com.j1702.model;

public class Cart {

	private Integer id;
	private String goodsName;
	private String userName;
	private Double goodsPrice;
	private Integer goodsNumber;
	private String goodsUrl;
	private String goodsIntro;
	@Override
	public String toString() {
		return "Cart [id=" + id + ", goodsName=" + goodsName + ", userName=" + userName + ", goodsPrice=" + goodsPrice
				+ ", goodsNumber=" + goodsNumber + ", goodsUrl=" + goodsUrl + ", goodsIntro=" + goodsIntro
				+ ", getId()=" + getId() + ", getGoodsName()=" + getGoodsName() + ", getUserName()=" + getUserName()
				+ ", getGoodsPrice()=" + getGoodsPrice() + ", getGoodsNumber()=" + getGoodsNumber() + ", getGoodsUrl()="
				+ getGoodsUrl() + ", getGoodsIntro()=" + getGoodsIntro() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
}
