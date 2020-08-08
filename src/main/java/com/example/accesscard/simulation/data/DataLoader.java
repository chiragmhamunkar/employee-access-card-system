package com.example.accesscard.simulation.data;

import com.example.accesscard.entity.AccessCard;
import com.example.accesscard.entity.Card;
import com.example.accesscard.entity.Employee;
import com.example.accesscard.entity.Location;
import com.example.accesscard.repository.AccessCardRepository;
import com.example.accesscard.repository.CardRepository;
import com.example.accesscard.repository.IEmployeeRepository;
import com.example.accesscard.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DataLoader {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private AccessCardRepository accessCardRepository;

    public void loadLocations(){
        List<Location> locations = locationRepository.saveAll(LocationDataLoader.get());
        log.info("Loaded {} locations", locations.size());
    }

    public void loadCards(){
        List<Card> cards = cardRepository.saveAll(CardLoader.get());
        log.info("Loaded {} cards", cards.size());
    }

    public void loadEmployees(){
        List<Employee> employees = employeeRepository.saveAll(EmployeeDataLoader.loadEmployees());
        log.info("Loaded {} employees", employees.size());
    }

    public void loadAccessCards(){
        List<AccessCard> accessCards = accessCardRepository.saveAll(AccessCardDataLoader.loadAccessCards());
        log.info("Loaded {} accessCards", accessCards.size());
    }
}
