/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Placement;
import com.mii.BP.repositories.ReportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Galih Satriya
 */
@Service
public class ReportService {
    @Autowired
    ReportRepository ReportRepository;

   
    public Placement save(Placement placement) {
        return ReportRepository.save(placement);
    }
    public Placement getById(Integer id) {
        return ReportRepository.findById(id).get();
    }
    public List<Placement> getAll(){
        return ReportRepository.findAll();
    }
}
