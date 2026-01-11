package com.design.backend.splitwise.repository;

import com.design.backend.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
}
