package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.DummyWebResponse;
import com.and.demo.webappall.base.dto.JobForm;
import com.and.demo.webappall.base.dto.JobSearchForm;
import com.and.demo.webappall.base.service.JobManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoAppRestController {

    @Autowired
    JobManagementService jobManagementService;

    @RequestMapping(value = "/api/greeting", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public DummyWebResponse handleGreeting() {
        return new DummyWebResponse("message from /api/greeting");
    }


    @RequestMapping(value = "/webapi/greeting", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public DummyWebResponse handleGreetingWeb() {

        return new DummyWebResponse("message from /webapi/greeting");
    }

    @RequestMapping(value = "/api/getAllJobs", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Job> getAllJobs() {
        System.out.println("/api/getAllJobs get called");
        return jobManagementService.getAllJobs();
        //[{"id":1,"description":"清理房間","deadline":"2020-10-16T16:00:00.000+00:00","importance":1,"status":1},{"id":2,"description":"交電費","deadline":"2020-10-17T16:00:00.000+00:00","importance":2,"status":1}]
        // TODO : wrap with ResponseEntity or ReplyObject.
        // Exception Handling
    }
    
    @RequestMapping(value = "/api/searchJob", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Job> getAllJobs(@RequestBody JobSearchForm jf) {
        System.out.println("/api/searchJob get called");
        //[{"id":1,"description":"清理房間","deadline":"2020-10-16T16:00:00.000+00:00","importance":1,"status":1},{"id":2,"description":"交電費","deadline":"2020-10-17T16:00:00.000+00:00","importance":2,"status":1}]
        // TODO : wrap with ResponseEntity or ReplyObject.
        // Exception Handling
        return jobManagementService.searchJob(jf);
    }




}
