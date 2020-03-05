/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Interview;
import com.mii.BP.repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class InterviewService {
    
    @Autowired
    InterviewRepository interviewRepository;

    public Iterable<Interview> getAll() {
        return interviewRepository.findAll();
    }

    public Interview save(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview getById(Integer id) {
        return interviewRepository.findById(id).get();
    }
    
    public Integer getByLastIndex(){
        return interviewRepository.getLastIndex();
    }
}
