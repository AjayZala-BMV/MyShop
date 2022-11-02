package com.projects.myshop.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projects.myshop.enitity.ProductDetailsEntity;
import com.projects.myshop.enitity.ProductTypesEntity;
import com.projects.myshop.enitity.ProductsEntity;
import com.projects.myshop.enitity.Registration;
import com.projects.myshop.model.ProductDetailsModel;

@Service
public interface ManageProductService {

	ProductTypesEntity addNewProductTypes(String typeName);

	ProductsEntity addNewProduct(ProductDetailsModel detailsModel,Registration re);

	 Optional<ProductsEntity>  getProductById(String prodID);

}
