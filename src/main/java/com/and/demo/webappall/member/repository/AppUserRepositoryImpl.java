package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AppUserRepositoryImpl implements AppUserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public void customMethod(){}


}
