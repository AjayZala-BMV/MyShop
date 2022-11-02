package com.projects.myshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projects.myshop.enitity.ProductDetailsEntity;
import com.projects.myshop.enitity.ProductsEntity;

@Repository
public interface ManageProductRepository extends JpaRepository<ProductsEntity, Long>{
	@Query(value = "SELECT * FROM myshop_db.products_entity where prod_id = ?1",nativeQuery = true)
	Optional<ProductsEntity> findByProductsEntityProdId(String prodId);
}
