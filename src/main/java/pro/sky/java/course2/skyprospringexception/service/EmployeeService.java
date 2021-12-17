package pro.sky.java.course2.skyprospringexception.service;

import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer numberDepartment, Double salary);
    void delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getEmployeesList();
}
