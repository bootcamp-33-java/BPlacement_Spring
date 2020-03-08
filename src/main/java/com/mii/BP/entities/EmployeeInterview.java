/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aqira
 */
@Entity
@Table(name = "employee_interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeInterview.findAll", query = "SELECT e FROM EmployeeInterview e")
    , @NamedQuery(name = "EmployeeInterview.findById", query = "SELECT e FROM EmployeeInterview e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeInterview.findByResult", query = "SELECT e FROM EmployeeInterview e WHERE e.result = :result")})
public class EmployeeInterview implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "result")
    private String result;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "interview", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Interview interview;

    public EmployeeInterview() {
    }

    public EmployeeInterview(Integer id) {
        this.id = id;
    }

    public EmployeeInterview(Integer id, String result) {
        this.id = id;
        this.result = result;
    }

    public EmployeeInterview(Integer id, Employee employee, Interview interview, String result) {
        this.id = id;
        this.employee = employee;
        this.interview = interview;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeInterview)) {
            return false;
        }
        EmployeeInterview other = (EmployeeInterview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.BP.entities.EmployeeInterview[ id=" + id + " ]";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
