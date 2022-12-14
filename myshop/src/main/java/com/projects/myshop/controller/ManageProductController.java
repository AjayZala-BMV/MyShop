package com.projects.myshop.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.myshop.Service.ManageProductService;
import com.projects.myshop.config.InfoClass;
import com.projects.myshop.config.ResponseMessageClass;
import com.projects.myshop.enitity.OrganizationEntity;
import com.projects.myshop.enitity.ProductDetailsEntity;
import com.projects.myshop.enitity.ProductTypesEntity;
import com.projects.myshop.enitity.ProductsEntity;
import com.projects.myshop.enitity.Registration;
import com.projects.myshop.model.ProductDetailsModel;


@RestController
public class ManageProductController {

	@Autowired
	ManageProductService manageProductService;
	
	@PostMapping("/addNewProductTypes/{typeName}")
	public ResponseEntity<ResponseMessageClass<Object>>addNewProductTypes(@PathVariable("typeName") String typeName, HttpServletRequest request){

		Registration re = InfoClass.getCurrentUser(request);	
		if(re != null) {	
			ProductTypesEntity pdtype = manageProductService.addNewProductTypes(typeName);
			if(pdtype != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageClass<Object>("New Type Added Successfully",HttpStatus.OK));
			}else {
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ResponseMessageClass<Object>("New Type Not Added, Please Try Again!!",HttpStatus.NOT_MODIFIED));
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageClass<Object>("Please Do Login First",HttpStatus.BAD_REQUEST));
		}
	}
	
	@PostMapping("/addNewProduct")
	public ResponseEntity<ResponseMessageClass<Object>>addNewProduct(@RequestBody ProductDetailsModel detailsModel, HttpServletRequest request){
		Registration re = InfoClass.getCurrentUser(request);	
		if(re != null) {	
			ProductsEntity pdDetails = manageProductService.addNewProduct(detailsModel,re);
			if(pdDetails != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageClass<Object>("New Product Added Successfully",HttpStatus.OK));

			}else {
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ResponseMessageClass<Object>("New Product Not Added, Please Try Again!!",HttpStatus.NOT_MODIFIED));
			}
		}else {		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageClass<Object>("Please Do Login First",HttpStatus.BAD_REQUEST));
		}
	}
	
	@GetMapping("/getProductById/{prodID}")
	public ResponseEntity<ResponseMessageClass<Object>>getProductById(@PathVariable("prodID") String prodID, HttpServletRequest request){
		Registration re = InfoClass.getCurrentUser(request);	
		if(re != null) {	
			 Optional<ProductsEntity>  pdDetails = manageProductService.getProductById(prodID);
			if(pdDetails.isPresent()){
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageClass<Object>(pdDetails,HttpStatus.OK));
				
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageClass<Object>("Product Not Exits",HttpStatus.BAD_REQUEST));
			}
		}else {		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageClass<Object>("Please Do Login First",HttpStatus.BAD_REQUEST));
		}
	}
}
