package com.example.accesscard.dto;

import com.example.accesscard.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Status status;

    private String location;
    private List<AccessCardDTO> accessCards;


    public static EmployeeDTO from(Employee employee){
        List<AccessCardDTO> accessCardDTOS = Objects.nonNull(employee.getAccessCards()) ?
                employee.getAccessCards().stream().map(AccessCardDTO :: from).collect(Collectors.toList()) : Arrays.asList();

        return EmployeeDTO.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .status(Status.getByStatusCode(employee.getStatus()))
                .location(employee.getLocation().getLocationName())
                .accessCards(accessCardDTOS)
                .build();
    }


}
