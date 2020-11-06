package com.and.demo.webappall.member.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.JobSearchForm;
import com.and.demo.webappall.base.service.JobManagementService;
import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/api/testSpringData", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllJobs() {
        List<AppUser> appUserList = memberService.getAllActiveAppUsers();
        if(appUserList != null && appUserList.size() >0 ) {
            AppUser au = appUserList.get(0);

            System.out.println("Name : " + au.getName() );
            if ( au.getAppUserCredential() != null ) {
                String p = au.getAppUserCredential().getPassword();
                System.out.println("Password : " + p );
            }
        }
        return "OK";
    }

}
