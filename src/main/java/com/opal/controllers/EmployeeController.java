package com.opal.controllers;

import com.opal.persistence.dao.services.interfaces.EmployeeSimpleService;
import com.opal.persistence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeSimpleService employeeSimpleService;

    @PostMapping(value = "/add")
    public String addNewEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setPosition(request.getParameter("position"));
        employee.setPhone(request.getParameter("phone"));
        employeeSimpleService.addEmployee(employee);
        return "redirect:/employee/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllEmployee(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("employees", employeeSimpleService.findAll());
        modelAndView.setViewName("employees.jsp");
        return modelAndView;
    }
}
