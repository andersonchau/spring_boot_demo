package com.and.demo.webappall.member.repository;

import com.and.demo.webappall.member.domain.AppUser;
import com.and.demo.webappall.member.domain.QAppUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class QueryDSLAppUserRepositoryImpl implements
        QueryDSLAppUserRepositoryCustom {


    // good reference : https://www.cnblogs.com/jpfss/p/11003964.html

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    public AppUser getAppUserByUserNameAndPassword(String username,
                                                   String password) {
        QAppUser appUser = QAppUser.appUser;
        return jpaQueryFactory
                .selectFrom(appUser)
                .where(
                        appUser.appUserCredential.username.eq(username),
                        appUser.appUserCredential.password.eq(password)
                )
                .fetchOne();
    }

    public List<AppUser> findAll2() {
        QAppUser appUser = QAppUser.appUser;
        return jpaQueryFactory
                .selectFrom(appUser)
                .orderBy(
                        appUser.joinDate.asc()
                )
                .fetch();
    }

    /* Other similar examples
    jpaQueryFactory.selectFrom(user).where(user.birthday.between(start, end)).fetch();
    jpaQueryFactory.selectFrom(user).where(user.birthday.between(start, end) ).fetch();
    // findAll() is in QuerydslPredicateExecutor
     List<User> users = (List<User>) userRepository.findAll(
                user.nickName.eq(nickName)
                        .and(user.username.eq(username)),
                user.uIndex.asc() //
        );
        // findAll() is in QuerydslPredicateExecutor
      List<User> users = (List<User>) userRepository.findAll(
                user.nickName.eq(nickName)
                        .and(user.username.eq(username)),
                user.uIndex.asc()
        );


        // return QueryResults<AppUsers> , for pagnition
        return jpaQueryFactory
                .selectFrom(user)
                .orderBy(
                        user.uIndex.asc()
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

           // Projections to convert another type , e.g. DTO
           List<AppUserDTO> dtoList = jpaQueryFactory
                .select(
                        Projections.bean(
                                AppUserDTO.class,
                                user.username,
                                user.userId,
                                user.nickName,
                                user.birthday
                        )
                )
                .from(user)
                .fetch();
            userRepository.count( user.nickName.like("%" + likeName + "%")
        );

        ======================================================
        function (Pageable pageable, String username, String password, String nickName, Date birthday, BigDecimal uIndex)
        Using ExpressionUtils to change all predicates,

        Predicate predicate = user.isNotNull().or(user.isNull());

        predicate = username == null ? predicate : ExpressionUtils.and(predicate,user.username.eq(username));
        predicate = password == null ? predicate : ExpressionUtils.and(predicate,user.password.eq(password));
        predicate = nickName == null ? predicate : ExpressionUtils.and(predicate,user.nickName.eq(username));
        predicate = birthday == null ? predicate : ExpressionUtils.and(predicate,user.birthday.eq(birthday));
        predicate = uIndex == null ? predicate : ExpressionUtils.and(predicate,user.uIndex.eq(uIndex));

        Page<User> page = userRepository.findAll(predicate, pageable);
        =====================================================
        // Group By + having Example :
         List<User> list = jpaQueryFactory
                .selectFrom(user)
                .where(predicate)  // predicates chaining us
                .orderBy(user.userId.asc())
                .groupBy(user.uIndex)
                .having(user.uIndex.longValue().max().gt(7))
                .fetch();

     */

    //https://www.cnblogs.com/jpfss/p/11003964.html



    


}




