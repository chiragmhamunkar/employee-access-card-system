package com.example.accesscard.service;

import com.example.accesscard.entity.Card;
import com.example.accesscard.repository.CardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class CardServiceTestWithSpringBootTestAnnotation {

    @Autowired
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @Test
    public void findByIdNotFoundTest(){
        Mockito.when(cardRepository.findByCardId(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        Assertions.assertFalse(cardService.findByCardId(1).isPresent());

    }

    @Test
    public void findByIdFoundTest(){
        Card card = Card.builder().cardId(1).build();
        Mockito.when(cardRepository.findByCardId(Mockito.anyInt()))
                .thenReturn(Optional.of(card));

        Assertions.assertEquals(1, cardService.findByCardId(1).get().getCardId());

    }
}
