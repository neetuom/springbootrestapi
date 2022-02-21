package com.restapi.controller;


import com.restapi.model.Employee;
import com.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    /*
       GET - http://localhost:8080/employee/all
     */
    @GetMapping("/all")
    public List<Employee> listOfEmployees() {
        return employeeService.listOfEmployee();
    }

    /*
       GET - http://localhost:8080/employee/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id){
      try{
           Employee employee = employeeService.getEmployee(id);
           return new ResponseEntity<Employee>(employee,HttpStatus.OK);
      }catch(NoSuchElementException noSuchElementException) {
          return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
      }
    }


    /*
       POST - http://localhost:8080/employee/

              {
                "empname": "Varun Anand",
                "empsalary": 400000
              }
     */
    @PostMapping("/")
    public  void add(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    /*
      PUT - http://localhost:8080/employee/1
            {
              "empname": "Ramesh Kumar",
              "empsalary": 100000
            }
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
        try{
             Employee employeeExist = employeeService.getEmployee(id);
             employee.setEmpid(id);
             employeeService.saveEmployee(employee);
             return  new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*
       DELETE - http://localhost:8080/employee/2
     */
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
