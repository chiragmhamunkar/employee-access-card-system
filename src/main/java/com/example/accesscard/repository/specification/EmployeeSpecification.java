package com.example.accesscard.repository.specification;

import com.example.accesscard.dto.EmployeeFilter;
import com.example.accesscard.dto.EmployeeSortOrder;
import com.example.accesscard.entity.Employee;
import com.example.accesscard.util.Util;
import lombok.AllArgsConstructor;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {

    private EmployeeFilter filter;
    private List<EmployeeSortOrder> sort;

    private static Map<String, Function<Root<Employee>, Expression<?>>> keyToExpressionMap = new HashMap<>();

    static {
        keyToExpressionMap.put("employeeId", rt -> rt.get("employeeId"));
        keyToExpressionMap.put("email", rt -> rt.get("email"));
        keyToExpressionMap.put("firstName", rt -> rt.get("firstName"));
        keyToExpressionMap.put("lastName", rt -> rt.get("lastName"));
        keyToExpressionMap.put("locationId", rt -> rt.join("location").get("locationId"));
    }

    public static EmployeeSpecification from(EmployeeFilter filter, List<EmployeeSortOrder> sort){
        return new EmployeeSpecification(filter, sort);
    }

    public static EmployeeSpecification from(EmployeeFilter filter){
        return new EmployeeSpecification(filter, null);
    }

    public static EmployeeSpecification from(List<EmployeeSortOrder> sort){
        return new EmployeeSpecification(null, sort);
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(!Util.isEmpty(filter.getEmployeeIds()))
        predicates.add(root.get("employeeId").in(filter.getEmployeeIds()));

        if(!Util.isEmpty(filter.getLocationIds()))
            predicates.add(root.join("location").get("locationId").in(filter.getLocationIds()));

        if(!Util.isEmpty(filter.getCardIds()))
            predicates.add(
                    root.join("accessCards")
                    .join("card")
                    .get("cardId")
                    .in(filter.getCardIds())
            );


        if(!Util.isEmpty(sort)){
            List<Order> orders = sort.stream()
                    .map(es -> createOrder(es, root))
                    .filter(orderOptional -> orderOptional.isPresent())
                    .map(orderOptional -> orderOptional.get())
                    .collect(Collectors.toList());

            if(!Util.isEmpty(orders)) query.orderBy(orders);
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    private Optional<Order> createOrder(EmployeeSortOrder employeeSortOrder, Root<Employee> root) {
        return getAttrExpression(root, employeeSortOrder.getKey())
                .map(exp -> new OrderImpl(exp, employeeSortOrder.isAscending()));
    }

    private Optional<Expression<?>> getAttrExpression(Root<Employee> root, String key) {
        return Optional.ofNullable(keyToExpressionMap.get(key)).map(fn -> fn.apply(root));
    }

}
