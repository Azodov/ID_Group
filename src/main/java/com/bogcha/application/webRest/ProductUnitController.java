package com.bogcha.application.webRest;

import com.bogcha.application.domain.ProductUnit;
import com.bogcha.application.service.ProductUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeController {
    private final ProductUnitService productTypeService;

    public ProductTypeController(ProductUnitService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductUnit productUnit){
        ProductUnit productUnit1 = productTypeService.save(productUnit);
        if (productUnit1 == null){
            return ResponseEntity.badRequest().body("Xatolik");
        }
        return ResponseEntity.ok(productUnit1);
    }
}
