package com.bogcha.application.repository;

import com.bogcha.application.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userUser);

    @Query("select u from User u where u.userName = :userName")
    User findByLogin(@Param("userName") String userName);

    boolean existsByUserName(String userName);

}
