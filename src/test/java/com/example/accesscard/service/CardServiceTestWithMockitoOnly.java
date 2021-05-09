package com.example.accesscard.service;

import com.example.accesscard.entity.Card;
import com.example.accesscard.repository.CardRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

//This is far faster than `CardServiceTestWithSpringBootTestAnnotation` cause this doesn't load whole context
public class CardServiceTestWithMockitoOnly {

    @InjectMocks
    private CardService cardService;

    @Mock
    private CardRepository cardRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

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
