/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;


import com.mii.BP.entities.Site;
import com.mii.BP.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Galih Satriya
 */
@Service
public class SiteService {
     @Autowired
    SiteRepository siteRepository;
    
    public Iterable<Site> getAll() {
        return siteRepository.findAll();
    }

     public Site save(Site site) {
        return siteRepository.save(site);
    }
    public Site getById(String id) {
        Site site = siteRepository.findById(id).get();
        return site;
    }
}
