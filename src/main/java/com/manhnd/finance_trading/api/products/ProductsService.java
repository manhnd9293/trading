package com.manhnd.finance_trading.api.products;

import com.manhnd.finance_trading.api.products.dtos.CreateProductDto;
import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import com.manhnd.finance_trading.api.products.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductsService {

    private ProductsRepository productsRepository;

    public ProductEntity createProduct(CreateProductDto productCreateDto) {
        ProductEntity productEntity = ProductEntity.builder().name(productCreateDto.getName()).price(productCreateDto.getPrice()).build();
        return productsRepository.save(productEntity);
    }
}
