/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.Site;
import com.mii.BP.entities.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aqira
 */
@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {
    
}
