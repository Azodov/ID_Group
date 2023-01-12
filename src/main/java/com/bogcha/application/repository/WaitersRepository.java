package com.bogcha.application.repository;

import com.bogcha.application.domain.waiter.Waiters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitersRepository extends JpaRepository<Waiters, Long> {

}
