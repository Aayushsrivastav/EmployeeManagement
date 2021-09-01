package com.aayush.employeemanager;

import com.aayush.employeemanager.model.Employee;
import com.aayush.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee () {
        List<Employee> employees = employeeService.findAllemployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("Id") Long Id) {
        Employee employee = employeeService.findEmployeeById(Id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("Id") Long Id) {
        employeeService.deleteEmployee(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
