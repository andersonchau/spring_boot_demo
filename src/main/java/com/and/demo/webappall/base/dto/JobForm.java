package com.and.demo.webappall.base.dto;

import java.util.Date;

public class JobForm {
    private String actionName;
    private int id;
    private String description;
    private boolean importance;
    private int status;
    private String deadline;


    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

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

    public boolean isImportance() {
        return importance;
    }

    public void setImportance(boolean importance) {
        this.importance = importance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
