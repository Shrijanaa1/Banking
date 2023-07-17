package com.example.Banking.Repository;

import com.example.Banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //user define method since deleteById not present

//    void deleteCustomerById(Long id);
//    Optional<User> findCustomerById(Long id);
    public User findByUserName(String userName);

    @Query("select u from User u where u.userEmail =: userEmail")
    public User getUserByUsername(@Param("userEmail") String userEmail);

}
