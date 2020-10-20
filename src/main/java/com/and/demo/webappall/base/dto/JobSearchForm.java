package com.and.demo.webappall.base.dto;

import com.and.demo.webappall.base.util.Util;

import java.util.Date;

public class JobSearchForm {
    private String actionName;
    private int id;
    private String description;
    private boolean importance;
    private int status;
    private String afterDeadline;
    private String beforeDeadline;
    private Date afterDeadlineDate;
    private Date beforeDeadlineDate;

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

    public String getAfterDeadline() {
        return afterDeadline;
    }

    public void setAfterDeadline(String afterDeadline) {
        this.afterDeadline = afterDeadline;
    }

    public String getBeforeDeadline() {
        return beforeDeadline;
    }

    public void setBeforeDeadline(String beforeDeadline) {
        this.beforeDeadline = beforeDeadline;
    }

    public Date getAfterDeadlineDate() {
        return afterDeadlineDate;
    }

    public void setAfterDeadlineDate(Date afterDeadlineDate) {
        this.afterDeadlineDate = afterDeadlineDate;
    }

    public Date getBeforeDeadlineDate() {
        return beforeDeadlineDate;
    }

    public void setBeforeDeadlineDate(Date beforeDeadlineDate) {
        this.beforeDeadlineDate = beforeDeadlineDate;
    }

    public void transformBeforeSearching(){
        afterDeadlineDate = Util.strToDate(afterDeadline);
        beforeDeadlineDate = Util.strToDate(beforeDeadline);
    }
}
