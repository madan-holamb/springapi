package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PotOrder;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

	  @Autowired
	  OrderService orderservice;
	
	  @PostMapping
	  public ResponseEntity<String> createOrder(@RequestBody List<PotOrder> PotOrder) {
		  orderservice.createOrder(PotOrder);
		  return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
	  }
	
	
	  @GetMapping(path="/{orderId}")
	  public @ResponseBody Optional<PotOrder> getOrder (@PathVariable String orderId) {
		    return orderservice.findOrder(Integer.parseInt(orderId));
	  }
	  
	  
	  @GetMapping
	  public ResponseEntity<List<PotOrder>> getORders() {
		    return new ResponseEntity<>(orderservice.findAllOrder(), HttpStatus.OK);
	  }
	
	
}
