package com.example.accesscard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@Data
@Entity
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int srNo;

    @Column(unique = true)
    private int cardId;
    private int status; //0 or 1
    private String encoding;

    private Long createdAt;
    private Long updatedAt;

    public Card(){
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public Card(int srNo){
        this();
        this.srNo = srNo;
    }

    public Card(int cardId, int status, String encoding){
        this();
        this.cardId = cardId;
        this.status = status;
        this.encoding = encoding;

    }

}
