package com.and.demo.webappall.base.converter;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.JobForm;

import java.text.SimpleDateFormat;

public class JobDtoDaoConverter {
    public static Job getJobDaoFromJobForm(JobForm jf) {
        Job j = new Job();
        j.setId(jf.getId());
        j.setImportance(jf.isImportance() ? 2 : 1);
        j.setStatus(jf.getStatus());
        j.setDescription(jf.getDescription());
        if(jf.getDeadline() != null ) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                j.setDeadline(sdf.parse(jf.getDeadline()));
            } catch (Exception ex ){}
        }
        return j;
    }


}
