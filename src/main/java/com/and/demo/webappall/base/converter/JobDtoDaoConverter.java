package com.and.demo.webappall.base.converter;

import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.JobForm;

public class JobDtoDaoConverter {
    public static Job getJobDaoFromJobForm(JobForm jf) {
        Job j = new Job();
        j.setId(jf.getId());
        j.setImportance(jf.isImportance() ? 2 : 1);
        j.setStatus(jf.getStatus());
        j.setDescription(jf.getDescription());
        return j;
    }

}
