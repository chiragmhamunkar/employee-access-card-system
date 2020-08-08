package com.example.accesscard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeFilterSortRequest {

    private List<String> employeeIds;
    private List<Integer> locationIds;
    private List<Integer> cardIds;

    private String[] sorts;

    public EmployeeFilter toFilter(){
        return EmployeeFilter.builder()
                .employeeIds(employeeIds)
                .locationIds(locationIds)
                .cardIds(cardIds)
                .build();
    }

    public List<EmployeeSortOrder> toSortOrders(){
        if(Objects.isNull(sorts))
            sorts = new String[]{"employeeId", "1"};
        if(!sorts[0].contains(","))
            sorts = new String[]{sorts[0] + "," + (sorts.length == 2? sorts[1]: "1")};

        return Objects.nonNull(sorts) ? Stream.of(sorts).map(this::createEmployeeSortOrderFromString)
                .collect(Collectors.toList()) : null;
    }

    private EmployeeSortOrder createEmployeeSortOrderFromString(String s) {
        String[] split = s.split(",");
        boolean isAscending = split.length == 2 && "-1".equals(split[1].trim()) ? false: true;
        return EmployeeSortOrder.builder()
                .key(split[0].trim())
                .isAscending(isAscending)
                .build();
    }
}
