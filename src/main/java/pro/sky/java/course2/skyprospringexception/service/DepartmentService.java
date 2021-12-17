package pro.sky.java.course2.skyprospringexception.service;

import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> getEmployeeMinSalaryByDepartment(Integer numberDepartment);
    Optional<Employee> getEmployeeMaxSalaryByDepartment(Integer numberDepartment);
    Collection<Employee> printInfoByDepartment(Integer numberDepartment);
    Collection<Employee> printInfoEmployees();
}
