package com.restapi.service;

import com.restapi.model.Employee;
import com.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> listOfEmployee() {
        return  employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Integer id) {
        return  employeeRepository.findById(id).get();
    }

    public  void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
