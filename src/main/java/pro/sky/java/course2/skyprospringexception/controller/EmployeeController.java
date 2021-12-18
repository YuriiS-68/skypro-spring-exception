package pro.sky.java.course2.skyprospringexception.controller;

import org.springframework.web.bind.annotation.*;
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
    public String addEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName,
                              @RequestParam(value = "departmentId", required = false) Integer department,
                              @RequestParam(required = false) Double salary){
        employeeService.addEmployee(firstName, lastName, department, salary);
        return "Employee: " + firstName + " " + lastName  + " added successfully.";
    }

    @GetMapping("/remove")
    public String delEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName){
        employeeService.delEmployee(firstName, lastName);
        return "Employee: " + firstName + " " +  lastName  + " deleted successfully.";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName){
        return employeeService.findEmployee(firstName, lastName)  + " found successfully.";
    }

    @GetMapping("/list")
    public Collection<Employee> printList(){
        return employeeService.getEmployeesList();
    }
}
