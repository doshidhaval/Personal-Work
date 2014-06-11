package com.shopping.beans;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manufacturer")
	private List<Person> person_List;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manufacturer")
	private List<Product> product_List;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manufacturer")
	private List<Warehouse> warehouse_List;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getPerson_List() {
		return person_List;
	}
	public void setPerson_List(List<Person> person_List) {
		this.person_List = person_List;
	}
	public List<Product> getProduct_List() {
		return product_List;
	}
	public void setProduct_List(List<Product> product_List) {
		this.product_List = product_List;
	}
	public List<Warehouse> getWarehouse_List() {
		return warehouse_List;
	}
	public void setWarehouse_List(List<Warehouse> warehouse_List) {
		this.warehouse_List = warehouse_List;
	}
	
	

}
