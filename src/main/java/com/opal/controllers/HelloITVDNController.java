package com.opal.controllers;

import com.opal.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/bye2")
    public ModelAndView bye(ModelAndView modelAndView) {
        modelAndView.setViewName("bye.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/rest/{name}")
    @ResponseBody
    public String retRest(@PathVariable String name) {
        return name + Math.random() * 1000;
    }
}
