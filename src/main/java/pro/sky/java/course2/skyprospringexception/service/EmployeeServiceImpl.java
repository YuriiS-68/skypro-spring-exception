package pro.sky.java.course2.skyprospringexception.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.exception.ArrayIsFullException;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.Arrays;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Employee[] employees = new Employee[3];

    @Override
    public String addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
                employees[i] = createEmployee(firstName, lastName);
                break;
            }
            if (employees[i] != null && i == employees.length - 1){
                throw new ArrayIsFullException();
            }
        }
        return Arrays.toString(employees);
    }

    @Override
    public String delEmployee(String firstName, String lastName) {
        boolean isExist = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null
                    && employees[i].getFirstName().equals(firstName)
                    && employees[i].getLastName().equals(lastName)){
                employees[i] = null;
                isExist = true;
            }
        }
        if (!isExist){
            throw new NoExistEmployeeException();
        }
        return Arrays.toString(employees);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee foundEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                foundEmployee = employee;
            }
        }
        if (foundEmployee == null){
            throw new NoExistEmployeeException();
        }
        return foundEmployee;
    }

    private Employee createEmployee(String firstName, String lastName){
        Employee employee = new Employee();
        if (firstName != null && lastName != null){
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
        }
        return employee;
    }
}
