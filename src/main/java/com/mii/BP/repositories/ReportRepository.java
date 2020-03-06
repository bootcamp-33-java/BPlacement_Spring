/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;


import com.mii.BP.entities.Placement;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Galih Satriya
 */
@Repository
public interface ReportRepository extends CrudRepository<Placement, Integer>{
List<Placement> findAll();
}
