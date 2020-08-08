package com.example.accesscard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@Data
@Entity
public class Location {
    @Id
    private int locationId;
    private String locationName;
    private int parentLocationId;

    private Long createdAt;
    private Long updatedAt;

    public Location(){
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public Location(int locationId){
        this();
        this.locationId = locationId;
    }

    public Location(int locationId, String locationName, int parentLocationId){
        this(locationId);
        this.locationName = locationName;
        this.parentLocationId = parentLocationId;
    }

}
