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
public class Warehouse 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String location;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="warehouse")
	private List<StockItem> stockItem_List;
	
	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public List<StockItem> getStockItem_List() {
		return stockItem_List;
	}
	public void setStockItem_List(List<StockItem> stockItem_List) {
		this.stockItem_List = stockItem_List;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	

	

}
