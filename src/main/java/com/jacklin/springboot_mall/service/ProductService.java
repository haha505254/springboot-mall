package com.jacklin.springboot_mall.service;

import java.util.List;

import com.jacklin.springboot_mall.dto.ProductQueryParams;
import com.jacklin.springboot_mall.dto.ProductRequest;
import com.jacklin.springboot_mall.model.Product;

public interface ProductService {
	
	List<Product> getProducts(ProductQueryParams productQueryParams);
	
	Product getProductById(Integer productId);
	
	Integer createProduct (ProductRequest productRequest);
	
	void updateProduct(Integer productId,ProductRequest productRequest);
	
	void deleteProductById(Integer productId);
}
