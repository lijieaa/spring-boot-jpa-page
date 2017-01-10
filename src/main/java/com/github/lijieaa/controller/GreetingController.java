package com.github.lijieaa.controller;

import com.github.lijieaa.dao.CustomerRepository;
import com.github.lijieaa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    CustomerRepository dao;

    @RequestMapping("/greeting")
    public String greeting(@PageableDefault(value = 1)Pageable pageable,Model model) {
        Page<Customer> all = dao.findAll(pageable);
        model.addAttribute("product", all.getContent());
        model.addAttribute("pageNumber", all.getNumber());
        model.addAttribute("page", all.getTotalPages());
        model.addAttribute("firstPage", all.isFirst());
        model.addAttribute("lastPage", all.isLast());
        return "greeting";
    }

}
