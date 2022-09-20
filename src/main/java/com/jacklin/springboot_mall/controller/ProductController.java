package com.jacklin.springboot_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jacklin.springboot_mall.model.Product;
import com.jacklin.springboot_mall.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products/{productid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productid){
		Product product = productService.getProductById(productid);
		if (productid != null) {
			return ResponseEntity.status(HttpStatus.OK).body(product);
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();		
			}
		
		
		
	}

}
