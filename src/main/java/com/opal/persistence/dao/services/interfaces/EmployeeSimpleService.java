package com.opal.persistence.dao.services.interfaces;

import com.opal.persistence.model.Employee;

import java.util.List;

public interface EmployeeSimpleService {
    List<Employee> findAll();

    Employee addEmployee(Employee employee);

    void removeById(long id);
}
