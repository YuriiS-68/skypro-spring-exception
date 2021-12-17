package pro.sky.java.course2.skyprospringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.skyprospringexception.exception.BadParamException;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.impl.DepartmentServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public String minSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer department){
        if (department == null){
            throw new BadParamException();
        }
        return departmentService.getEmployeeMinSalaryByDepartment(department).toString();
    }

    @GetMapping("/max-salary")
    public String maxSalaryByDepartment(@RequestParam(value = "departmentId", required = false) Integer department){
        if (department == null){
            throw new BadParamException();
        }
        return departmentService.getEmployeeMaxSalaryByDepartment(department).toString();
    }

    @GetMapping("/all-department")
    public Collection<Employee> printEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) Integer department){
        if (department == null){
            throw new BadParamException();
        }
        return departmentService.printInfoByDepartment(department);
    }

    @GetMapping("/all")
    public Collection<Employee> printEmployees(){
        return departmentService.printInfoEmployees();
    }
}
