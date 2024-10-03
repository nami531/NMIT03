package com.example.numbertable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;;

@Controller
public class NumController{

    public Set<Integer> list = new LinkedHashSet<>();
    public Random r = new Random() ; 

    @GetMapping({" ", "/list", "/"})
    public String showList(Model model){
        model.addAttribute("totalNumbers", list.size());
        model.addAttribute("list", list); 
        return "index"; 
    }

    @GetMapping("/new")
    public String addNumber() {
        boolean added = false; 
        while (!added) {
            added = list.add(r.nextInt(0,100)); 
        }
        return "redirect:/list"; 
        
    }

    @GetMapping("/remove/{id}")
    public String removeNumber(@PathVariable Integer id) {
        list.remove(id); 
        return "redirect:/list";
    }
    
    
}