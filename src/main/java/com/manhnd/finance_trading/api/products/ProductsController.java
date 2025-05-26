package com.manhnd.finance_trading.api.products;

import com.manhnd.finance_trading.api.products.dtos.CreateProductDto;
import com.manhnd.finance_trading.api.products.entites.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductsService productsService;

    @PostMapping("/")
    public ProductEntity createProduct(@RequestBody CreateProductDto productCreateDto) {
        return this.productsService.createProduct(productCreateDto);
    }
}
