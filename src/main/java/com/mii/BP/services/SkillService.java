/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Skill;
import com.mii.BP.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class SkillService {

    @Autowired
    SkillRepository repository;

    public Iterable<Skill> getAll() {
        return repository.findAll();
    }

    public Skill save(Skill skill) {
        return repository.save(skill);
    }

    public Skill getById(String id) {
        return repository.findById(id).get();
    }}
