package com.etailer.productms.service;

import org.springframework.validation.annotation.Validated;

import com.etailer.productms.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

	Product save(Product product);
}
