/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Request;
import com.mii.BP.repositories.RequestRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aqira
 */
@Service
public class RequestService {

    @Autowired
    RequestRepository repository;

    public Iterable<Request> getAll() {
        return repository.findAll();
    }

    public Request save(Request request) {
        return repository.save(request);
    }

    public Request getById(Integer id) {
        return repository.findById(id).get();
    }

    public Iterable<Request> getNewRequest() {
        return repository.tampilinNewRequest();
    }

    public Iterable<Request> getProcessRequest() {
        return repository.tampilinProcessRequest();
    }
    
    @Transactional
    public void updateToProcess(Integer id) {
        repository.updateToProcess(id);
    }
    
    @Transactional
    public void updateToCancelled(Integer id) {
        repository.updateToCancelled(id);
    }
    
    @Transactional
    public void updateToDone(Integer id) {
        repository.updateToDone(id);
    }
}
