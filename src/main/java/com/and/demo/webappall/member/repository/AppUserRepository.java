package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.repository.AppUserRepositoryCustom;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends
        JpaRepository<AppUser,Long>,
        AppUserRepositoryCustom {
    // All Auto-generated query method put here
    // notes, method without body not put to AppUserRepositoryImpl.java but here for
    // ref : https://openhome.cc/Gossip/EJB3Gossip/JPQLABC.html
    // ref : https://en.wikibooks.org/wiki/Java_Persistence/JPQL
    // Some examples of JPQL :
    // TODO : test
    // =====================================================================
    // =====================================================================
    // =====================================================================
    @Query("SELECT n FROM AppUser n WHERE n.status = 1")
    List<AppUser> findByStatusActive();

    @Query("SELECT n FROM AppUser n WHERE n.status = :status AND n.name = :myName")
    List<AppUser> findByStatusActiveWithParam(
            @Param("myName") String name,
            @Param("status") int status
    );

    @Query(
            value = "SELECT * FROM app_user u WHERE u.status = 1",
            nativeQuery = true)
    List<AppUser> findByStatusActiveNative();

    // use JOIN FETCH instead of JOIN if want a.appUserCredential object is to be returned.
    @Query("Select n FROM AppUser n JOIN n.appUserCredential a " +
            " WHERE a.username = :loginName")
    List<AppUser> getAppUserByLoginName( @Param("loginName") String loginName);
    // =====================================================================
    // =====================================================================
    // =====================================================================
    // Some examples of
    // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/
    Optional<AppUser> findById(Long id);

    long countByStatus(int status);

    List<AppUser> findDistinctByStatus(int status);

    List<AppUser> findTop3ByStatusOrderByNameAsc(String title);

    List<AppUser> findByNameContainsOrEmailContainsAllIgnoreCase(String name,
                                                                    String email);
    // ================================================


}

