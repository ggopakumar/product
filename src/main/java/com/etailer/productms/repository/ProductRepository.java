package com.etailer.productms.repository;

import com.etailer.productms.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
