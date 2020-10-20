package com.and.demo.webappall.base.service;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.JobForm;
import com.and.demo.webappall.base.dto.JobSearchForm;
import com.and.demo.webappall.base.dto.MyDTObject;
import com.and.demo.webappall.base.dto.UISettings;

import java.util.List;
import java.util.Map;

public interface JobManagementService {
    List<Map<String, Object>>  getListOfHM();
    List<MyDTObject> getStaffList();
    UISettings getUISettings();
    List<Job> getAllJobs();
    List<Job> searchJob(JobSearchForm jf);
    boolean saveJob(Job j);
    int deleteJobById(int id);

}
