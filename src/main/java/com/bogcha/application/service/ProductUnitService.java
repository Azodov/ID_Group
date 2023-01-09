package com.bogcha.application.service;

import com.bogcha.application.domain.ProductUnit;
import com.bogcha.application.repository.ProductUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUnitService {
    private final ProductUnitRepository productUnitRepository;

    public ProductUnitService(ProductUnitRepository productUnitRepository) {
        this.productUnitRepository = productUnitRepository;
    }

    public ProductUnit save(ProductUnit productUnit){
        try {
            return productUnitRepository.save(productUnit);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ProductUnit> getAll(){
        List<ProductUnit> productUnits = productUnitRepository.findAll();
        return productUnits;
    }

    public void delete(Long id){
        productUnitRepository.deleteById(id);
    }

    public ProductUnit update(Long id, ProductUnit productUnit){
        ProductUnit productUnit1 = productUnitRepository.findById(id).orElse(null);
        if (productUnit1 == null){
            return null;
        }
        productUnit1.setUnit_of_measurement(productUnit.getUnit_of_measurement());
        return productUnitRepository.save(productUnit1);
    }

    public ProductUnit getById(Long id){
        return productUnitRepository.findById(id).orElse(null);
    }
}
