/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.entities.Placement;
import com.mii.BP.repositories.ReportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Galih Satriya
 */
@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public EmployeeInterview save(EmployeeInterview employeeInterview) {
        return reportRepository.save(employeeInterview);
    }

    public Iterable<EmployeeInterview> getResultAccepted() {
        return reportRepository.tampilinAcceptedResult() ;
    }

    public Iterable<EmployeeInterview> getAll() {
        return reportRepository.findAll();
    }
}
