/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.Placement;
import com.mii.BP.entities.Request;
import com.mii.BP.services.EmployeeService;
import com.mii.BP.services.ReportService;
import com.mii.BP.services.RequestService;
import com.mii.BP.services.UserSiteService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
@RequestMapping(value = "report")
@Controller
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("")//bisa di ganti sama get mapping, post mapping, dll
    public String getAll(Model model, HttpServletRequest request) {
    org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama", request.getSession().getAttribute("employee"));
        model.addAttribute("peran", request.getSession().getAttribute("role"));
        
        model.addAttribute("reports", reportService.getResultAccepted() );

        return "report"; //kasih ke viewnya
    }

    @RequestMapping("/report")

    public String report(Model model) {

//        Buat 
        model.addAttribute("reports", reportService.getResultAccepted() );
        return "/report";
    }
}
