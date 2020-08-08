package com.example.accesscard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeFilter {
    private List<String> employeeIds;
    private List<Integer> locationIds;
    private List<Integer> cardIds;
}
