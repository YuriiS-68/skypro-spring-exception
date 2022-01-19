package pro.sky.java.course2.skyprospringexception;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.skyprospringexception.EmployeeServiceTestConstants.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.skyprospringexception.exception.BadParamException;
import pro.sky.java.course2.skyprospringexception.exception.NoExistEmployeeException;
import pro.sky.java.course2.skyprospringexception.service.impl.DepartmentServiceImpl;
import pro.sky.java.course2.skyprospringexception.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp(){
        out = new DepartmentServiceImpl(employeeService);
        when(employeeService.getEmployeesList()).thenReturn(BOOK_EMPLOYEES);
    }

    @Test
    void getEmployeeMinSalaryByDepartmentTest(){
        assertEquals(MIN_SALARY_DEPARTMENT, out.getEmployeeMinSalaryByDepartment(DEPARTMENT2).getSalary());
    }

    @Test
    void getEmployeeMaxSalaryByDepartmentTest(){
        assertEquals(MAX_SALARY_DEPARTMENT, out.getEmployeeMaxSalaryByDepartment(DEPARTMENT2).getSalary());
    }

    @Test
    void shouldBeThrowsNoExistEmployeeExceptionGetMinSalary(){
        assertThrows(NoExistEmployeeException.class, () -> out.getEmployeeMinSalaryByDepartment(ILLEGAL_DEPARTMENT));
    }

    @Test
    void shouldBeThrowsNoExistEmployeeExceptionGetMaxSalary(){
        assertThrows(NoExistEmployeeException.class, () -> out.getEmployeeMaxSalaryByDepartment(ILLEGAL_DEPARTMENT));
    }

    @Test
    void printInfoByDepartmentTestIsOk() {
        assertTrue(BOOK_EMPLOYEES_BY_DEPARTMENT.containsAll(out.printInfoByDepartment(DEPARTMENT2)));
    }

    @Test
    void printInfoByDepartmentTestIsFailed() {
        assertFalse(BOOK_EMPLOYEES_BY_DEPARTMENT.containsAll(out.printInfoByDepartment(DEPARTMENT3)));
    }

    @Test
    void shouldBeThrowsBadParamExceptionPrintInfoByDepartment(){
        assertThrows(BadParamException.class, () -> out.printInfoByDepartment(ILLEGAL_DEPARTMENT));
    }

    @Test
    void printInfoEmployeesTestIsOk(){
        assertEquals(MAP_BOOK_EMPLOYEES, out.printInfoEmployees());
    }

    @Test
    void printInfoEmployeesTestIsFailed(){
        assertNotEquals(MAP_BOOK_EMPLOYEES_WRONG, out.printInfoEmployees());
    }
}
