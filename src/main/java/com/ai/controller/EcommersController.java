package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.entity.Product;
import com.ai.request.product.RequestSaveProduct;
import com.ai.service.EcomServices;
import com.ai.utills.Generator;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/ecom")
@Slf4j
public class EcommersController {

	@Autowired
	private EcomServices services;

	@Autowired
	private Generator random;

	@GetMapping("/allproducts")
	public ResponseEntity<?> getAllProducts() {
		try {
			log.info("");
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * author: pavan requestType:post url:http://localhost:2323/api/v1/ecom/saveData
	 * bodyjson:{ "productName": "t-shirt from aadidos", "productDetails": {
	 * "productImgUrl": "av1.jpg", "productDescription": [ "This is a cotton dress",
	 * "Fiber is 2 mm length" ], "productSizes": [ "S", "M", "L", "XL" ],
	 * "productPrice": 23.00, "productOfferPrice": 23.00 }, "productRateing": {
	 * "productRatingAvgRate": 2.5, "productRatingMessage": "it is good",
	 * "productRatingRate": 2.5 }, "productCategory": { "category": "men",
	 * "subCategory1": "t-shirt", "subCategory2": "n/a", "subCategory3": "n/a" },
	 * "productStore": { "product_store_count": 2, "product_store_view": false } }
	 */
	@Operation(summary = "Save the product", description = "save the product to store data.")
	@PostMapping("/saveData")
	public ResponseEntity<?> saveSingleProduct(@RequestBody RequestSaveProduct product) throws InvalidDataAccessApiUsageException {
		try {

			String checks = random.randomGenerator();

			log.info("Product requestId: {} | Request product: {}", checks, product);

			Product saved = services.SaveProduct(product);

			log.info("Product requestId: {} | Saved product: {}", checks, saved);

			return ResponseEntity.accepted().body(saved);

		} catch (Exception e) {
			log.error("Error while saving product", e);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to save product: " + e.getMessage());
		}
	}

}
