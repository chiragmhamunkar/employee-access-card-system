package com.example.accesscard.controller;

import com.example.accesscard.entity.Card;
import com.example.accesscard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> findAll(){
        return cardService.findAll();
    }
}
