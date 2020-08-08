package com.example.accesscard.repository;

import com.example.accesscard.entity.AccessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessCardRepository extends JpaRepository<AccessCard, Integer> {
}
