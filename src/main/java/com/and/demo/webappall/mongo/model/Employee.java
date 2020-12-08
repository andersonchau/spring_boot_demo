package com.and.demo.webappall.mongo.model;

import javax.persistence.Id;
import java.util.Date;

public class Employee {
    @Id
    private String id;
    private String name;

    private Date joinDate;
    private String staffId;
    private int status;


    public Employee(String name, String staffId, int status){
        this.name = name;
        this.staffId = staffId;
        this.joinDate = new Date();
        this.status = 1;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
