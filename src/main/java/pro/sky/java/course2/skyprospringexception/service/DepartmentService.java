package pro.sky.java.course2.skyprospringexception.service;

import pro.sky.java.course2.skyprospringexception.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeMinSalaryByDepartment(Integer numberDepartment);

    Employee getEmployeeMaxSalaryByDepartment(Integer numberDepartment);

    Collection<Employee> printInfoByDepartment(Integer numberDepartment);

    Map<Integer, List<Employee>> printInfoEmployees();
}
