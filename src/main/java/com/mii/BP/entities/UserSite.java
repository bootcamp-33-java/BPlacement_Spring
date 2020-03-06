/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aqira
 */
@Entity
@Table(name = "user_site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSite.findAll", query = "SELECT u FROM UserSite u")
    , @NamedQuery(name = "UserSite.findById", query = "SELECT u FROM UserSite u WHERE u.id = :id")
    , @NamedQuery(name = "UserSite.findByProject", query = "SELECT u FROM UserSite u WHERE u.project = :project")
    , @NamedQuery(name = "UserSite.findByName", query = "SELECT u FROM UserSite u WHERE u.name = :name")
    , @NamedQuery(name = "UserSite.findByDivision", query = "SELECT u FROM UserSite u WHERE u.division = :division")
    , @NamedQuery(name = "UserSite.findByTeam", query = "SELECT u FROM UserSite u WHERE u.team = :team")})
public class UserSite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "project")
    private String project;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "division")
    private String division;
    @Size(max = 25)
    @Column(name = "team")
    private String team;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userSite", fetch = FetchType.LAZY)
    private List<Request> requestList;
    @JoinColumn(name = "site", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Site site;

    public UserSite() {
    }

    public UserSite(Integer id) {
        this.id = id;
    }

    public UserSite(Integer id, String project, String name) {
        this.id = id;
        this.project = project;
        this.name = name;
    }

    public UserSite(Integer id, Site site, String project, String name, String division, String team) {
        this.id = id;
        this.site = site;
        this.project = project;
        this.name = name;
        this.division = division;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @XmlTransient
    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
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
        if (!(object instanceof UserSite)) {
            return false;
        }
        UserSite other = (UserSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.BP.entities.UserSite[ id=" + id + " ]";
    }

}
