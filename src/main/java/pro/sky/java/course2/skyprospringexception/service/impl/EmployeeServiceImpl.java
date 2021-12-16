package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.exception.EmployeeAlreadyExistException;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            Employee newEmployee = new Employee(firstName, lastName);
            employees.put(key, newEmployee);
            return newEmployee;
        } else {
            throw new EmployeeAlreadyExistException();
        }
    }

    @Override
    public void delEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (employees.containsKey(key)) {
            employees.remove(key);
        } else {
            throw new NoExistEmployeeException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee foundEmployee = employees.get(getKey(firstName, lastName));

        if (foundEmployee != null){
            return foundEmployee;
        } else {
            throw new NoExistEmployeeException();
        }
    }

    @Override
    public Collection<Employee> getEmployeesList() {
        return employees.values();
    }

    private String getKey(String firstName, String lastName){
        return firstName + lastName;
    }
}
