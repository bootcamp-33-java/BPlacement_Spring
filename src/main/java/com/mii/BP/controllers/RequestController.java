/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.entities.Request;
import com.mii.BP.entities.RequestStatus;
import com.mii.BP.entities.Site;
import com.mii.BP.entities.Skill;
import com.mii.BP.entities.UserSite;
import com.mii.BP.services.RequestService;
import com.mii.BP.services.SiteService;
import com.mii.BP.services.SkillService;
import com.mii.BP.services.UserSiteService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author aqira
 */
@Controller
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    SkillService skillService;

    @Autowired
    UserSiteService userSiteService;

    @Autowired
    SiteService siteService;

    @RequestMapping("") //bisa di ganti sama get mapping, post mapping, dll
    public String getAll(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama", request.getSession().getAttribute("employee"));
        model.addAttribute("peran", request.getSession().getAttribute("role"));
//        Masukkan data baru
        model.addAttribute("request", new Request());
        model.addAttribute("skill", new Skill());
        model.addAttribute("userSite", new UserSite());
        model.addAttribute("site", new Site());
//        Buat 
        model.addAttribute("requests", requestService.getAll());
        model.addAttribute("skills", skillService.getAll());
        model.addAttribute("userSites", userSiteService.getAll());
        model.addAttribute("sites", siteService.getAll());

        return "index"; //kasih ke viewnya
    }

    @RequestMapping("/tables")

    public String tabel(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama", request.getSession().getAttribute("employee"));
        model.addAttribute("peran", request.getSession().getAttribute("role"));
//        Masukkan data baru
        model.addAttribute("request", new Request());
        model.addAttribute("skill", new Skill());
        model.addAttribute("userSite", new UserSite());
//        Buat 
        model.addAttribute("requests", requestService.getNewRequest());
        model.addAttribute("skills", skillService.getAll());
        model.addAttribute("userSites", userSiteService.getAll());
        model.addAttribute("sites", siteService.getAll());

        return "/tables";
    }

    @PostMapping("tables/saveUser")
    public String saveUser(HttpServletRequest request) {
        try {
            String project = request.getParameter("project");
            String name = request.getParameter("name");
            String division = request.getParameter("division");
            String team = request.getParameter("team");
            int site = Integer.parseInt(request.getParameter("site"));

            UserSite us = new UserSite(0, project, name, division,
                    team, new Site(site));

            userSiteService.save(us);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/tables";
    }
    @PostMapping("tables/save")
    public String save(HttpServletRequest request) {
        try {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String note = request.getParameter("note");
            int userSite = Integer.parseInt(request.getParameter("userSite"));
            String skill = request.getParameter("skill");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            Date dateStart = formatter.parse(startDate);
            Date dateEnd = formatter.parse(endDate);

            Request r = new Request(0, quantity, dateStart, dateEnd,
                    note, new UserSite(userSite), new Skill(skill),
                    new RequestStatus(Integer.parseInt("1")));

            requestService.save(r);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "redirect:/tables";
    }
    @PostMapping("tables/saveuser")
    public String saveuser(HttpServletRequest request) {

            int site = Integer.parseInt(request.getParameter("site"));
            String project = request.getParameter("project");
            String name = request.getParameter("name");
            String division = request.getParameter("division");
            String team = request.getParameter("team");
            
            UserSite us = new UserSite(0, new Site(site), project, name,
                    division, team);

            userSiteService.save(us);

        return "redirect:/tables";
    }

    @GetMapping("tables/update/{id}")
    public String updateStatusUpdate(Model model, @PathVariable("id") String id) {
        requestService.updateToProcess(Integer.parseInt(id));
        return "redirect:/tables";
    }

    @GetMapping("tables/cancel/{id}")
    public String updateStatusCancel(Model model, @PathVariable("id") String id) {
        requestService.updateToProcess(Integer.parseInt(id));
        return "redirect:/tables";
    }
}
