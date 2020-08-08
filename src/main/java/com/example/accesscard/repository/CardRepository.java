package com.example.accesscard.repository;

import com.example.accesscard.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//@RepositoryRestResource(collectionResourceRel = "card", path = "card")
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCardId(int cardId);
}
