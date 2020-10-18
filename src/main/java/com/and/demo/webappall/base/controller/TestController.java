package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.service.JobManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    JobManagementService jobManagementService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String handleGreeting() {
        return "greeting";
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



}
