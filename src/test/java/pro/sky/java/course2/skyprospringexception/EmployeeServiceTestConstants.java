package pro.sky.java.course2.skyprospringexception;

import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class EmployeeServiceTestConstants {
    public static String FIRST_NAME = "Ivan";
    public static String LAST_NAME = "Ivanov";
    public static Integer NUMBER_DEPARTMENT = 2;
    public static Double SALARY = 360.0;

    public static String FIRST_NAME1 = "Denis";
    public static String LAST_NAME1 = "Markin";
    public static Integer NUMBER_DEPARTMENT1 = 3;
    public static Double SALARY1 = 500.0;

    public static String FIRST_NAME2 = "Kate";
    public static String LAST_NAME2 = "Blanket";
    public static Integer NUMBER_DEPARTMENT2 = 2;
    public static Double SALARY2 = 260.0;

    public static final Collection<Employee> BOOK_EMPLOYEES = List.of(
            new Employee("Ivan", "Ivanov", 2, 360.0),
            new Employee("Denis", "Markin", 3, 500.0),
            new Employee("Kate", "Blanket", 2, 260.0)
    );

    public static final Collection<Employee> BOOK_EMPLOYEES_BY_DEPARTMENT = List.of(
            new Employee("Ivan", "Ivanov", 2, 360.0),
            new Employee("Kate", "Blanket", 2, 260.0)
    );

    public static final Map<Integer, Collection<Employee>> MAP_BOOK_EMPLOYEES = Map.ofEntries(
            entry(2, List.of(
                    new Employee("Ivan", "Ivanov", 2, 360.0),
                    new Employee("Kate", "Blanket", 2, 260.0))),
            entry(3, List.of(
                    new Employee("Denis", "Markin", 3, 500.0)
            ))
    );

    public static final Map<Integer, Collection<Employee>> MAP_BOOK_EMPLOYEES_WRONG = Map.ofEntries(
            entry(2, List.of(
                    new Employee("Ivan", "Ivanov", 2, 360.0),
                    new Employee("Kate", "Blanket", 2, 260.0))),
            entry(3, List.of(
                    new Employee("Denis", "Markin", 3, 500.0),
                    new Employee("Artem", "Belkin", 3, 700.0)
            ))
    );

    public static Integer DEPARTMENT3 = 3;
    public static Integer DEPARTMENT2 = 2;
    public static Integer ILLEGAL_DEPARTMENT = 1;
    public static Double MAX_SALARY_DEPARTMENT = 360.0;
    public static Double MIN_SALARY_DEPARTMENT = 260.0;
}
