package com.shopping.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;
@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fname;
	private String lname;
	@Email
	@Column(unique=true )
	private String email;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	private List<Address> address_List;
	@NumberFormat
	private String contact_no;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	private List<CustomerOrder> order_List;
	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="person")
	private UserAccount user_Account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddress_List() {
		return address_List;
	}
	public void setAddress_List(List<Address> address_List) {
		this.address_List = address_List;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public List<CustomerOrder> getOrder_List() {
		return order_List;
	}
	public void setOrder_List(List<CustomerOrder> order_List) {
		this.order_List = order_List;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public UserAccount getUser_Account() {
		return user_Account;
	}
	public void setUser_Account(UserAccount user_Account) {
		this.user_Account = user_Account;
	}
	
	

}
