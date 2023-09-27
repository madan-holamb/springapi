package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PotOrder;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orepo;
	
	public String createOrder(List<PotOrder> req) {
		
		orepo.saveAll(req);
		return "SUCCESS";
		
	}
	
public Optional<PotOrder> findOrder(Integer id) {
		
		return orepo.findById(id);
		
	}


public List<PotOrder> findAllOrder() {
	
	return orepo.findAll();
	
}
}
