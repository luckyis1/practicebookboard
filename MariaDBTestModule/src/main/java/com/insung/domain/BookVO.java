package com.insung.domain;

import java.util.Date;

// value Object 데이터를 전송하는데 사용하는 오브젝트
public class BookVO {
	private String book_name;
	private String name;
	private String author;
	private int price;
	private Date regdate;
	private int bno;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BookVO [book_name=" + book_name + ", name=" + name + ", author=" + author + ", price=" + price
				+ ", regdate=" + regdate + ", bno=" + bno + "]";
	}
	
	

	
	
}
