package com.ai.repository.ecom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.entity.ProductRating;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, String>{

}
