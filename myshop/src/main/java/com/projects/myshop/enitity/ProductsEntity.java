package com.projects.myshop.enitity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ProductsEntity {
	@Id
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
	@GeneratedValue(generator = "product_sequence",strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String prodId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_ref_id",referencedColumnName = "id")
	private ProductDetailsEntity detailsEntity;

	public ProductDetailsEntity getProductDetailsEntity() {
		return detailsEntity;
	}
	public void setProductDetailsEntity(ProductDetailsEntity detailsEntity) {
		this.detailsEntity = detailsEntity;
	}

	private String user_ref_id;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	public ProductsEntity() {
		Date d = new Date();
		setCreatedDate(d);
		setUpdatedDate(d);
		setProdId(generateProductCode());
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String generateProductCode() {
		int min = 1000;  
		int max = 9999;
		int b = (int)(Math.random()*(max-min+1)+min);  
		return "PRODID"+String.valueOf(b);	
	}
	public String getUser_ref_id() {
		return user_ref_id;
	}
	public void setUser_ref_id(String user_ref_id) {
		this.user_ref_id = user_ref_id;
	}
	
}
