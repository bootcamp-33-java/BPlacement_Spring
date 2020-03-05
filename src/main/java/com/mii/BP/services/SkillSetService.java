/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.SkillSet;
import com.mii.BP.repositories.EmployeeRepository;
import com.mii.BP.repositories.SkillRepository;
import com.mii.BP.repositories.SkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class SkillSetService {

    @Autowired
    SkillSetRepository repository;

    public Iterable<SkillSet> getAll() {
        return repository.findAll();
    }

    public SkillSet save(SkillSet skillSet) {
        return repository.save(skillSet);
    }
}
