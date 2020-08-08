package com.example.accesscard.simulation.data;

import com.example.accesscard.entity.AccessCard;
import com.example.accesscard.entity.Card;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccessCardDataLoader {
    public static List<AccessCard> loadAccessCards(){
        List<AccessCard> accessCards = new ArrayList<>();
        accessCards.add(new AccessCard(1, new Card(1),	1));
        accessCards.add(new AccessCard(1, new Card(2),	1));
        accessCards.add(new AccessCard(1, new Card(3),	0));
        accessCards.add(new AccessCard(2, new Card(4),	1));
        accessCards.add(new AccessCard(3, new Card(5),	1));
        accessCards.add(new AccessCard(4, new Card(6),	1));
        accessCards.add(new AccessCard(5, new Card(7),	1));
        accessCards.add(new AccessCard(6, new Card(8),	1));
        //accessCards.add(new AccessCard(7, new Card(9),	0));
        //accessCards.add(new AccessCard(8, new Card(10),	0));
        //accessCards.add(new AccessCard(9, new Card(11),	0));
        return accessCards;
    }
}
