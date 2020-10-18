package com.and.demo.webappall.base.dao;
/*
create TABLE todo_list (
   tdl_id INT NOT NULL AUTO_INCREMENT,
   description VARCHAR(200) NOT NULL,
   deadline DATE NOT NULL,
   status INT NOT NULL,
   importance INT NOT NULL,
   PRIMARY KEY ( tdl_id )

) ENGINE=InnoDB CHARACTER SET utf8;

 private int id;
    private String description;
    private Date deadline;
    private int importance;
    private int status;
 */


import com.and.demo.webappall.base.domain.Job;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JobDao {
    @Select("SELECT tdl_id AS id, description, deadline , status , importance FROM todo_list")
    List<Job> getAll();

    @Insert("INSERT INTO todo_list(description,deadline,status,importance) VALUES" +
            " (#{description},#{deadline},#{status},#{importance})" )
    int saveJob(Job j);


}

