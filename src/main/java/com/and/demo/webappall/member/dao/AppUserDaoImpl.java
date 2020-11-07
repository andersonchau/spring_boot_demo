package com.and.demo.webappall.member.dao;

import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.domain.QAppUser;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class AppUserDaoImpl implements AppUserDao {
    @PersistenceContext
    private EntityManager em;
    // ref :https://github.com/eugenp/tutorials/blob/master/persistence-modules/querydsl/src/main/java/com/baeldung/dao/PersonDaoImpl.java


    public AppUser save(AppUser a) {
        em.persist(a);
        return a;
    }

    public List<AppUser> findAppUsersByNameQueryDSL(String name) {
        final JPAQuery<AppUser> query = new JPAQuery<>(em);
        final QAppUser appUser = QAppUser.appUser;
        return query.from(appUser).where(appUser.name.eq(name)).fetch();
    }

    public List<AppUser> findAppUsersByNameOrEmailQueryDSL(String name, String email) {
        final JPAQuery<AppUser> query = new JPAQuery<>(em);
        final QAppUser appUser = QAppUser.appUser;
        // status = 1 AND ( name = 'name' OR email = 'email' )
        return query.from(appUser).where(appUser.status.eq(1).and(appUser.name.eq(name).or(appUser.email.eq(email)))).fetch();
    }



    public Long findMaxAge() {
        final JPAQuery<AppUser> query = new JPAQuery<>(em);
        final QAppUser appUser = QAppUser.appUser;

        return query.from(appUser)
                .select(appUser.id.min())
                .where(appUser.status.eq(1))
                .fetchFirst();
    }

    public Map<String, Integer> findMaxAgeByName() {
        return null;
    }

}
