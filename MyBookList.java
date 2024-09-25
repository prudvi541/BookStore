package com.bookStore.bookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyBooks")
public class MyBookList {
	
	@Id
	private Integer id;
	private String name;
	private String author;
	private Integer price;
	public MyBookList() {
		
	}
	public MyBookList(Integer id, String name, String author, Integer price) {
	
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	

}
