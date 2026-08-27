package com.ai.request.product;

import java.util.List;

public record RequestProductDetails(

		String productImgUrl,

		List<String> productDescription, 
		
		List<String> productSizes, 
		
		Double productPrice, 
		
		Double productOfferPrice
		) {

}
