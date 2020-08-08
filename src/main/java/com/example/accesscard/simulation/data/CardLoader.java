package com.example.accesscard.simulation.data;

import com.example.accesscard.entity.Card;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardLoader {

    public static List<Card> get(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(50001, 1, "123456789"));
        cards.add(new Card(50002, 1, "123456789"));
        cards.add(new Card(50003, 1, "123456789"));
        cards.add(new Card(50004, 1, "123456789"));
        cards.add(new Card(50005, 1, "123456789"));
        cards.add(new Card(50006, 1, "123456789"));
        cards.add(new Card(50007, 1, "987654321"));
        cards.add(new Card(50008, 1, "987654321"));
        cards.add(new Card(50009, 1, "987654321"));
        cards.add(new Card(50010, 1, "987654321"));
        cards.add(new Card(50011, 1, "987654321"));

        return cards;
    }
}
