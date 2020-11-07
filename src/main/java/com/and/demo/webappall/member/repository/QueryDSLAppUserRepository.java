package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryDSLAppUserRepository extends
        JpaRepository<AppUser, Integer>,
        QuerydslPredicateExecutor<AppUser>,
        QueryDSLAppUserRepositoryCustom {
    
}
