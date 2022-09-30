package com.jacklin.springboot_mall.service;

import com.jacklin.springboot_mall.dto.ProductRequest;
import com.jacklin.springboot_mall.model.Product;

public interface ProductService {
	
	Product getProductById(Integer productId);
	
	Integer createProduct (ProductRequest productRequest);
	
	void updateProduct(Integer productId,ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
