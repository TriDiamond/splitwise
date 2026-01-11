package com.design.backend.splitwise.repository;

import com.design.backend.splitwise.model.ExpenseGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, Long> {
    Optional<ExpenseGroup> findByGroupName(String groupName);
}
