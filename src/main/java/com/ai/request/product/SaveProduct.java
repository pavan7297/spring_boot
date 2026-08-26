package com.ai.request.product;

import com.ai.entity.ProductCategory;
import com.ai.entity.ProductDetails;
import com.ai.entity.ProductRating;
import com.ai.entity.ProductStore;

import jakarta.persistence.OneToOne;

public record SaveProduct(
		 String productName,
		 ProductDetails productDetails,
		 ProductRating productRateing,
		 ProductCategory productCategory,
		 ProductStore productStore
		) {

}
