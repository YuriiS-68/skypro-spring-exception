package pro.sky.java.course2.skyprospringexception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.skyprospringexception.exception.EmployeeAlreadyExistException;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.EmployeeService;
import pro.sky.java.course2.skyprospringexception.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static pro.sky.java.course2.skyprospringexception.EmployeeServiceTestConstants.*;

public class EmployeeServiceTest {
    private EmployeeService out = new EmployeeServiceImpl();
    private Employee employee;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp(){
        employee = new Employee(FIRST_NAME, LAST_NAME, NUMBER_DEPARTMENT, SALARY);
        employee1 = new Employee(FIRST_NAME1, LAST_NAME1, NUMBER_DEPARTMENT1, SALARY1);
        employee2 = new Employee(FIRST_NAME2, LAST_NAME2, NUMBER_DEPARTMENT2, SALARY2);
        out = new EmployeeServiceImpl();
        out.addEmployee(FIRST_NAME, LAST_NAME, NUMBER_DEPARTMENT, SALARY);
        out.addEmployee(FIRST_NAME1, LAST_NAME1, NUMBER_DEPARTMENT1, SALARY1);
        out.addEmployee(FIRST_NAME2, LAST_NAME2, NUMBER_DEPARTMENT2, SALARY2);
    }

    @Test
    public void addEmployee(){
        Collection<Employee> expected = out.getEmployeesList();
        Collection<Employee> actual = new ArrayList<>();
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

    }

    @Test
    public void shouldEmployeeAlreadyExistExceptionWhenEmployeeAlreadyExist(){
        assertThrows(EmployeeAlreadyExistException.class,
                () -> out.addEmployee(FIRST_NAME, LAST_NAME, NUMBER_DEPARTMENT, SALARY));
    }

    @Test
    public void shouldBeDelEmployee(){
        out.delEmployee(FIRST_NAME1, LAST_NAME1);
        Collection<Employee> expected = out.getEmployeesList();
        Collection<Employee> actual = new ArrayList<>();
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);
        actual.remove(employee1);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void shouldBeFindEmployee(){
        Employee expected = employee2;
        Employee found = out.findEmployee(FIRST_NAME2, LAST_NAME2);
        assertEquals(expected, found);

    }

    @Test
    public void shouldBeThrowNoExistEmployeeException(){
        out.delEmployee(FIRST_NAME1, LAST_NAME1);
        assertThrows(NoExistEmployeeException.class,
                () -> out.delEmployee(FIRST_NAME1, LAST_NAME1));
    }
}
