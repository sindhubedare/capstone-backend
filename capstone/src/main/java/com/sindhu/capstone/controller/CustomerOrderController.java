package com.sindhu.capstone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.capstone.exception.ResourceNotFoundException;
import com.sindhu.capstone.model.CustomerOrder;
import com.sindhu.capstone.repository.CustomerOrderRepository;



@RestController
@RequestMapping("/sindhu_api/v1")

public class CustomerOrderController {
	
	@Autowired
	private CustomerOrderRepository customerOrderRepository;

    
//  get all orders
  

  @GetMapping("/orders")
  public List<CustomerOrder> getAllEmployees(Model model) {
  	
  return this.customerOrderRepository.findAll();
  
}

    
//  get all products by id

  @GetMapping("/orders/{id}")
  public ResponseEntity<CustomerOrder> getOrderById(@PathVariable(value = "id") Long orderId)
      throws ResourceNotFoundException {
	  CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
      return ResponseEntity.ok().body(customerOrder);
  }
  
  
//  @GetMapping("/orders/{category}")
//  public ResponseEntity<List<CustomerOrder>> getOrderById(@PathVariable(value = "category") String category)
//      throws ResourceNotFoundException {
//	  List<CustomerOrder> customerOrder = ((List<CustomerOrder>) customerOrderRepository.findByCategory(category));
////        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
//      return ResponseEntity.ok().body(customerOrder);
//  }
//  save employee
  
  @PostMapping("/orders")
  public CustomerOrder createOrder(@Valid @RequestBody CustomerOrder customerOrder) {
	  return customerOrderRepository.save(customerOrder);
  }
  
//  Update Order
  
  @PutMapping("/orders/{id}")
  public ResponseEntity<CustomerOrder> updateOrder(@PathVariable(value = "id") Long orderId,
		  @Valid @RequestBody CustomerOrder customerOrderDetails)
	      throws ResourceNotFoundException {
	  CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
	    		  .orElseThrow(()-> new ResourceNotFoundException("updatedOrder not found for this id :: " + orderId));
	      
	     
	  customerOrder.setProductId(customerOrderDetails.getProductId()); 
	  customerOrder.setProductImage(customerOrderDetails.getProductImage());
	  customerOrder.setTitle(customerOrderDetails.getTitle());
	  customerOrder.setPrice(customerOrderDetails.getPrice());
	  customerOrder.setQuantity(customerOrderDetails.getQuantity());
	  customerOrder.setTotal(customerOrderDetails.getTotal());
	     
	     
	     final CustomerOrder updatedOrder = customerOrderRepository.save(customerOrder);
	     
	     
	     return ResponseEntity.ok(updatedOrder);
	      
	      }
  
//  Delete Order
  
  @DeleteMapping("/orders/{id}")
  public Map<String, Boolean> deletedOrder(@PathVariable(value = "id") Long orderId)
			      throws ResourceNotFoundException {
	  CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
			    		  .orElseThrow(()-> new ResourceNotFoundException("customerOrder not found for this id :: " + orderId));
  
			      customerOrderRepository.delete(customerOrder);
			      Map<String, Boolean> response = new HashMap<>();
			      
			      response.put("deleted customerOrder", Boolean.TRUE);
			      
			      return response;
  
  }
  
//  @DeleteMapping("/orders")
//  public List<CustomerOrder> deleteAllOrders(Model model) {
//  	
//  return this.customerOrderRepository.findAll();
//  
//}
  
}
