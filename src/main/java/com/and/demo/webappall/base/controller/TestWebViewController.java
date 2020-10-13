package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.dto.LoginInfo;
import com.and.demo.webappall.base.dto.MyDTObject;
import com.and.demo.webappall.base.service.TestingService;
import com.and.demo.webappall.base.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestWebViewController {

    private TestingService testingService;

    LoginFormValidator loginFormValidator;
    @Autowired
    public void setup(TestingService testingService,
                      LoginFormValidator loginFormValidator ){
        this.testingService = testingService;
        this.loginFormValidator = loginFormValidator;
    }

    // A simple example of how data is transmitted to
    @GetMapping("/t")
    public ModelAndView index(ModelAndView  mv ) {

        // Add a String output
        mv.addObject("message", "From Server");
        mv.addObject("staff",new MyDTObject("Anderson","Engineer",1,"M"));
        mv.addObject("myList", testingService.getListOfHM());
        mv.addObject("uiSettings",testingService.getUISettings());
        mv.addObject("staffList", testingService.getStaffList());
        mv.setViewName("testtmf"); // templates/testtmf.html

        return mv;
    }

    // demonstration of form data submit.
    @RequestMapping(value="/login")
    public String getLoginPage(Model m) {
        m.addAttribute("loginInfo",new LoginInfo());
        return "login";
    }
    
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


}