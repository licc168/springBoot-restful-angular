package com.lccf.repository;

import com.lccf.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserName(String userName);

    Optional<User> findOneByUserName(String username);

    Page<User> findAllByUserName(String username, Pageable pageable);
}
