package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.exception.BadParamException;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
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

    public Employee getEmployeeMinSalaryByDepartment(Integer numberDepartment){
        if (numberDepartment == null){
            throw new BadParamException();
        }
        return employeeService.getEmployeesList().stream()
                .filter(employee -> employee.isInDepartment(numberDepartment))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NoExistEmployeeException("Employee for department number: " + numberDepartment
                    + " not found."));
    }

    public Employee getEmployeeMaxSalaryByDepartment(Integer numberDepartment){
        if (numberDepartment == null){
            throw new BadParamException();
        }
        return employeeService.getEmployeesList().stream()
                .filter(employee -> employee.isInDepartment(numberDepartment))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new NoExistEmployeeException("Employee for department number: " + numberDepartment
                        + " not found."));
    }

    public Collection<Employee> printInfoByDepartment(Integer numberDepartment) {
        if (numberDepartment == null){
            throw new BadParamException();
        }
        return employeeService.getEmployeesList().stream()
                .filter(employee -> employee.isInDepartment(numberDepartment)) //при вводе номера департамента, который
                //не существует, выдаёт пустой лист, а не ошибку. Не пойму как это исправить
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> printInfoEmployees() {
        return employeeService.getEmployeesList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
