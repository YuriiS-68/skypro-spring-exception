package pro.sky.java.course2.skyprospringexception.service;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName);
    String delEmployee(String firstName, String lastName);
    String findEmployee(String firstName, String lastName);
}
