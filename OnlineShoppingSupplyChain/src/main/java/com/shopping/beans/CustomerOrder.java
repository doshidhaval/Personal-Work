package com.shopping.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CustomerOrder 
{
	public static String Ordering = "Ordering";
	public static String Ordered = "Ordered";
	public static String OrderApproved = "Order Approved";
	public static String Processing = "Processing";
	public static String Shipped ="Shipped";
	public static String Delivered ="Delivered";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerOrder")
	private List<OrderItem> orderItem_List;
	private int cost;
	private String status;
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderItem> getOrderItem_List() {
		return orderItem_List;
	}
	public void setOrderItem_List(List<OrderItem> orderItem_List) {
		this.orderItem_List = orderItem_List;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	

}
