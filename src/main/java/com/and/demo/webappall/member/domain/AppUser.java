package com.and.demo.webappall.member.domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/*
create TABLE app_user
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	status int NOT NULL,
	create_date DATE NOT NULL,
	last_modified_date DATETIME NOT NULL,
	join_date DATE NOT NULL,
	PRIMARY KEY (ID)
);
 */
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    //@ManyToMany(mappedBy = "appUsers")
    //private Set<AppRole> appRoles = new HashSet<AppRole>();


    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Integer status;

    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    private Date joinDate;


    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    AppUserCredential appUserCredential;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public AppUserCredential getAppUserCredential() {
        return appUserCredential;
    }

    public void setAppUserCredential(AppUserCredential appUserCredential) {
        this.appUserCredential = appUserCredential;
    }
}
