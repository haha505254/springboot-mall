package com.jacklin.springboot_mall.dto;


import javax.validation.constraints.NotNull;

import com.jacklin.springboot_mall.constant.ProductCategoey;

public class ProductRequest {
	
	@NotNull
	private String product_name      ;
	@NotNull
	private ProductCategoey category          ;
	@NotNull
	private String image_url         ;
	@NotNull
	private Integer price             ;
	@NotNull
	private Integer stock             ;
	private String description       ;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public ProductCategoey getCategory() {
		return category;
	}
	public void setCategory(ProductCategoey category) {
		this.category = category;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
