package com.and.demo.webappall.base.service;

import com.and.demo.webappall.base.dao.JobDao;
import com.and.demo.webappall.base.domain.Job;
import com.and.demo.webappall.base.dto.MyDTObject;
import com.and.demo.webappall.base.dto.UISettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestingServiceImpl implements TestingService {

    @Autowired
    private JobDao jobDao;

    @Override
    public List<MyDTObject> getStaffList() {
        List<MyDTObject> staffList = new ArrayList<MyDTObject>();
        staffList.add(new MyDTObject("Anderson", "Engineer", 1, "M"));
        staffList.add(new MyDTObject("Jimmy", "Engineer", -10, "F"));
        staffList.add(new MyDTObject("David", "Engineer", 29, "M"));
        return staffList;
    }

    @Override
    public UISettings getUISettings() {
        return new UISettings(0, 20);
    }

    @Override
    public List<Map<String, Object>> getListOfHM() {
        // Assume this is loaded from DB
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("name", "name1");
        m.put("age", "1");
        list.add(m);

        m = new HashMap<String, Object>();
        m.put("name", "name2");
        m.put("age", "2");
        list.add(m);

        m = new HashMap<String, Object>();
        m.put("name", "name3");
        m.put("age", "3");
        list.add(m);

        m = new HashMap<String, Object>();
        m.put("name", "name4");
        m.put("age", "4");
        list.add(m);

        m = new HashMap<String, Object>();
        m.put("name", "name5");
        m.put("age", "5");
        list.add(m);

        return list;
    }

    public List<Job> getAllJobs() {
        return jobDao.getAll();
    }

    public boolean saveJob(Job j) {
        return jobDao.saveJob(j)==1;
    }


}
