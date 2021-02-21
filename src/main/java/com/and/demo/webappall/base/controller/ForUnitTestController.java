package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.UnitTestRequest;
import com.and.demo.webappall.base.exception.AppResourceNotFoundException;
import com.and.demo.webappall.base.object.AppAPIResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ForUnitTestController {

    @RequestMapping(value = "/api/unittest/list/{type}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public ResponseEntity<AppAPIResponse> bookInfo3(@PathVariable("type") String type,
    @RequestBody UnitTestRequest jsonBodyRequest ) {
        // pretend calling service layer
        if ("work".equals(type) && "work".equals(jsonBodyRequest.getType())) {
            Job myJob1 = new Job();
            myJob1.setId(1);
            Job myJob2 = new Job();
            myJob1.setId(2);
            List<Job> jobList = new ArrayList<>();
            jobList.add(myJob1);
            AppAPIResponse response = new AppAPIResponse("OK", "no problem", jobList);
            return new ResponseEntity<AppAPIResponse>(response, HttpStatus.OK);
        } else {
            AppAPIResponse response = new AppAPIResponse("UNKNOWN_PARARM", "unknown param for type", null);
            return new ResponseEntity<AppAPIResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
