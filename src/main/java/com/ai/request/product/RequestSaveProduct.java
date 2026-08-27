package com.ai.request.product;

import com.ai.entity.ProductCategory;


public record RequestSaveProduct(
		 String productName,
		 RequestProductDetails productDetails,
		 RequestProductRating productRateing,
		 RequestProductCategory productCategory,
		 RequestProductStore productStore
		) {

}
