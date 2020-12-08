
package com.and.demo.webappall.mongo.controller;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.util.DateUtil;
import com.and.demo.webappall.mongo.model.Employee;
import com.and.demo.webappall.mongo.repository.EmployeeDAO;
import com.and.demo.webappall.mongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// for demonstration of
@RestController
public class MongoDBTestController {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDAO employeeDAO;

    // for simplicity , just ignore the service layer
    @RequestMapping(value = "/api/mongo/getEmployee/staffId/{staffId}/status/{status}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public Employee getEmployeeByStaffId(@PathVariable String staffId,
                                         @PathVariable int status
                                         ) {

        // this default built-in method can give the following result
       //Employee e = employeeRepository.findByStaffId(staffId);
       //{"id":"5fcddd0475c0680a81143d2a","name":"Anderson","joinDate":null,"staffId":"ABC111"}


        return null;
    }


    @RequestMapping(value = "/api/mongo/getEmployeeTest/{testCase}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public Employee getEmployeeByStaffId(@PathVariable int testCase) {

        // this default built-in method can give the following result
        //Employee e = employeeRepository.findByStaffId(staffId);
        //{"id":"5fcddd0475c0680a81143d2a","name":"Anderson","joinDate":null,"staffId":"ABC111"}
        if( testCase == 1 ) {
            Employee e= employeeRepository.getByActiveStaffInfoJoinOnBetween( "ABC111" ,
                    DateUtil.addDay(new Date(),-1),
                     new Date());
            if(e==null) System.out.println("get nothing for employee");
            return e;
        } else if ( testCase == 2 ){
            List<Employee> employeeList = employeeDAO.getAllActiveEmployee();
            if ( employeeList != null && employeeList.size() > 0 ){
                return employeeList.get(0);
            }
        } else if ( testCase == 3 ){
            employeeDAO.updateEmployee();
        }

        return null;
    }



    @RequestMapping(value = "/api/mongo/createNewEmployee", method = RequestMethod.GET)
    @ResponseBody
    public String createNewEmployee() {
        employeeRepository.save(new Employee("Anderson","ABC111",2));
        return "OK";
        //MongoDB Enterprise atlas-qpc5wp-shard-0:PRIMARY> db.employee.find()
        //{ "_id" : ObjectId("5fcddd0475c0680a81143d2a"), "name" : "Anderson", "staffId" :
        //    "ABC111", "_class" : "com.and.demo.webappall.mongo.model.Employee" }

    }
}
