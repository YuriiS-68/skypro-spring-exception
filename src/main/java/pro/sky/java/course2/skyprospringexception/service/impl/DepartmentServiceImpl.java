package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.DepartmentService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    public Optional<Employee> getEmployeeMinSalaryByDepartment(Integer numberDepartment){
        return employeeService.getEmployeesList().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), numberDepartment))
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    public Optional<Employee> getEmployeeMaxSalaryByDepartment(Integer numberDepartment){
        return employeeService.getEmployeesList().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), numberDepartment))
                .max(Comparator.comparingDouble((Employee::getSalary)));
    }

    public Collection<Employee> printInfoByDepartment(Integer numberDepartment) {
        return employeeService.getEmployeesList().stream()
                .filter(employee -> employee.getDepartment().equals(numberDepartment))
                .collect(Collectors.toList());
    }

    public Collection<Employee> printInfoEmployees() {
        return new ArrayList<>(employeeService.getEmployeesList());
    }
}
