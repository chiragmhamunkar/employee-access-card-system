package com.example.accesscard.dto;


import com.example.accesscard.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDTO {

    private int locationId;
    private String locationName;
    private int parentLocationId;

    public static LocationDTO from(Location location){
        return LocationDTO.builder()
                .locationId(location.getLocationId())
                .locationName(location.getLocationName())
                .parentLocationId(location.getParentLocationId())
                .build();
    }
}
