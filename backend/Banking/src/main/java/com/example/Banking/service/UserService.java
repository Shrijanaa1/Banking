package com.example.Banking.service;

import com.example.Banking.model.User;
import com.example.Banking.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
//    List<User> getAllCustomer();
//    User findCustomerById(Long id);
//    User addCustomer(User customer);
//    User updateCustomer(User customer);
//    void deleteCustomer(Long id);

    //creating user
    //now we have roles,so we have to pass the roles as well.
    public User addUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String userName);

    List<User> getAllUser();

    void deleteUser(Long userId);

    public User updateUser(User userId);

    public int loginValidation(String email, String password);

}