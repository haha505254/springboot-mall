package com.jacklin.springboot_mall.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.jacklin.springboot_mall.dao.ProductDao;
import com.jacklin.springboot_mall.model.Product;
import com.jacklin.springboot_mall.rowmapper.ProductRowMapper;

@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Product getProductById(Integer productId) {
		String sql = "select * from product where product_id = :productId";
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		
		List<Product> productList =  namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());
		
		if (productList.size()>0) {
			return productList.get(0);
		}else {
			return null;
		}
		
	}

}
