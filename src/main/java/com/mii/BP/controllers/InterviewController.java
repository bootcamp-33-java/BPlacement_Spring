/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.domain.User;
import com.mii.BP.entities.Employee;
import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.entities.Interview;
import com.mii.BP.entities.Request;
import com.mii.BP.entities.SkillSet;
import com.mii.BP.services.EmployeeInterviewService;
import com.mii.BP.services.EmployeeService;
import com.mii.BP.services.InterviewService;
import com.mii.BP.services.NotificationService;
import com.mii.BP.services.RequestService;
import com.mii.BP.services.SkillSetService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aqira
 */
@Controller
public class InterviewController {

    private Logger logger = LoggerFactory.getLogger(InterviewController.class);

    @Autowired
    NotificationService notificationService;
    @Autowired
    RequestService requestService;
    @Autowired
    InterviewService interviewService;
    @Autowired
    SkillSetService skillSetService;
    @Autowired
    EmployeeInterviewService eiService;

    @RequestMapping("/interview")
    public String interview(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama", request.getSession().getAttribute("employee"));
        model.addAttribute("peran", request.getSession().getAttribute("role"));
//        view request
        model.addAttribute("request", new Request());
        model.addAttribute("interview", new Interview());
        model.addAttribute("requests", requestService.getProcessRequest());

//        drop down select2 skillset
        model.addAttribute("employeeInterview", new EmployeeInterview());
        model.addAttribute("skillSets", skillSetService.getAll());

        return "interview";
    }

//    send email
    @RequestMapping("/interview/appointment")
    public String appointment() {

        //send email
        SimpleDateFormat formatdate = new SimpleDateFormat("dd-mm-yyyy");
        User user = new User();

        user.setName("Aqira Kelana");
        user.setEmailAddress("aqira.kelana@gmail.com");
        user.setAlamat("Jl. Dr. Setiabudi No.199 Lantai 2 Bandung");
        user.setDivisi("Divisi Halo");
        user.setInterviewer("Fadel Gideon");
        user.setTeam("Sakura");
        try {
            user.setTanggal(formatdate.parse("11-11-2011"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        //send a notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email :" + e.getMessage());
        }
        //send notif
        return "interview";
    }
//    send email

    @RequestMapping("/interview/send")
    public String emailModal() {
        //send email
        SimpleDateFormat formatdate = new SimpleDateFormat("dd-mm-yyyy");
        User user = new User();

        user.setEmailAddress("aqira.kelana@gmail.com");
        user.setName("Aqira Kelana");
        user.setAlamat("Jl. Dr. Setiabudi No.199 Lantai 2 Bandung");
        user.setDivisi("Divisi Halo");
        user.setInterviewer("Fadel Gideon");
        user.setTeam("Sakura");
        try {
            user.setTanggal(formatdate.parse("11-11-2011"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        //send a notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email :" + e.getMessage());
        }
        //send notif
        return "interview";
    }

    @PostMapping("interview/save")
    public String save(HttpServletRequest request) {

    //interview
        try {
            int req = Integer.parseInt(request.getParameter("request"));
            String interviewer = request.getParameter("interviewer");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            String dateInterview = request.getParameter("interviewDate");

            Date interviewDate = formatter.parse(dateInterview);

            Interview i = new Interview(0, new Request(req), interviewer, interviewDate);
            interviewService.save(i);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    //employee interview
        String employee = request.getParameter("employee");
        int interview = interviewService.getByLastIndex();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA = "+employee+interview);
        EmployeeInterview ei = new EmployeeInterview(0, new Employee(employee), new Interview(interview), "PENDING");
        eiService.save(ei);

        return "redirect:/interview";
    }
}
