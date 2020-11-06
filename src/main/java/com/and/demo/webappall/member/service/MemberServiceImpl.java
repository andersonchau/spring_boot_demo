package com.and.demo.webappall.member.service;

import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    AppUserRepository appUserRepository;

    public List<AppUser> getAllActiveAppUsers() {
        return appUserRepository.findByStatusActive();
    }
    
}
