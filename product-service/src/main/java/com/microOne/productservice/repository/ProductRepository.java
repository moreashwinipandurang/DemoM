package com.microOne.productservice.repository;

import com.microOne.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>
{
}
