package com.bogcha.application.service;

import com.bogcha.application.domain.ProductType;
import com.bogcha.application.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType save(ProductType productType){
        try {
            return productTypeRepository.save(productType);
        } catch (Exception e) {
            return null;
        }
    }
}
