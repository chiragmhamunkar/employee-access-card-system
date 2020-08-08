package com.example.accesscard.service;

import com.example.accesscard.dto.EmployeeFilter;
import com.example.accesscard.dto.EmployeeSortOrder;
import com.example.accesscard.entity.AccessCard;
import com.example.accesscard.entity.Employee;
import com.example.accesscard.entity.Location;
import com.example.accesscard.repository.AccessCardRepository;
import com.example.accesscard.repository.IEmployeeRepository;
import com.example.accesscard.repository.specification.EmployeeSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private AccessCardRepository accessCardRepository;

    @Autowired
    private CardService cardService;

    public Employee save(Employee employee){
        Employee saved = employeeRepository.save(employee);
        return saved;
    }

    public Page<Employee> findAll(EmployeeFilter filter, List<EmployeeSortOrder> sorts, Pageable pageable){
        log.info("Fetching employees with filter: {}, sorts: {}, pageable: {}", filter, sorts, pageable);
        Page<Employee> page =  employeeRepository.findAll(EmployeeSpecification.from(filter, sorts), pageable);
        log.info("Found {} employees", page.getContent().size());
        return page;
    }

    public Page<Employee> findAllEmployeesUnderLocation(int locationId, Pageable pageable){
        List<Location> locations = locationService.findAllLocationsUnder(locationId);
        EmployeeFilter filter = EmployeeFilter.builder()
                .locationIds(locations.stream().map(Location::getLocationId).collect(Collectors.toList()))
                .build();
        return findAll(filter, null, pageable);
    }

    public AccessCard assignAccessCard(int srNo, int cardId, int accessAttributes) {
        return employeeRepository.findById(srNo)
                .flatMap(employee -> cardService.findById(cardId))
                .map(card -> AccessCard.builder().accessAttributes(accessAttributes).card(card).empId(srNo).build())
                .map(accessCard -> accessCardRepository.save(accessCard))
                .orElse(null);
    }
}
