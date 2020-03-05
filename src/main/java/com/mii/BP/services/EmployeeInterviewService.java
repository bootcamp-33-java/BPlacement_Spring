/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.repositories.EmployeeInterviewRepository;
import com.mii.BP.repositories.EmployeeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class EmployeeInterviewService {

    @Autowired
    EmployeeInterviewRepository repository;

    public Iterable<EmployeeInterview> getAll() {
        return repository.findAll();
    }

    public EmployeeInterview save(EmployeeInterview employeeInterview) {
        return repository.save(employeeInterview);
    }

    public Iterable<EmployeeInterview> getResultPending() {
        return repository.tampilinResultPending();
    }
    
    @Transactional
    public void updateToAccepted(Integer id) {
        repository.updateToAccepted(id);
    }
    
    @Transactional
    public void updateToRejected(Integer id) {
        repository.updateToRejected(id);
    }

}
