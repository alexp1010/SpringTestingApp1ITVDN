package com.opal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloITVDNController {

    @GetMapping(value = "/hello")
    public String helloITVDN() {
        return "index.jsp";
    }

    @GetMapping(value = "/bye")
    public String byeITVDN() {
        return "bye.jsp";
    }

    @GetMapping(value = "/pass-data")
    public ModelAndView passDataFromUser() {
        return new ModelAndView("pass-data.jsp", "user", new User());
    }

    @PostMapping(value = "/pass-data")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        System.out.println(user);

        modelAndView.setViewName("forward:summary.jsp");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "path/{userName}")
    public ModelAndView greeting(@PathVariable String userName, ModelAndView modelAndView) {
        System.out.println(userName);

        modelAndView.setViewName("forward:/greeting.jsp");
        modelAndView.addObject("userName", userName);
        return modelAndView;
    }
}
