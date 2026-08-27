package com.ai.repository.ecom;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>{

}
