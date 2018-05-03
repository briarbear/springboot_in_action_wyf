package com.xzp.ch4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","hello");
        return "index";
    }

    @GetMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("msg","index");
        return model;
    }
}
