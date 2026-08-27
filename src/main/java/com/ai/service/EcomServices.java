package com.ai.service;

import com.ai.repository.ecom.ProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.entity.Product;
import com.ai.entity.ProductCategory;
import com.ai.entity.ProductDetails;
import com.ai.entity.ProductRating;
import com.ai.entity.ProductStore;
import com.ai.repository.ecom.ProductRepository;
import com.ai.request.product.RequestSaveProduct;

@Service
public class EcomServices {

	private final ProductStoreRepository productStoreRepository;
	@Autowired
	private ProductRepository repo;

	EcomServices(ProductStoreRepository productStoreRepository) {
		this.productStoreRepository = productStoreRepository;
	}

	public Product SaveProduct(RequestSaveProduct pro) {
		
		
		Product product = new Product();
		
		ProductCategory category = new ProductCategory();
		
		ProductDetails details = new ProductDetails();
		
		ProductRating rating = new ProductRating();
		
		ProductStore store = new ProductStore();
		
		product.setProductName(pro.productName());
		
		category.setCategory(pro.productCategory().category());
		category.setSubCategory1(pro.productCategory().subCategory1());
		category.setSubCategory2(pro.productCategory().subCategory2());
		category.setSubCategory3(pro.productCategory().subCategory3());
		
		product.setProductCategory(category);
		
		details.setProductDescription(pro.productDetails().productDescription());
		details.setProductImgUrl(pro.productDetails().productImgUrl());
		details.setProductPrice(pro.productDetails().productPrice());
		details.setProductOfferPrice(pro.productDetails().productOfferPrice());
		details.setProductSizes(pro.productDetails().productSizes());
		
		product.setProductDetails(details);
		
		rating.setProductRatingMessage(pro.productRateing().productRatingMessage());
		rating.setProductRatingRate(pro.productRateing().productRatingRate());
		rating.setProductRatingAvgRate(pro.productRateing().productRatingAvgRate());
		
		product.setProductRateing(rating);
		
		store.setProduct_store_count(pro.productStore().product_store_count());
		store.setProduct_store_view(pro.productStore().product_store_view());
		
		product.setProductStore(store);
		
		return repo.save(product);

	}

}
