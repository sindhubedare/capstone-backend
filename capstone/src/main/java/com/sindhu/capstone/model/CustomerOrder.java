package com.sindhu.capstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CustomerOrder") 
public class CustomerOrder {


@Id
@GeneratedValue
@Column(name = "order_id")
private long id;


@Column(name = "productId")
private String productId;

@Column(name = "productImage")
private String productImage;

@Column(name = "title")
private String title;


@Column(name = "price")
private Double price;

@Column(name = "quantity")
private long quantity;


@Column(name = "total")
private Double total;

public CustomerOrder() {
super();
}

public CustomerOrder(String productId, String productImage, String title, 
		Double price, long quantity, Double total) {
super();
this.productId = productId;
this.productImage = productImage;
this.title = title;
this.price = price;
this.quantity = quantity;
this.total = total;

}

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}

public String getProductId() {
return productId;
}

public void setProductId(String productId) {
this.productId = productId;
}

public String getProductImage() {
return productImage;
}

public void setProductImage(String productImage) {
this.productImage = productImage;
}


public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}
public long getQuantity() {
return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
}
public Double getTotal() {
return total;
}

public void setTotal(Double total) {
	this.total = total;
}

}


