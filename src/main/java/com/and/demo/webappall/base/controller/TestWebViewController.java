package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.converter.JobDtoDaoConverter;
import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.JobForm;
import com.and.demo.webappall.base.dto.LoginInfo;
import com.and.demo.webappall.base.dto.MyDTObject;
import com.and.demo.webappall.base.service.JobManagementService;
import com.and.demo.webappall.base.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class TestWebViewController {

    private JobManagementService jobManagementService;

    LoginFormValidator loginFormValidator;
    @Autowired
    public void setup(JobManagementService jobManagementService,
                      LoginFormValidator loginFormValidator ){
        this.jobManagementService = jobManagementService;
        this.loginFormValidator = loginFormValidator;
    }

    // A simple example of how data is transmitted to
    @GetMapping("/t")
    public ModelAndView index(ModelAndView  mv ) {

        // Add a String output
        mv.addObject("message", "From Server");
        mv.addObject("staff",new MyDTObject("Anderson","Engineer",1,"M"));
        mv.addObject("myList", jobManagementService.getListOfHM());
        mv.addObject("uiSettings", jobManagementService.getUISettings());
        mv.addObject("staffList", jobManagementService.getStaffList());
        mv.setViewName("testtmf"); // templates/testtmf.html

        return mv;
    }

    @GetMapping(value="/main")
    public ModelAndView getDefaultPage(ModelAndView mv) {
        System.out.println("/main called");

        List<Job> allJobs = jobManagementService.getAllJobs();
        allJobs.forEach(job -> {
                    job.postProcess();
        });
        mv.addObject("todoList",allJobs);
        mv.addObject("jobForm", new JobForm());
        mv.setViewName("main");
        return mv;
    }
    //https://stackoverflow.com/questions/43079276/how-to-use-redirect-in-modelandview

    @PostMapping(value="/main")
    public String handleDefaultPageSubmit
            ( @ModelAttribute("jobForm") JobForm jobForm,
                                   BindingResult bindingResult) {
        // TODO : form validation
        //loginFormValidator.validate(loginInfo,bindingResult);
        //if (bindingResult.hasErrors()) {
        //    return "login";
        //}
        if ( "create".equals(jobForm.getActionName())) {
            Job myJob = JobDtoDaoConverter.getJobDaoFromJobForm(jobForm);
            myJob.dump();
            boolean isSavingOK = jobManagementService.saveJob(myJob);
            System.out.println("Save Job result : " + isSavingOK);
        } else if ( "delete".equals(jobForm.getActionName())) {
            System.out.println("Going to delete job with Id " + jobForm.getId() );
            int result = jobManagementService.deleteJobById(jobForm.getId());
            System.out.println("job delete result " + result );
        } else {
            System.out.println("unknown action");
        }
        return "redirect:/main";
    }



    @GetMapping(value="/landing")
    public ModelAndView getLandingPage(ModelAndView mv) {
        System.out.println("/landing called");
        mv.addObject("todoList", jobManagementService.getAllJobs());
        mv.setViewName("landing");
        return mv;
    }

    // demonstration of form data submit.
    @GetMapping(value="/login")
    public String getLoginPage(Model m) {
        m.addAttribute("loginInfo",new LoginInfo());
        return "login";
    }


    @GetMapping(value="/test_resource")
    public String getTestResourcePage(Model m) {
        return "test_resources";
    }
    /*
    @PostMapping(value="/login")
    public String handleLoginInfo( @ModelAttribute("loginInfo") LoginInfo loginInfo ,
                                    BindingResult bindingResult) {
        System.out.println("/login called with username : " + loginInfo.getUsername() +
                            " password " + loginInfo.getPassword() );
        loginFormValidator.validate(loginInfo,bindingResult);
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "redirect:/";
    }
    */



}
