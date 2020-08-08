package com.example.accesscard.service;

import com.example.accesscard.entity.Card;
import com.example.accesscard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    public Optional<Card> findByCardId(int cardId){
        return cardRepository.findByCardId(cardId);
    }

    public Optional<Card> findById(int id){
        return cardRepository.findById(id);
    }
}
