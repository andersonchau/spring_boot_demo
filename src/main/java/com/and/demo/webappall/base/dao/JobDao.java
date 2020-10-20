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
import com.and.demo.webappall.base.dto.JobForm;
import com.and.demo.webappall.base.dto.JobSearchForm;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface JobDao {
    // TODO : mapping as resultMap
    @Select("SELECT tdl_id AS id, description, deadline , status , importance FROM todo_list")
    List<Job> getAll();

    @Insert("INSERT INTO todo_list(description,deadline,status,importance) VALUES" +
            " (#{description},#{deadline},#{status},#{importance})" )
    int saveJob(Job j);

    @Delete("DELETE FROM todo_list where tdl_id = #{id}")
    int deleteJobById(@Param("id") int jobId );

    // demonstration of dynamic SQL
    @Select("<script>" +
            "SELECT tdl_id AS id, description, deadline , status , importance FROM todo_list "
            + "<where> "
            + " <if test='status == 1 or status == 2'> "
            + "   and status = #{status}          "
            + " </if> "
            + " <if test='beforeDeadline != null and beforeDeadline != &quot;&quot; '> "
            + "  and #{beforeDeadline} &lt;   deadline "
            + " </if> "
            + " <if test='afterDeadline != null and afterDeadline != &quot;&quot; '> "
            + "  and #{afterDeadline} &gt;  deadline "
            + " </if> "
            + "  <if test='description != null and description != &quot;&quot;'> "
            + "    and description like CONCAT('%', #{description}, '%')       "
            + "  </if> "
            + "</where> "
            + "</script>" )
    List<Job> searchJob(JobSearchForm jf);

}

