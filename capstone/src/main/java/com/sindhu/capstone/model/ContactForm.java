package com.sindhu.capstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contactForm") 

public class ContactForm {


@Id
@GeneratedValue
@Column(name = "review_id")
private long id;


@Column(name = "review")
private String review;


@Column(name = "email")
private String email;

public ContactForm() {
super();
}

public ContactForm(String review,String email) {
super();
this.review = review;
this.email = email;
}

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}

public String getReview() {
return review;
}

public void setReview(String review) {
this.review = review;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

}
