/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;


import com.mii.BP.entities.EmployeeInterview;
import com.mii.BP.repositories.HistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Galih Satriya
 */
@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

   
    public EmployeeInterview save(EmployeeInterview employeeInterview) {
        return historyRepository.save(employeeInterview);
    }
    public EmployeeInterview getById(Integer id) {
        return historyRepository.findById(id).get();
    }
    public List<EmployeeInterview> getAll(){
        return historyRepository.findAll();
    }
}
