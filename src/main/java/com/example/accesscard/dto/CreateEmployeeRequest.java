package com.example.accesscard.dto;

import com.example.accesscard.entity.Employee;
import com.example.accesscard.entity.Location;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private int status; //0 (inactive) or 1 (active)
    private int locationId;

    public static Employee toEntity(CreateEmployeeRequest cER){

        return Employee.builder()
                .employeeId(cER.employeeId)
                .firstName(cER.firstName)
                .lastName(cER.lastName)
                .email(cER.lastName)
                .status(cER.status)
                .location(Location.builder().locationId(cER.locationId).build())
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .build();

    }
}
