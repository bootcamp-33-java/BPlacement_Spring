/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.controllers;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.EmployeeLogin;
import com.mii.BP.entities.LoginData;
import com.mii.BP.services.EmployeeService;
import com.mii.BP.services.LoginRest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Tutus W
 */
@Controller
public class LoginController {
    
    @Autowired
    private LoginRest rest;
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/login")
    public String handlingLog(){
        String result;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equalsIgnoreCase("anonymousUser")) {
            result = "redirect:/";
        }else{
            result="login";
        }
        
        return result;
    }
 
    @PostMapping("/verification")
    public String verification(LoginData loginData, RedirectAttributes redirect, HttpServletRequest request){
        String result="";
        
        EmployeeLogin employeeLogin = rest.login(loginData);
        System.out.println(employeeLogin.getStatus());
        
        if (employeeLogin.getStatus().equalsIgnoreCase("Login Success")) {
            System.out.println("=====================");
            //ambil semua role
            User user = new User(employeeLogin.getEmployee().getId(),"", getAuthorities(employeeLogin));
            //diberi akses
            PreAuthenticatedAuthenticationToken authentication = 
                    new PreAuthenticatedAuthenticationToken(user, "", user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
              try{
                Employee employee = new Employee(employeeLogin.getEmployee().getId(), employeeLogin.getEmployee().getFirstName()+" "+ employeeLogin.getEmployee().getLastName(), employeeLogin.getEmployee().getEmail());
                rest.save(employee); // untuk save ke database local
//                employee.setId(employeeLogin.getEmployee().getEmail());
//                employee.setEmail(employeeLogin.getEmployee().getEmail());
//                employee.setName(employeeLogin.getEmployee().getFirstName()+" "+employeeLogin.getEmployee().getLastName());
//                    employeeService.save(employee);     
                  
                request.getSession().setAttribute("employee", employeeLogin.getEmployee().getFirstName()+" " 
                        + employeeLogin.getEmployee().getLastName());
                request.getSession().setAttribute("role", employeeLogin.getEmployee().getRoles().get(0));
                System.out.println("NAMA : "+request.getSession().getAttribute("employee"));
                System.out.println("NAMA : "+request.getSession().getAttribute("role"));
            
            }catch(Exception e){
                System.out.println(e);
            }
            result = "redirect:/";
        }else{
            result = "redirect:/login";
        }
        return result;
        }
    
    private static Collection<? extends GrantedAuthority> getAuthorities(EmployeeLogin employeeLogin){
        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : employeeLogin.getEmployee().getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
