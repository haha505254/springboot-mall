package com.jacklin.springboot_mall.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacklin.springboot_mall.constant.ProductCategory;
import com.jacklin.springboot_mall.dto.ProductQueryParams;
import com.jacklin.springboot_mall.dto.ProductRequest;
import com.jacklin.springboot_mall.model.Product;
import com.jacklin.springboot_mall.service.ProductService;


@Validated
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(
			@RequestParam(required = false) ProductCategory category,
			@RequestParam(required = false) String search, 
			@RequestParam(defaultValue = "created_date") String orderBy,
			@RequestParam(defaultValue = "desc") String sort,
			@RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
			@RequestParam(defaultValue = "0") @Min(0) Integer offset
			
			) {
		ProductQueryParams productQueryParams = new ProductQueryParams();
		productQueryParams.setCategory(category);
		productQueryParams.setSearch(search);
		productQueryParams.setOrderBy(orderBy);
		productQueryParams.setSort(sort);
		productQueryParams.setLimit(limit);
		productQueryParams.setOffset(offset);

		List<Product> productList = productService.getProducts(productQueryParams);

		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@GetMapping("/products/{productid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productid) {
		Product product = productService.getProductById(productid);
		if (product != null) {
			return ResponseEntity.status(HttpStatus.OK).body(product);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
		Integer productId = productService.createProduct(productRequest);
		Product product = productService.getProductById(productId);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);

	}

	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
			@RequestBody @Valid ProductRequest productRequest) {
		Product product = productService.getProductById(productId);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		productService.updateProduct(productId, productRequest);
		Product updateProduct = productService.getProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
		productService.deleteProductById(productId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
