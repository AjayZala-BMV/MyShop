package com.projects.myshop.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.myshop.Service.ManageProductService;
import com.projects.myshop.enitity.ProductDetailsEntity;
import com.projects.myshop.enitity.ProductTypesEntity;
import com.projects.myshop.enitity.ProductsEntity;
import com.projects.myshop.enitity.Registration;
import com.projects.myshop.model.ProductDetailsModel;
import com.projects.myshop.repository.ManageProductDetailsRepository;
import com.projects.myshop.repository.ManageProductRepository;
import com.projects.myshop.repository.ManageProductTypesRepository;

@Service
public class ManageProductServiceImpl implements ManageProductService{

	@Autowired
	ManageProductTypesRepository manageProductRepository;
	
	@Autowired
	ManageProductDetailsRepository detailsRepository;
	
	@Autowired 
	ManageProductRepository manageproductRepository;
	

	
	@Override
	public ProductTypesEntity addNewProductTypes(String typeName) {
		// TODO Auto-generated method stub
		ProductTypesEntity pdType = new ProductTypesEntity();
		pdType.setTypeName(typeName);
		
		return manageProductRepository.save(pdType) ;
	}

	@Override
	public ProductsEntity addNewProduct(ProductDetailsModel detailsModel,Registration re) {
		ProductDetailsEntity pdDetails = new ProductDetailsEntity();
		pdDetails.setTypeId(detailsModel.getTypeId());
		pdDetails.setProductCompany(detailsModel.getProductCompany());
		pdDetails.setProductModel(detailsModel.getProductModel());
		pdDetails.setProductColour(detailsModel.getProductColour());
		pdDetails.setSize(detailsModel.getSize());
		pdDetails.setRam(detailsModel.getRam());
		pdDetails.setRom(detailsModel.getRom());
		pdDetails.setProductQuantity(detailsModel.getProductQuantity());
		pdDetails.setProductPrice(detailsModel.getProductPrice());
		
		ProductsEntity p = new ProductsEntity();
		p.setUser_ref_id(re.getOrgid());
		p.setProductDetailsEntity(pdDetails);
		
		
		
		return manageproductRepository.save(p);
	}
	@Override
	public Optional<ProductsEntity> getProductById(String prodID) {
		
		Optional<ProductsEntity> pdDetails = manageproductRepository.findByProductsEntityProdId(prodID);
		
		return pdDetails;
	}

}
