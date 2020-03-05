/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.UserSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aqira
 */
@Repository
public interface UserSiteRepository extends JpaRepository<UserSite, Integer> {
    
}
