package pro.sky.java.course2.skyprospringexception.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = createEmployee(firstName, lastName);
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public void delEmployee(String firstName, String lastName) {
        boolean isExist = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) != null
                    && employees.get(i).getFirstName().equals(firstName)
                    && employees.get(i).getLastName().equals(lastName)){
                employees.remove(employees.get(i));
                isExist = true;
            }
        }
        if (!isExist){
            throw new NoExistEmployeeException();
        }
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

    @Override
    public List<Employee> getEmployeesList() {
        return employees;
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
