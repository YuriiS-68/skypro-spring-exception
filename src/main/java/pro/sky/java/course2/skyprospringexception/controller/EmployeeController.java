package pro.sky.java.course2.skyprospringexception.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.skyprospringexception.exception.BadParamException;
import pro.sky.java.course2.skyprospringexception.model.Employee;
import pro.sky.java.course2.skyprospringexception.service.impl.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "departmentId", required = false) Integer department,
                              @RequestParam(value = "salary", required = false) Double salary){
        if (firstName == null || lastName == null){
            throw new BadParamException();
        }
        employeeService.addEmployee(firstName, lastName, department, salary);
        return "Employee: " + firstName + " " + lastName  + " added successfully.";
    }

    @GetMapping("/remove")
    public String delEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName){
        if (firstName == null || lastName == null){
            throw new BadParamException();
        }
        employeeService.delEmployee(firstName, lastName);
        return "Employee: " + firstName + " " +  lastName  + " deleted successfully.";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName){
        if (firstName == null || lastName == null){
            throw new BadParamException();
        }
        return employeeService.findEmployee(firstName, lastName)  + " found successfully.";
    }

    @GetMapping("/list")
    public Collection<Employee> printList(){
        return employeeService.getEmployeesList();
    }
}
