/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.services.EmployeeInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aqira
 */
@Controller
public class ConfirmationController {

    @Autowired
    EmployeeInterviewService eiService;
    
    @RequestMapping("/confirmation")
    public String confirmation(Model model) {
        
        model.addAttribute("employeeInterview", new EmployeeInterview());
//        Buat 
        model.addAttribute("employeeInterviews", eiService.getResultPending() );
        
        return "/confirmation";
    }
    
    @GetMapping("confirmation/accepted/{id}")
    public String updateAccepted(Model model, @PathVariable("id") String id) {
        eiService.updateToAccepted(Integer.parseInt(id));
        return "redirect:/confirmation";
    }
    
    @GetMapping("confirmation/rejected/{id}")
    public String updateRejected (Model model, @PathVariable("id") String id) {
        eiService.updateToRejected(Integer.parseInt(id));
        return "redirect:/confirmation";
    }
    
}
