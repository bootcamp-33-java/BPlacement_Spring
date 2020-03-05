/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.Interview;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aqira
 */
@Repository
public interface InterviewRepository extends CrudRepository<Interview, Integer> {
    
//    @Modifying
    @Query(value="SELECT interview.id FROM interview order by id desc limit 1",nativeQuery = true)
    public Integer getLastIndex();
}
