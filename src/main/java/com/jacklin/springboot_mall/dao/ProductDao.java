package com.jacklin.springboot_mall.dao;

import java.util.List;

import com.jacklin.springboot_mall.constant.ProductCategory;
import com.jacklin.springboot_mall.dto.ProductRequest;
import com.jacklin.springboot_mall.model.Product;

public interface ProductDao {
	
	List<Product> getProducts(ProductCategory categoey,String search);
	
	Product getProductById(Integer productId);
	
	Integer createProduct (ProductRequest productRequest);
	
	void updateProduct(Integer productId,ProductRequest productRequest);

	void deleteProductById(Integer productId);
}
