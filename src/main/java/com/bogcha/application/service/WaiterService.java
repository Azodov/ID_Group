package com.bogcha.application.service;

import com.bogcha.application.domain.waiter.Waiters;
import com.bogcha.application.repository.WaitersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {
    private final WaitersRepository waitersRepository;

    public WaiterService(WaitersRepository waitersRepository) {
        this.waitersRepository = waitersRepository;
    }

    public List<Waiters> findAll() {
        return waitersRepository.findAll();
    }

}
