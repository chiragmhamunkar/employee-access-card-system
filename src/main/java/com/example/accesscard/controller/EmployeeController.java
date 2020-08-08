package com.example.accesscard.controller;

import com.example.accesscard.dto.*;
import com.example.accesscard.entity.AccessCard;
import com.example.accesscard.entity.Employee;
import com.example.accesscard.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public PageResponse<EmployeeDTO> fetchAll(PageRequestParams prp, EmployeeFilterSortRequest filter){
        log.info("Request received to fetch employees with filter: {} and page: {}", filter, prp);
        Pageable pageable = PageRequest.of(prp.getPage(), prp.getSize());
        Page<Employee> employeePage = employeeService.findAll(filter.toFilter(), filter.toSortOrders(), pageable);
        return solve(employeePage, prp);
    }

    @GetMapping("/location")
    public PageResponse<EmployeeDTO> fetchByLocation(@RequestParam(name = "locationId", required = true) int locationId,
                                          PageRequestParams prp){
        log.info("Request received to fetch all employees under locationId: {}", locationId);
        Page<Employee> employeePage = employeeService.findAllEmployeesUnderLocation(locationId, PageRequest.of(prp.getPage(), prp.getSize()));
        return solve(employeePage, prp);
    }

    public PageResponse<EmployeeDTO> solve(Page<Employee> employeePage, PageRequestParams prp){
        List<EmployeeDTO> data = employeePage.get().map(EmployeeDTO :: from).collect(Collectors.toList());
        return PageResponse.<EmployeeDTO>builder()
                .pageNo(prp.getPage())
                .pageSize(prp.getSize())
                .totalSize(employeePage.getTotalElements())
                .totalPages(employeePage.getTotalPages())
                .data(data)
                .dataSize(data.size())
                .build();
    }

    @PostMapping
    public Employee create(@RequestBody CreateEmployeeRequest rq){
        return employeeService.save(CreateEmployeeRequest.toEntity(rq));
    }

    @PostMapping("/{id}/access-card")
    public AccessCard assignAccessCard(@RequestBody CreateAccessCardRequest rq, @PathVariable("id") int srNo){
        return employeeService.assignAccessCard(srNo, rq.getCardId(), rq.getAccessAttributes());

    }


}
