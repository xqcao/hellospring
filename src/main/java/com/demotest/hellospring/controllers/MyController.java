package com.demotest.hellospring.controllers;

import java.net.URI;

import com.demotest.hellospring.Employee;
import com.demotest.hellospring.EmployeeDAO;
import com.demotest.hellospring.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin
public class MyController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    public String home() {
        return "welcome back home";
    }

    @RequestMapping("/hi")
    public String sayHello() {
        return "say hello world";
    }

    @GetMapping(path = "/emp", produces = "application/json")
    public Employees getEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @PostMapping(path = "/emp", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer id = employeeDAO.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        employeeDAO.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}