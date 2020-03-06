/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.services.EmployeeService;
import com.mii.BP.services.HistoryService;
import com.mii.BP.services.InterviewService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Galih Satriya
 */
@RequestMapping(value = "history")
@Controller
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    InterviewService interviewService;
    
    
    @GetMapping("")//bisa di ganti sama get mapping, post mapping, dll
    public String getAll(Model model, HttpServletRequest request) {
    org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama", request.getSession().getAttribute("employee"));
        model.addAttribute("peran", request.getSession().getAttribute("role"));
        
        model.addAttribute("histories", historyService.getAll());
//        model.addAttribute("employees", employeeService.getAll());
//        model.addAttribute("requests", requestService.getAll());
        //        model.addAttribute("skills", skillService.getAll());

        return "history"; //kasih ke viewnya
    }
//    @PostMapping("save")
//    public String save(@Valid EmployeeInterview employeeInterview) {
//        historyService.save(employeeInterview);
//        return "redirect:/history";
//    }
//
//    @GetMapping("{id}")
//    public String getById(Model model, @PathVariable("id") Integer id) {
//
////        buat getById
//        model.addAttribute("history", historyService.getById(id));
//
////        buat getAll setelah masukkin ID
//        model.addAttribute("history", historyService.getAll());
//        return "index";
//    }
}
