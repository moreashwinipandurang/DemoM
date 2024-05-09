package com.microOne.productservice.service;

import com.microOne.productservice.dto.ProductRequest;
import com.microOne.productservice.dto.ProductResponse;
import com.microOne.productservice.model.Product;
import com.microOne.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest)
    {
            Product product = Product.builder()
                    .id(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .build();

        productRepository.save(product);
        log.info("product {} save sucessfully"+product.getId());
    }

    public List<ProductResponse> getAllProduct() {
        List <Product> products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
