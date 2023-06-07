package com.codegym.hotelmanagement.repository;

import com.codegym.hotelmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE username = :username")
//    Optional<User> checkUser(@Param("username") String username);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE username = :username")
    User checkUser(@Param("username") String username);

    @Query(nativeQuery = true,value = "SELECT * FROM user WHERE username =:#{#user.username} AND password =:#{#user.password} ")
    Optional<User> checkUserIsValid(@Param("user") User user);

}
