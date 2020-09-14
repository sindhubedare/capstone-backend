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
import com.sindhu.capstone.model.ContactForm;
import com.sindhu.capstone.repository.ContactFormRepository;


@RestController
@RequestMapping("/sindhu_api/v1")

public class ContactFormController {
	
	  @Autowired
	  private ContactFormRepository contactFormRepository;
	  
	//  get all reviews
	  

	  @GetMapping("/form")
	  public List<ContactForm> getAllReviews(Model model) {
	  	
	  return this.contactFormRepository.findAll();
	  
	}
	  
	  
	//  get all reviews by id

	  @GetMapping("/form/{id}")
	  public ResponseEntity<ContactForm> getReviewById(@PathVariable(value = "id") Long reviewId)
	      throws ResourceNotFoundException {
		  ContactForm review = contactFormRepository.findById(reviewId)
	        .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
	      return ResponseEntity.ok().body(review);
	  }
	  
	//  save reviews
	  
	  @PostMapping("/form")
	  public ContactForm createReview(@Valid @RequestBody ContactForm review) {
		  return contactFormRepository.save(review);
	  }
	  
	//  Update Review
	  
		  @PutMapping("/form/{id}")
		  public ResponseEntity<ContactForm> updateReview(@PathVariable(value = "id") Long reviewId,
				  @Valid @RequestBody ContactForm reviewDetails)
			      throws ResourceNotFoundException {
			  ContactForm review = contactFormRepository.findById(reviewId)
			    		  .orElseThrow(()-> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
			      
			  review.setReview(reviewDetails.getReview()); 
			  review.setEmail(reviewDetails.getEmail());
			    	    
			     
			     final ContactForm updatedReview = contactFormRepository.save(review);
			     
			     
			     return ResponseEntity.ok(updatedReview);
			      
			      }
		  
		//  Delete Review
		  
		  @DeleteMapping("/form/{id}")
		  public Map<String, Boolean> deletedReview(@PathVariable(value = "id") Long reviewId)
					      throws ResourceNotFoundException {
			  ContactForm review = contactFormRepository.findById(reviewId)
					    		  .orElseThrow(()-> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
		  
			  contactFormRepository.delete(review);
					      Map<String, Boolean> response = new HashMap<>();
					      
					      response.put("deleted review", Boolean.TRUE);
					      
					      return response;
		  
		  }
		  
		  
}
