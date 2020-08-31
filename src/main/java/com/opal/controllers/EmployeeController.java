package com.opal.controllers;

import com.opal.persistence.dao.services.interfaces.EmployeeSimpleService;
import com.opal.persistence.model.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static final Log LOG = LogFactory.getLog(EmployeeController.class);
    @Autowired
    private EmployeeSimpleService employeeSimpleService;

    @PostMapping(value = "/add")
    public String addNewEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setPosition(request.getParameter("position"));
        employee.setPhone(request.getParameter("phone"));
        employeeSimpleService.addEmployee(employee);

        LOG.info("New employee with id " + employee.getId() + " was added.");
        return "redirect:/employee/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllEmployee(ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeSimpleService.findAll());
        modelAndView.setViewName("employees.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView deleteEmployee(@PathVariable long id, ModelAndView modelAndView) {
        employeeSimpleService.removeById(id);
        modelAndView.addObject("employees", employeeSimpleService.findAll());
        modelAndView.setViewName("redirect:/employee/all");
        return modelAndView;
    }

    @PostMapping(value = "/findByName")
    public ModelAndView findEmployeeByName(@RequestParam("name") String name, ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeSimpleService.findEmployeeByName(name));
        modelAndView.setViewName("/employee/search-results.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/findByNameAndPosition")
    public ModelAndView findEmployeeByNameAndPosition(@RequestParam("name") String name,
                                                      @RequestParam("position") String position,
                                                      ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeSimpleService.findEmployeeByNameAndPosition(name, position));
        modelAndView.setViewName("/employee/search-results.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/findByNameAndPhone")
    public ModelAndView findEmployeeByNameAndPhone(@RequestParam("name") String name,
                                                   @RequestParam("phone") String phone,
                                                   ModelAndView modelAndView) {
        modelAndView.addObject("employees", employeeSimpleService.findEmployeeByNameAndPhone(name, phone));
        modelAndView.setViewName("/employee/search-results.jsp");
        return modelAndView;
    }
}
