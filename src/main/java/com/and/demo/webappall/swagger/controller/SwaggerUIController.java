package com.and.demo.webappall.swagger.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.exception.AppResourceNotFoundException;
import com.and.demo.webappall.base.object.AppAPIResponse;
import com.and.demo.webappall.swagger.dto.RegistrationRequest;
import com.and.demo.webappall.swagger.dto.RegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/swaggerAPI")
public class SwaggerUIController {
    @PostMapping(value = "/swaggerTest1/{id}",produces = "application/json; charset=utf-8")
    @Tag(name = "Member", description = "Member account information")
    public RegistrationResponse swaggerTest(@PathVariable("id") int jobId,
                                            @RequestBody RegistrationRequest regRequest ) {
        // demo
        return new RegistrationResponse();
    }


    @GetMapping(value = "/swaggerTest2",produces = "application/json; charset=utf-8")
    @Tag(name = "Registration", description = "Visitor registration")
    public RegistrationResponse doingNothing () {
        // demo
        return new RegistrationResponse();
    }

}
