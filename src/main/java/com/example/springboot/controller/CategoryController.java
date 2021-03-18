package com.example.springboot.controller;

import com.example.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/category")
    public ModelAndView showAll(){
        ModelAndView modelAndView=new ModelAndView("category","c",categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        return modelAndView;
    }
}
