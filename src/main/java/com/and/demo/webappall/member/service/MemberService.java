package com.and.demo.webappall.member.service;

import com.and.demo.webappall.member.domain.AppUser;

import java.util.List;

public interface MemberService {
    List<AppUser> getAllActiveAppUsers();

}
