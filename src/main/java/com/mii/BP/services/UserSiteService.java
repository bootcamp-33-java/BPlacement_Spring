/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Skill;
import com.mii.BP.entities.UserSite;
import com.mii.BP.repositories.SkillRepository;
import com.mii.BP.repositories.UserSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class UserSiteService {

    @Autowired
    UserSiteRepository repository;

    public Iterable<UserSite> getAll() {
        return repository.findAll();
    }

    public UserSite save(UserSite userSite) {
        return repository.save(userSite);
    }
  }
