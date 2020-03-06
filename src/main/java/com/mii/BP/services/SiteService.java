/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.Site;
import com.mii.BP.repositories.EmployeeRepository;
import com.mii.BP.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class SiteService {

    @Autowired
    SiteRepository repository;

    public Iterable<Site> getAll() {
        return repository.findAll();
    }

    public Site save(Site site) {
        return repository.save(site);
    }
}
