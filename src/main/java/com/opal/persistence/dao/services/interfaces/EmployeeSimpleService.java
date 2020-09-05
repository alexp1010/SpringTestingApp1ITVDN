package com.opal.persistence.dao.services.interfaces;

import com.opal.persistence.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeSimpleService {
    List<Employee> findAll();
    Optional<Employee> findById(long id);
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeByNameAndPosition(String name, String position);
    List<Employee> findEmployeeByNameAndPhone(String name, String phone);
    Employee addEmployee(Employee employee);
    void removeById(long id);
    void listAllEmployee();
    //void clearCache();
}
