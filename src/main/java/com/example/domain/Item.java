package com.example.domain;

/**
 * 商品情報を表すドメインクラス.
 * 
 * @author igamasayuki
 *
 */
public class Item {
	
	/** 商品名 */
	private String name;
	
	/** 商品料金 */
	private Integer price;


	public Item() {

	}


	public Item(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}


}
