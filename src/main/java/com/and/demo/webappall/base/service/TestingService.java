package com.and.demo.webappall.base.service;

import com.and.demo.webappall.base.dto.MyDTObject;
import com.and.demo.webappall.base.dto.UISettings;

import java.util.List;
import java.util.Map;

public interface TestingService {
    List<Map<String, Object>>  getListOfHM();
    List<MyDTObject> getStaffList();
    UISettings getUISettings();
}
