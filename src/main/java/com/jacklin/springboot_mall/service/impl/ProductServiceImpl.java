package com.jacklin.springboot_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacklin.springboot_mall.dao.ProductDao;
import com.jacklin.springboot_mall.dto.ProductQueryParams;
import com.jacklin.springboot_mall.dto.ProductRequest;
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

	@Override
	public Integer createProduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		return productDao.createProduct(productRequest);
	}

	@Override
	public void updateProduct(Integer productId, ProductRequest productRequest) {
		// TODO Auto-generated method stub
		productDao.updateProduct(productId,productRequest);
	}

	@Override
	public void deleteProductById(Integer productId) {
		// TODO Auto-generated method stub
		productDao.deleteProductById(productId);
		
	}

	@Override
	public List<Product> getProducts(ProductQueryParams productQueryParams) {
		// TODO Auto-generated method stub
		return productDao.getProducts(productQueryParams);
	}

	@Override
	public Integer countProduct(ProductQueryParams productQueryParams) {
		// TODO Auto-generated method stub
		return productDao.countProduct(productQueryParams);
	}

}
