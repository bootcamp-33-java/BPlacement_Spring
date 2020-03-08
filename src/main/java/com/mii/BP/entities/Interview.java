/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aqira
 */
@Entity
@Table(name = "interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interview.findAll", query = "SELECT i FROM Interview i")
    , @NamedQuery(name = "Interview.findById", query = "SELECT i FROM Interview i WHERE i.id = :id")
    , @NamedQuery(name = "Interview.findByInterviewer", query = "SELECT i FROM Interview i WHERE i.interviewer = :interviewer")
    , @NamedQuery(name = "Interview.findByInterviewDate", query = "SELECT i FROM Interview i WHERE i.interviewDate = :interviewDate")})
public class Interview implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "interviewer")
    private String interviewer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interview_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interviewDate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interview", fetch = FetchType.LAZY)
    private List<EmployeeInterview> employeeInterviewList;
    @JoinColumn(name = "request", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Request request;

    public Interview() {
    }

    public Interview(Integer id) {
        this.id = id;
    }

    public Interview(Integer id, String interviewer, Date interviewDate) {
        this.id = id;
        this.interviewer = interviewer;
        this.interviewDate = interviewDate;
    }

    public Interview(Integer id, Request request, String interviewer, Date interviewDate) {
        this.id = id;
        this.request = request;
        this.interviewer = interviewer;
        this.interviewDate = interviewDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    @XmlTransient
    public List<EmployeeInterview> getEmployeeInterviewList() {
        return employeeInterviewList;
    }

    public void setEmployeeInterviewList(List<EmployeeInterview> employeeInterviewList) {
        this.employeeInterviewList = employeeInterviewList;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
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
        if (!(object instanceof Interview)) {
            return false;
        }
        Interview other = (Interview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.BP.entities.Interview[ id=" + id + " ]";
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

}
