/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tutus W
 */
@Controller
public class MainController {

    @RequestMapping("index")
    public String home(Model model,HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth.getName()); // session yg login
        model.addAttribute("user", auth.getName()); // session yg login. buat session
        model.addAttribute("nama",request.getSession().getAttribute("employee"));
        model.addAttribute("peran",request.getSession().getAttribute("role"));
        return "index";
    }

//      @GetMapping (value="/getsession", produces= MediaType.APPLICATION_JSON_VALUE)
//      public @ResponseBody
//      String getSessionLogin(){
//          JSONObject jo = new JSONObject();
//          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//          if (authenticatio   n.getName() != null) {
//              jo.put("name", authentication.getName());
//              System.out.println(authentication.getName());
//              jo.put("name", serviceApi.GETUSERBYEMAILALL(authentication.getName().getString("Name")));
//          }else{
//              jo.put("name", "N/A");
//          }
//          return jo.toString();
//      }
}
