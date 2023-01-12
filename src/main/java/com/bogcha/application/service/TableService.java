package com.bogcha.application.service;

import com.bogcha.application.domain.waiter.Tables;
import com.bogcha.application.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Tables> getAllTables(){
        return tableRepository.findAll();
    }
}
