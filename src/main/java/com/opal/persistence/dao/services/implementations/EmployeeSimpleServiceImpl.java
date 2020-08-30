package com.opal.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import com.opal.persistence.dao.repositories.EmployeeRepository;
import com.opal.persistence.dao.services.interfaces.EmployeeSimpleService;
import com.opal.persistence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSimpleServiceImpl implements EmployeeSimpleService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void removeById(long id) {

    }
}
