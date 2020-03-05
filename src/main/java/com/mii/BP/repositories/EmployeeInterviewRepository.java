/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.EmployeeInterview;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aqira
 */
@Repository
public interface EmployeeInterviewRepository extends CrudRepository<EmployeeInterview, Integer> {

    @Modifying
    @Query(value = "SELECT * FROM employee_interview WHERE result = 'PENDING'", nativeQuery = true)
    public List<EmployeeInterview> tampilinResultPending();

    @Modifying
    @Query(value = "UPDATE employee_interview SET result = 'ACCEPTED' WHERE id = ?1", nativeQuery = true)
    public void updateToAccepted(int id);
    
    @Modifying
    @Query(value = "UPDATE employee_interview SET result = 'REJECTED' WHERE id = ?1", nativeQuery = true)
    public void updateToRejected(int id);

}
