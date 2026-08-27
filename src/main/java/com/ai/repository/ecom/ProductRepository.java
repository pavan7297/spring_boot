package com.ai.repository.ecom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
