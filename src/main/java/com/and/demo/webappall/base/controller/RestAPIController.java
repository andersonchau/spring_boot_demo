package com.and.demo.webappall.base.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.exception.AppResourceNotFoundException;
import com.and.demo.webappall.base.object.AppAPIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class RestAPIController {
    // Some guidelines :
    // GET -> Read, POST -> Create, PUT and PATCH -> Update, DELETE -> Delete.
    // resources name as URI path
    // 200 accepted, 400 bad request, 401 unauthorized ( not authenticated )
    // 402 forbidden ( authenticated but not enough permission )
    // 404 resource not found, 5xx server internal error
    // GET: 200 OK, POST: 201 Created
    // PUT: 200 OK. PATCH: 200 OK, DELETE: 204 No Content
    // https://www.toptal.com/java/spring-boot-rest-api-error-handling
    // https://www.baeldung.com/exception-handling-for-rest-with-spring
    //https://stackoverflow.com/questions/36733254/spring-boot-rest-how-to-configure-404-resource-not-found


    @RequestMapping(value = "/api/job/{id}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public ResponseEntity<AppAPIResponse> bookInfo3(@PathVariable("id") int jobId) {
        // just demonstration of error handling
        if ( jobId == 1) {
            // assume service here
            Job j = new Job();
            j.setId(1);
            // returns something like {"status":"OK","errDescription":"OK","response":{"id":1,"description":null,"deadline":null,"importance":0,"status":0,"deadlineStr":null}}
            return ResponseEntity.accepted().body(
                    new AppAPIResponse("OK", "OK",j)
            );
        } else{
            // assume the service is optional orElse OR just return 0
            throw new AppResourceNotFoundException("Not found job resource");
        }

    }

    @ExceptionHandler(AppResourceNotFoundException.class)
    public ResponseEntity<AppAPIResponse> handleAppResourceNotFound(AppResourceNotFoundException e) {
        // {"status":"ERROR","errDescription":"Not found job resource","response":null} 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new AppAPIResponse("ERROR", e.getMessage(), null));
    }
}
