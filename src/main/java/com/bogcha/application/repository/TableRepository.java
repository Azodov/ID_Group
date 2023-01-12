package com.bogcha.application.repository;

import com.bogcha.application.domain.waiter.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Tables, Long> {

}
