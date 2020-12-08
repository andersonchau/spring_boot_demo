package com.and.demo.webappall.mongo.repository;

import com.and.demo.webappall.mongo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //https://www.devglan.com/spring-boot/spring-data-mongodb-queries
    public List<Employee> getAllActiveEmployee() {
        BasicQuery query = new BasicQuery("{ staffId : { $eq : 'ABC111' } }");
        List<Employee> result = mongoTemplate.find(query, Employee.class);
        return result;
    }

    public void updateEmployee() {
        BasicQuery query = new BasicQuery("{ staffId : { $eq : 'ABC111' } }");
        BasicUpdate update = new BasicUpdate("{$set:{staffId:'YYYYYYY'}}");
        mongoTemplate.findAndModify(query,update,Employee.class);
    }


    private final MongoTemplate mongoTemplate;

    @Autowired
    public EmployeeDAOImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
