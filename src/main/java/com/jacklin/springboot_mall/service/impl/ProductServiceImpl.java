package com.jacklin.springboot_mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacklin.springboot_mall.dao.ProductDao;
import com.jacklin.springboot_mall.model.Product;
import com.jacklin.springboot_mall.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.getProductById(productId);
	}

}
