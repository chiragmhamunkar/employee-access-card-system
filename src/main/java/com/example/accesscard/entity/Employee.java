package com.example.accesscard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int srNo;

    @Column(unique = true)
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private int status; //0 (inactive) or 1 (active)

    private Long createdAt;
    private Long updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "locationId", nullable = false)
    private Location location;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empId")
    private List<AccessCard> accessCards;

    //TODO this is not being invoked by builder
    public Employee(){
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public Employee(String employeeId, String firstName, String lastName, String email, int status, Location location){
        this();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.location = location;
    }

}
