package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.dto.LoginInfo;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String handleGreeting() {
        return "greeting";
    }


}
