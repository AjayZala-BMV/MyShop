package com.projects.myshop.enitity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ProductDetailsEntity {

	@Id
	private String id;
	
	private String typeId;
	
	private String productCompany;
	
	private String productModel;
	
	private String productColour;
	
	private String size;
	
	private int ram;
	
	private int rom;
	
	private int productQuantity;
	
	private int productPrice;
	
	
	public ProductDetailsEntity() {
		setId(generateProductDetailsCode());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public String getProductCompany() {
		return productCompany;
	}


	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}


	public String getProductModel() {
		return productModel;
	}


	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}


	public String getProductColour() {
		return productColour;
	}


	public void setProductColour(String productColour) {
		this.productColour = productColour;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public int getRom() {
		return rom;
	}


	public void setRom(int rom) {
		this.rom = rom;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public String generateProductDetailsCode() {
		int min = 1000;  
		int max = 9999;
		int b = (int)(Math.random()*(max-min+1)+min);  
		return "DETAILID"+String.valueOf(b);	
	}
}
