package com.shopping.beans;

import javax.persistence.*;

@Entity
public class OrderItem 
{	
	public static String Processing = "Processing";
	public static String Shipped ="Shipped";
	public static String Delivered ="Delivered";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private int quantity;
	private int total;
	private String status;
	@ManyToOne
	@JoinColumn(name="order_id")
	private CustomerOrder customerOrder;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public CustomerOrder getOrder() {
		return customerOrder;
	}
	public void setOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	

}
