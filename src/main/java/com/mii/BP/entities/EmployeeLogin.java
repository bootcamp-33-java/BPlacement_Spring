/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.entities;

/**
 *
 * @author Tutus W
 */
public class EmployeeLogin {
    
    private EmployeeAPI employee;
    private String status;

    public EmployeeAPI getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeAPI employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
