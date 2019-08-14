package com.etailer.productms.controller;

import com.etailer.productms.model.Product;
import com.etailer.productms.service.ProductService;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value = { "", "/{id}" })
	public @NotNull Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
}
