package com.and.demo.webappall.base.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Job {

    private int id;
    private String description;
    private Date deadline;
    private int importance;
    private int status;
    // a little bit of hacking here
    private String deadlineStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void dump() {
        System.out.println("Description is " + description);
        System.out.println("deadline is " + deadline);
        System.out.println("importance is " + importance);
        System.out.println("status is " + status);
    }

    public String getDeadlineStr() {
        return deadlineStr;
    }

    public void setDeadlineStr(String deadlineStr) {
        this.deadlineStr = deadlineStr;
    }

    public void postProcess() {
        if (deadline != null){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            deadlineStr = dateFormat.format(deadline);
        } else {
            deadlineStr = "";
        }
    }


}
