package com.opal.controller;

import com.opal.persistence.dao.repositories.EmployeeRepository;
import com.opal.persistence.dao.services.implementations.EmployeeSimpleServiceImpl;
import com.opal.persistence.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

public class DaoTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeSimpleServiceImpl employeeSimpleService;

    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee("Alex", "Doe", "0676799901"));
        employeeList.add(new Employee("John", "Smith", "0997831010"));
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        when(employeeRepository.findAll()).thenReturn(employeeList);
        System.out.println(employeeSimpleService.findAll());
        Assert.assertEquals(employeeList, employeeSimpleService.findAll());
    }

    @Test
    public void test2() {
        when(employeeRepository.findEmployeeByName("John"))
                .thenReturn(employeeList.stream().filter(elem -> elem.getName().equals("John"))
                        .collect(Collectors.toList()));
        System.out.println(employeeSimpleService.findEmployeeByName("John"));
    }
}
