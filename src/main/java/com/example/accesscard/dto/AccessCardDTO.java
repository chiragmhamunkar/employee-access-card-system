package com.example.accesscard.dto;


import com.example.accesscard.entity.AccessCard;
import com.example.accesscard.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccessCardDTO {

    private int cardId;
    private Status status;
    private String encoding;
    private int accessAttributes;


    public static AccessCardDTO from(AccessCard accessCard){
        Card card = accessCard.getCard();
        return AccessCardDTO.builder()
                .cardId(card.getCardId())
                .status(Status.getByStatusCode(card.getStatus()))
                .encoding(card.getEncoding())
                .accessAttributes(accessCard.getAccessAttributes())
                .build();
    }
}
