package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryDSLAppUserRepositoryCustom {


     AppUser getAppUserByUserNameAndPassword(String username,
                                             String password);

     List<AppUser> findAll2();

     //QueryResults<AppUser> findAllPage(Pageable pageable);
}