package com.opal.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import com.opal.persistence.dao.repositories.EmployeeRepository;
import com.opal.persistence.dao.services.interfaces.EmployeeSimpleService;
import com.opal.persistence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSimpleServiceImpl implements EmployeeSimpleService {
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> findEmployeeByNameAndPosition(String name, String position) {
        return employeeRepository.findEmployeeByNameAndPosition(name, position);
    }

    @Override
    public List<Employee> findEmployeeByNameAndPhone(String name, String phone) {
        return employeeRepository.getPhone(name, phone);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void removeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void listAllEmployee() {
        employeeRepository.findAll().forEach(employee -> System.out.println(employee.getId()));
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
