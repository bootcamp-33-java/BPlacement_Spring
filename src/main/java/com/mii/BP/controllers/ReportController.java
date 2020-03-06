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
import com.mii.BP.services.SiteService;
import com.mii.BP.services.UserSiteService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RequestService requestService;

    //    SkillService skillService;
//    @RequestMapping("/report")
//    public String question(Model model, HttpServletRequest request) {
//        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
////        model.addAttribute("questions", service.getByQuiz(request.getParameter("id")));
////        System.out.println(request.getParameter("id"));
//        model.addAttribute("reports", reportService.getAll());
//        return "report";
//    }
    @GetMapping("")//bisa di ganti sama get mapping, post mapping, dll
    public String getAll(Model model, HttpServletRequest request) {
    
        model.addAttribute("reports", reportService.getAll());
//        model.addAttribute("employees", employeeService.getAll());
//        model.addAttribute("requests", requestService.getAll());
        //        model.addAttribute("skills", skillService.getAll());

        return "report"; //kasih ke viewnya
    }

    @RequestMapping("/report")

    public String report(Model model) {

//        Masukkan data baru
        model.addAttribute("report", new Placement());
        model.addAttribute("employee", new Employee());
        model.addAttribute("request", new Request());

//        Buat 
        model.addAttribute("reports", reportService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("requests", requestService.getAll());
        return "/tables";
    }

    @PostMapping("save")
    public String save(@Valid Placement placement) {
        reportService.save(placement);
        return "redirect:/report";
    }

    @GetMapping("{id}")
    public String getById(Model model, @PathVariable("id") Integer id) {

//        buat getById
        model.addAttribute("report", reportService.getById(id));

//        buat getAll setelah masukkin ID
        model.addAttribute("report", reportService.getAll());
        return "index";
    }
}
