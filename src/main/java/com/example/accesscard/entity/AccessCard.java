package com.example.accesscard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee_card_mapping")
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int srNo;
    private int empId; //this is employee.srNo

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cardId", referencedColumnName = "srNo", nullable = false)
    private Card card;

    private int accessAttributes;

    public AccessCard(int empId, Card card, int accessAttributes){
        this.empId = empId;
        this.card = card;
        this.accessAttributes = accessAttributes;
    }

    //TODO: We have to keep (empId + card.cardId) unique in this table.
    // No two or more employee should have same card
}
