package com.jacklin.springboot_mall.dao;

import com.jacklin.springboot_mall.model.Product;

public interface ProductDao {
	
	Product getProductById(Integer productId);

}
