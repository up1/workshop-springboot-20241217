package com.example.hello.product;

public class ProductResponse{

	private Integer id;
	private String name;
	private Object price;

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}
}
