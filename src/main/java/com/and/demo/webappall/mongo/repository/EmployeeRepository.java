package com.and.demo.webappall.mongo.repository;

import com.and.demo.webappall.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeRepository  extends MongoRepository<Employee, String> {
    //public Customer findByFirstName(String firstName);
    //public List<Customer> findByLastName(String lastName);
    public Employee findByStaffId(String staffId);

    @Query("{'staffId' : ?0}")
    Employee getByStaffIdCustom(String staffId );
    // list<Employee> for safety

    // @Query("{'staffId' : ?0}")
    @Query("{'$and': [{'staffId': ?0}, {'status': 1}]},{'joinDate': {'$gte': ?1, '$lte': ?2}}]")
    Employee getByActiveStaffInfoJoinOnBetween(String staffId ,
                                                 Date dateStart,
                                               Date dateEnd );
    


    /*
    ref : https://gist.github.com/ntub46010/b4b216d890e9c6c45cfecd806713ed8d#file-spring-boot-tutorial-8g-java
other examples
 @Query("{'price': {'$gte': ?0, '$lte': ?1}}")
List<Product> findByPriceBetween(int from, int to);

@Query("{'name': {'$regex': ?0, '$options': 'i'}}")
List<Product> findByNameLikeIgnoreCase(String name);

    @Query("{'$and': [{'price': {'$gte': ?0, '$lte': ?1}}, {'name': {'$regex': ?2, '$options': 'i'}}]}")
List<Product> findByPriceBetweenAndNameLikeIgnoreCase(int priceFrom, int priceTo, String name);

// 回傳id欄位值有包含在參數之中的文件數量
@Query(value = "{'_id': {'$in': ?0}}", count = true)
int countByIdIn(List<String> ids);

// 回傳是否有文件的id欄位值包含在參數之中
@Query(value = "{'_id': {'$in': ?0}}", exists = true)
boolean existsByIdIn(List<String> ids);

// 刪除id欄位值包含在參數之中的文件
@Query(delete = true)
void deleteByIdIn(List<String> ids);

// 找出id欄位值有包含在參數之中的文件，並先後做name欄位遞增與price欄位遞減的排序
@Query(sort = "{'name': 1, 'price': -1}")
List<Product> findByIdInOrderByNameAscPriceDesc(List<String> ids);

    */

}