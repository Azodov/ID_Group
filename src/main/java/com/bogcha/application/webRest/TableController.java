package com.bogcha.application.webRest;

import com.bogcha.application.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/table")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(tableService.getAllTables());
    }
}
