/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.repositories;

import com.mii.BP.entities.Request;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aqira
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Modifying
    @Query(value = "SELECT * FROM request WHERE request_status = 1", nativeQuery = true)
    public List<Request> tampilinNewRequest();
    
    @Modifying
    @Query(value = "SELECT * FROM request WHERE request_status = 2", nativeQuery = true)
    public List<Request> tampilinProcessRequest();
    
    @Modifying
    @Query(value="UPDATE Request SET request_status = '2' WHERE id = ?1", nativeQuery = true)
    public void updateToProcess(int id);
  
    @Modifying
    @Query(value="UPDATE Request SET request_status = '3' WHERE id = ?1", nativeQuery = true)
    public void updateToCancelled(int id);
    @Modifying
    @Query(value="UPDATE Request SET request_status = '4' WHERE id = ?1", nativeQuery = true)
    public void updateToDone(int id);
//    
}
