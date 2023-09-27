package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class PotOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer potorderId;
	
	
	@OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "potorder_id")
	private List<Item> items;
	
	private String orderDate;
	
	private String orderStatus;
	
	
	public Integer getPotorderId() {
		return potorderId;
	}

	public void setPotorderId(Integer potorderId) {
		this.potorderId = potorderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	
}
