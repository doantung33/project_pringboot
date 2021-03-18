package com.example.springboot.controller;

import com.example.springboot.model.Category;
import com.example.springboot.model.Product;
import com.example.springboot.service.ICategoryService;
import com.example.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("listCategory")
    public List<Category>categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView= new ModelAndView("list","p",productService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView =new ModelAndView("create","p",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        productService.save(product);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable long id, Model model){
        model.addAttribute("p",productService.findById(id));
        return "/edit";
    }
    @PostMapping("edit/{id}")
    public ModelAndView edit(@PathVariable long id,Product product){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        product.setId(id);
        productService.save(product);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        productService.remote(id);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView search(@RequestParam String name){
        ModelAndView modelAndView=new ModelAndView("list");
        List<Product>products=productService.search(name);
        modelAndView.addObject("p",products);
        return modelAndView;
    }

}
