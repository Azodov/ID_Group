package com.bogcha.application.webRest;

import com.bogcha.application.domain.ProductUnit;
import com.bogcha.application.service.ProductUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unit")
public class ProductUnitController {
    private final ProductUnitService productTypeService;

    public ProductUnitController(ProductUnitService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/units")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productTypeService.getAll());
    }

    @GetMapping("/unit/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        if (id == null){
            return ResponseEntity.badRequest().body("Id bo'sh bo'lmasligi kerak");
        }
        ProductUnit productUnit = productTypeService.getById(id);
        if (productUnit == null){
            return ResponseEntity.badRequest().body("Bunday ID da ma'lumot mavjud emas");
        }
        return ResponseEntity.ok(productUnit);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductUnit productUnit){
        ProductUnit productUnit1 = productTypeService.save(productUnit);
        if (productUnit1 == null){
            return ResponseEntity.badRequest().body("Xatolik");
        }
        return ResponseEntity.ok(productUnit1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productTypeService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductUnit productUnit){
        ProductUnit productUnit1 = productTypeService.update(id, productUnit);
        if (productUnit1 == null){
            return ResponseEntity.badRequest().body("Xatolik");
        }
        return ResponseEntity.ok(productUnit1);
    }
}