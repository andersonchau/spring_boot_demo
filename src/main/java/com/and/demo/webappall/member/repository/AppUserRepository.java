package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.repository.AppUserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser,Long>, AppUserRepositoryCustom {
    // notes, method without body not put to AppUserRepositoryImpl.java but here for

    @Query("SELECT n FROM AppUser n WHERE n.status = 1")
    List<AppUser> findByStatusActive();

}
