package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User>findAll();
    User findByName(String name);
    List<User> findUsersByName(String name);
//    List<User>findAllOrderByAgeDesc();
    List<User>findUserByNameIgnoreCase(String name);

    @Override
    void delete(User entity);

    @Query(value = " delete from User where id=:#{#user.id}" , nativeQuery=true)
    @Modifying
    void deleteSelf(@Param("user") User user);
}
