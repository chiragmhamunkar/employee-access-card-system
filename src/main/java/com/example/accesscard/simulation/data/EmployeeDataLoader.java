package com.example.accesscard.simulation.data;

import com.example.accesscard.entity.Employee;
import com.example.accesscard.entity.Location;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeDataLoader {

    public static List<Employee> loadEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("P410001", "james", "bond", "james.bond@abc.com", 1, new Location(7)));
        employees.add(new Employee("P410002", "tom", "cruise", "tom.cruise@abc.com", 1, new Location(5)));
        employees.add(new Employee("C410001", "brad", "pitt", "brad.pitt@abc.com", 1, new Location(3)));
        employees.add(new Employee("C410002", "jenifer", "lopez", "jenifer.lopez@abc.com", 1, new Location(3)));
        employees.add(new Employee("C410003", "uma", "thurman", "uma.thurman@abc.com", 1, new Location(7)));
        employees.add(new Employee("E410001", "will", "smith", "will.smith@abc.com", 1, new Location(7)));
        return employees;
    }
}
