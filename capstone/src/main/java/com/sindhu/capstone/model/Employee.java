package com.sindhu.capstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee  {
   
 
    @Id
    @GeneratedValue
    @Column(name= "emp_id")
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name= "feedback")
    private String feedback;
 
    public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name= "last_name")
	private String lastName;
 
	@Column(name = "email")
    private String email;
 
    public Employee() {
    super();
    }
    
    public Employee(String firstName, String lastName, String email, String feedback) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.feedback = feedback;
    }
    //Getters and setters
 
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName 
        		+  ",  lastName=" + lastName + ", email=" + email  + " + feedback = " + feedback +"]";
    }
}


