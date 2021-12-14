package pro.sky.java.course2.skyprospringexception.service;

import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    void delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> getEmployeesList();
}
