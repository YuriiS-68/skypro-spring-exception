package pro.sky.java.course2.skyprospringexception.service;

import pro.sky.java.course2.skyprospringexception.model.Employee;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName);
    String delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
