package com.and.demo.webappall.member.dao;

import com.and.demo.webappall.member.domain.AppUser;

import java.util.List;
import java.util.Map;

public interface AppUserDao {
    public AppUser save(AppUser a);

    public List<AppUser> findAppUsersByNameQueryDSL(String name);

    public List<AppUser> findAppUsersByNameOrEmailQueryDSL(String name, String email);

    public Long findMaxAge();

    public Map<String, Integer> findMaxAgeByName();
}
