/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.EmployeeInterview;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Galih Satriya
 */
public interface HistoryRepository extends CrudRepository<EmployeeInterview, Integer>{
List<EmployeeInterview> findAll();
}
